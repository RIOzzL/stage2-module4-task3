package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mjc.stage2.entity.TextComponentType.SENTENCE;
import static com.mjc.stage2.entity.TextComponentType.WORD;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    private static final Pattern WORD_PATTER = Pattern.compile(WORD_REGEX);

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType() == SENTENCE) {
            String[] lexemes = string.split(LEXEME_REGEX);
            for (String lexeme : lexemes) {
                AbstractTextComponent textComponent;
                Matcher wordMatcher = WORD_PATTER.matcher(lexeme);
                if (wordMatcher.find() && nextParser != null) {
                    textComponent = new TextComponent(WORD);
                    nextParser.parse(textComponent, lexeme);
                } else {
                    textComponent = new SymbolLeaf(lexeme.charAt(0));
                }
                abstractTextComponent.add(textComponent);
            }
        } else if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }
}

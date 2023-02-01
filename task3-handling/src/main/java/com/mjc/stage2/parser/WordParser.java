package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

import static com.mjc.stage2.entity.TextComponentType.WORD;

public class WordParser extends AbstractTextParser {

    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType() == WORD) {
            for (char c : string.toCharArray()) {
                abstractTextComponent.add(
                        new SymbolLeaf(c)
                );
            }
        } else if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }

    @Override
    protected void setNextParser(AbstractTextParser nextParser) {
        super.setNextParser(nextParser);
    }
    // Write your code here!

}

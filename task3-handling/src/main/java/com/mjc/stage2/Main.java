package com.mjc.stage2;

import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.parser.AbstractTextParser;
import com.mjc.stage2.parser.ChainParserBuilder;
import com.mjc.stage2.parser.LexemeParser;
import com.mjc.stage2.parser.WordParser;

public class Main {
    public static void main(String[] args) {
        ChainParserBuilder chainParserBuilder = new ChainParserBuilder();
        chainParserBuilder.setParser(new LexemeParser());
        chainParserBuilder.setParser(new WordParser());
        AbstractTextParser build = chainParserBuilder.build();

        String s = "It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?";

        TextComponent textComponent = new TextComponent(TextComponentType.SENTENCE);

        build.parse(textComponent, s);

        System.out.println(textComponent.operation());
    }
}

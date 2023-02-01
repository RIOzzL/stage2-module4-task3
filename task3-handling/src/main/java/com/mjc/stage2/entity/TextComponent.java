package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            builder
                    .append(component.operation())
                    .append(componentType.getDelimiter());
        }
        return builder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        size = componentList.size();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
        size = componentList.size();
    }

    @Override
    public int getSize() {
        return componentList.size();
    }

    public List<AbstractTextComponent> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<AbstractTextComponent> componentList) {
        this.componentList = componentList;
    }

    // Write your code here!
}

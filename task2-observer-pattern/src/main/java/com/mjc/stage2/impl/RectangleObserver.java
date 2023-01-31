package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {

    @Override
    public void handleEvent(RectangleEvent event) {
        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        Rectangle source = event.getSource();

        int id = source.getId();
        double rectangleSquare = source.getSideA() * source.getSideB();
        double rectanglePerimeter = source.getSideA() * 2 + source.getSideB() * 2;
        RectangleValues rectangleValues = warehouse.get(id);
        if (rectangleValues != null) {
            rectangleValues.setSquare(rectangleSquare);
            rectangleValues.setPerimeter(rectanglePerimeter);
        } else {
            warehouse.put(id, new RectangleValues(rectangleSquare, rectanglePerimeter));
        }
    }
    // Write your code here!
}

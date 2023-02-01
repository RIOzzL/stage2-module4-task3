package com.mjc.stage2;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 2);
        System.out.println(RectangleWarehouse.getInstance().get(1).getPerimeter());

        rectangle.setSideA(3);
        System.out.println(RectangleWarehouse.getInstance().get(1).getPerimeter());
    }
}

package com.company;

import Elements.Element;

public class Location {
    private int x;
    private int y;
    private String name;
    private TerrainMap map;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) { this.x = x;}

    public int getX() { return this.x; }

    public void setY(int y) { this.y = y; }

    public int getY() { return this.y; }

    public void setName(String name) { this.name = name; }

    public class Move {
        public void goTo(Element element) {
            System.out.println("Go to " + element.getElement());
            Location.this.x = element.getX();
            Location.this.y = element.getY();
            System.out.println("Сame!");
        }
    }

    public class Info {
        public void printInfo() {
            System.out.println("Hey, you are in " + Location.this.name + " now");
        }


    }

    public class Calculate {
        public boolean elementAround(int radius, Element element) {
            return (radius >= calculateTheDistance(element.getX(), element.getY())) ? true : false;
        }

        public boolean isEqual(Element element) {
            return (Location.this.getX() == element.getX() && Location.this.getY() == element.getY()) ? true : false;
        }

        private double calculateTheDistance(int x, int y) {
            double scale = Math.pow(10, 2);
            double value = Math.sqrt((Location.this.getX()-x)*(Location.this.getX()-x) + (Location.this.getY()-y)*(Location.this.getY()-y));
            double result = Math.ceil(value * scale) / scale;
            return result;
        }
    }

}


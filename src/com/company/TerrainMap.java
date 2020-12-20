package com.company;

import Elements.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TerrainMap {
    public int SIZE;
    //public int scale;
    private final ArrayList<Element> map =  new ArrayList<>(SIZE);

    private Location location;

    public void printLocation() {
        for(Element element : map) {
            if (location.getX() == element.getX() && location.getY() == element.getY()) {
                System.out.println("You are: X: " + element.getX() + " Y: " + element.getY() + " -- " + element.getElement());
            }
        }
    }

    private double calculateTheDistance(int x, int y) {
        double scale = Math.pow(10, 2);
        double value = Math.sqrt((location.getX()-x)*(location.getX()-x) + (location.getY()-y)*(location.getY()-y));
        double result = Math.ceil(value * scale) / scale;
        return result;
    }

    public void getAroundElement(int radius) {
        for(Element element : map) {
            if(radius >= calculateTheDistance(element.getX(), element.getY())) {
                System.out.println("X: " + element.getX() + " Y: " + element.getY() + " -- " + element.getElement());
            }
        }
    }

    public TerrainMap(int SIZE) {
        this.SIZE = SIZE;
    }

    public void addElementToMap(Element e) {
        this.map.add(e);
    }



    public void print() {
        Iterator<Element> m = map.iterator();
        while (m.hasNext()) {
            Element e = m.next();
            System.out.println("X: " + e.getX() + " Y: " + e.getY() + " -- " + e.getElement());
        }
    }

    public void infoMap() {
        System.out.println("It is new map. SIZE: " + SIZE);
    }

    public Element get(int num){
        return map.get(num);
    }


    @Override
    public boolean equals(Object o) {
        for(Element element : map) {
            if(o == element) return true;
            if(o == null || o.getClass() != element.getClass()) return false;

            Element e = (Element) o;
            return element.equals(e);
        }
        return true;
    }

    public ArrayList<Element> getElements() {
        return map;
    }

    public float getCafePriceSum() {
        return (float) map.stream().
                filter(x -> x.getElement().equals(Element.TypeOfElement.CAFE)).
                mapToDouble(Element::getPrice).sum();
    }

    public float getMaxPrice() {
        return (float) map.stream().
                mapToDouble(Element::getPrice).
                max().getAsDouble();
    }

    public float getAveragePrice() {
        return (float) map.stream().
                mapToDouble(Element::getPrice).
                average().getAsDouble();
    }

    public static Map<Boolean, List<ShopElement>> getGroupByCondition(List<ShopElement> e, Predicate<Element> booleanCondition) {
        return e.stream().collect(Collectors.partitioningBy(booleanCondition));
    }

    public static List<String> getMostFrequentElement(List<TerrainMap> mapList) {
        List<String> result = new ArrayList<>();
        mapList.stream()
                .flatMap(x -> x.getElements().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Element::isExpensive))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getNameElement(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

}

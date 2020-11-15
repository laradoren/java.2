package Elements;

import java.util.Objects;

public class ShopElement extends Element implements Printable {
    private String name;

    public ShopElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }


    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println("Please visit our website - https://shop.ua");
    }

    @Override
    public void print() {
        System.out.println("X: " + this.getX() + " Y: " + this.getY() + " -- " + this.getElement() + " " + this.getName());
        this.printInfo();
    }

    @Override
    public void calcDistance(int x, int y) {
        System.out.println("Distance to element: " + calculateTheDistance(x, y) + "m");
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        ShopElement shop = (ShopElement) o;
        return name.equals(shop.name) && Objects.equals(x, ((ShopElement) o).x) && Objects.equals(y, ((ShopElement) o).y);
    }

    @Override
    public String toString() {
        return "Shop";
    }

}

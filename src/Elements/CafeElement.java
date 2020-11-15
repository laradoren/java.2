package Elements;

import java.util.Objects;

public class CafeElement extends Element {
    private String name;

    public CafeElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }

    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println("Please check our menu - https://cafe.ua");
        System.out.println("Phone to order home delivery - 098 76 54 321");
    }
    @Override
    public void print() {
        System.out.println("X: " + this.x + " Y: " + this.y + " -- " + this.getElement() + " " + this.getName());
        this.printInfo();
    }
    @Override
    public void calcDistance(int x, int y) {
        System.out.println("Distance to element: " + calculateTheDistance(x, y) + "m");
    }

    @Override
    public String toString() {
        return "Cafe";
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        CafeElement cafe = (CafeElement) o;
        System.out.println(name.equals(cafe.name));
        return  name.equals(cafe.name) && Objects.equals(x, ((CafeElement) o).x) && Objects.equals(y, ((CafeElement) o).y);
    }
}

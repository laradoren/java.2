package Elements;

import java.util.Objects;

public class HouseElement extends Element implements Printable {
    private String name;

    public HouseElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }

    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println("Adress: ");
        System.out.println("Count of people: ");
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

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        HouseElement house = (HouseElement) o;
        return  name.equals(house.name) && Objects.equals(x, ((HouseElement) o).x) && Objects.equals(y, ((HouseElement) o).y);

    }

    @Override
    public String toString() {
        return "House";
    }
}

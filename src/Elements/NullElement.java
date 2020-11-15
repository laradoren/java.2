package Elements;

import java.util.Objects;

public class NullElement extends Element implements Printable {
    private String name;

    public NullElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }


    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println(" ");
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
        NullElement n = (NullElement) o;
        return Objects.equals(x, ((NullElement) o).x) && Objects.equals(y, ((NullElement) o).y);
    }

    @Override
    public String toString() {
        return "Null";
    }

}

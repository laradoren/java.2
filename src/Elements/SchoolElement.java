package Elements;

import java.util.Objects;

public class SchoolElement extends Element implements Printable {
    private String name;

    public SchoolElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }


    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println("Please check our site- https://school.ua");
        System.out.println("Count of pupils: ");
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

        SchoolElement school = (SchoolElement) o;
        return  name.equals(school.name) && Objects.equals(x, ((SchoolElement) o).x) && Objects.equals(y, ((SchoolElement) o).y);
    }

    @Override
    public String toString() {
        return "School";
    }
}

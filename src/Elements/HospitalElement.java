package Elements;

import java.util.Objects;

public class HospitalElement extends Element{
    private String name;

    public HospitalElement(int x, int y, TypeOfElement element, String name) {
        super(x, y, element);
        this.name = name;
    }

    public String getName() { return this.name; }

    private void printInfo() {
        System.out.println("Please set in queue - https://hospital.ua");
        System.out.println("Phone to register - 098 76 54 321");
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

        HospitalElement hospital = (HospitalElement) o;
        return  name.equals(hospital.name) && Objects.equals(x, ((HospitalElement) o).x) && Objects.equals(y, ((HospitalElement) o).y);
    }

    @Override
    public String toString() {
        return "Hospital";
    }
}

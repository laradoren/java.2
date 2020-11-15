package Elements;

public abstract class Element implements Printable {
    int x;
    protected int y;

    public enum TypeOfElement {
        SHOP("Shop"), HOUSE("House"), CAFE("Cafe"), HOSPITAL("Hospital"), SCHOOL("School"), NULL("Null");
        String type;
        TypeOfElement(String type) {
            this.type = type;
        }
        @Override
        public String toString() {
            return super.toString().replace('_', ' ').toLowerCase();
        }
    }

    protected TypeOfElement element;

    public Element(int x, int y, TypeOfElement element) {
        this.x = x;
        this.y = y;
        this.element = element;
    }


    public int getX() { return this.x; }


    public int getY() { return this.y; }


    public TypeOfElement getElement() { return this.element; }

    protected double calculateTheDistance(int x, int y) {
        double scale = Math.pow(10, 2);
        double value = Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));
        double result = Math.ceil(value * scale) / scale;
        return result;
    }

    public abstract void print();
    public abstract boolean equals(Object o);
    public abstract void calcDistance(int x, int y);

}

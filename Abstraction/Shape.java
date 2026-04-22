interface Shape {
    double area();
    double perimeter();
}

class Circle implements Shape {
    double r;

    Circle(double r) {
        this.r = r;

    }

    public double area() {
        return Math.PI * r * r;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }

}

class Square implements Shape {
    double s;

    Square(double s) {
        this.s = s;
    }

    public double area() {
        return s * s;
    }

    public double perimeter() {
        return 4 * s;
    }
}

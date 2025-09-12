import java.util.Scanner;
import java.lang.Math;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?

    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return 0;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
    @Override
    public double perimeter() {
        return (length + width) * 2;
    }
    // You implement the perimeter method...
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // How do you call the Rectangle constructor from here?
        super(side, side);
    }
}

class Triangle implements Polygon{
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }
    @Override
    public double area() {
        //luckily i love math, so we can use brahmaguptas formula for a cyclic degenerate quadrilateral (letting d = 0)
        double s = (a + b + c)/2;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

class Pentagon implements Polygon {
    protected double x;
    public Pentagon (double x) {
        this.x = x;
    }

    @Override
    public double area() {
        double alpha = Math.sqrt((x * x)/(2 * (1 - Math.cos(Math.toRadians(72))))); //use Law of Cosines
        return 5 * alpha * alpha * Math.sin(Math.toRadians(72))/2.0;
    }
    @Override
    public double perimeter() {
        return 5*x;
    }
}

class Hexagon implements Polygon {
    public double x;

    public Hexagon (double x) {
        this.x = x;
    }

    @Override
    public double area() {
        //these are 6 equilateral triangles, the formula for eq tri is s^2*sqrt(3/16)
        return 6 * x * x * Math.sqrt(3)/4;
    }

    @Override
    public double perimeter() {
        return 6*x;
    }

}

class Octagon implements Polygon {
    public double x;

    public Octagon(double x) {
        this.x = x;
    }

    @Override
    public double area() {
        double sincos = 1/Math.sqrt(2);
        return 8 * x * x * sincos/(4 - 4*sincos);
    }

    @Override
    public double perimeter() {
        return 8 * x;
    }
}

class EquilateralTriangle extends Triangle {

    public EquilateralTriangle (double x){
        super(x, x, x);
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle (double x, double y) {
        super(x, x, y);
    }   
}// Main class for user interface



public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Create a polygon (or quit if you'd like to quit):");
            String polygonName = scanner.next();
            if (polygonName.equals("quit")) break;
            if (polygonName.equals("Square")) {
                System.out.println("Input the side length");
                double x = scanner.nextDouble();
                Square s = new Square(x);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if (polygonName.equals("Rectangle")) {
                System.out.println("Input the side lengths");
                double x1 = scanner.nextDouble(), x2 = scanner.nextDouble();
                Rectangle s = new Rectangle(x1, x2);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if (polygonName.equals("Pentagon")) {
                System.out.println("Input the side length");
                double x = scanner.nextDouble();
                Pentagon s = new Pentagon(x);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if (polygonName.equals("Hexagon")) {
                System.out.println("Input the side length");
                double x = scanner.nextDouble();
                Hexagon s = new Hexagon(x);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if (polygonName.equals("Octagon")) {
                System.out.println("Input the side length");
                double x = scanner.nextDouble();
                Octagon s = new Octagon(x);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if(polygonName.equals("IsoscelesTriangle")) {
                System.out.println("Input the side lengths (first length occurs twice)");
                double x1 = scanner.nextDouble(), x2 = scanner.nextDouble();
                IsoscelesTriangle s = new IsoscelesTriangle(x1, x2);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if(polygonName.equals("Triangle")) {
                System.out.println("Input the side lengths");
                double a = scanner.nextDouble(), b = scanner.nextDouble(), c = scanner.nextDouble();
                Triangle s = new Triangle(a, b, c);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
            else if(polygonName.equals("EquilateralTriangle")) {
                System.out.println("Input the side length");
                double x = scanner.nextDouble();
                EquilateralTriangle s = new EquilateralTriangle(x);
                System.out.println(polygonName +"'s' Area: " + s.area() + ", Perimeter: " + s.perimeter());
            }
        }
    }
}
/*
 * Main function used as client to test the Triangle class
 * -create triangles
 * -output sides 
 * -output triangle type (RIGHT, ACUTE, OBTUSE)
 * -output perimeter
 * -output area
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Triangle t1 = new Triangle(4, 3, 5);
        System.out.println("\nTriangle-1\n****************************************");
        System.out.println(t1.toString());
        System.out.println("type: " + t1.classifyByAngles());
        System.out.println("perimeter: " + t1.getPerimeter());
        System.out.println("area: " + t1.getArea());

        Triangle t2 = new Triangle();
        System.out.println("\nTriangle-2\n****************************************");
        System.out.println(t2.toString());
        System.out.println("type: " + t2.classifyByAngles());
        System.out.println("perimeter: " + t2.getPerimeter());
        System.out.println("area: " + t2.getArea());
    }
}
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Shape> shapeList = new ArrayList<>();
        int NumberofObj = 4;
        String[] colors = new String[]{"red","black","green","white"};
        int index = 0;
        while (NumberofObj!=0) {
            shapeList.add(new Square(colors[index],NumberofObj));
            shapeList.add(new Circle(NumberofObj,colors[index]));
            shapeList.add(new ResizableSquare(colors[index],NumberofObj));

            index++;
            NumberofObj--;
        }
        for (Shape shape : shapeList) {
            if (shape instanceof Square || shape instanceof Circle) {
                double area = shape.calc_Area();
                double perimeter = shape.calc_Perimeter();
                System.out.println("Area: " + area + ", Perimeter: " + perimeter);
            } else if (shape instanceof ResizableSquare) {
                ((ResizableSquare) shape).resize(5);
            }
        }
    }
}

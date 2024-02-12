public class Circle extends Shape {
    public double radius;
    public Circle(double radius,String color){
        super(color);
        this.radius = radius ;
    }
    @Override
    double calc_Area() {
        return Math.PI*this.radius*this.radius;
    }
    @Override
    double calc_Perimeter() {
     return 2*Math.PI*this.radius;
        
    }
    
}

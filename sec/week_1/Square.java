public class Square extends Shape {
    public double side;
    public Square(String color,double side) {
        super(color);
        this.side = side;
    }

    @Override
    double calc_Area() {
        return this.side *this.side;
    }

    @Override
    double calc_Perimeter() {
       return 4*this.side;
    }
    
}

public abstract class Shape {
    public String color ;
    public Shape(String color){
        this.color = color;
    }
    abstract double calc_Area();
    abstract double calc_Perimeter();
}

public class ResizableSquare extends Square implements Resizable {

    public ResizableSquare(String color, double side) {
        super(color, side);
    }

    @Override
    public void resize(int value) {
        // Multiply the side length by the resizing value
        this.side *= value;
    } 
    
}

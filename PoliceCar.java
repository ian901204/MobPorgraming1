public class PoliceCar extends Car {
    
    public PoliceCar() {
        super(14, 5); // Initial speed 14, acceleration 5 for police cars
    }
    
    @Override
    public void accelerate() {
        super.accelerate();
    }
    
    @Override
    public int getSpeed() {
        return super.getSpeed();
    }
    
    @Override
    public void resetSpeed() {
        super.resetSpeed();
    }
    
    @Override
    public String getType() {
        return "警車";
    }
}
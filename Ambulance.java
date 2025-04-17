public class Ambulance extends Car {
    
    public Ambulance() {
        super(11, 2); // Initial speed 11, acceleration 2 for ambulances
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
        return "救護車";
    }
}
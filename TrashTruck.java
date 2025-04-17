public class TrashTruck extends Car {
    
    public TrashTruck() {
        super(8, 4); // Initial speed 8, acceleration 4 for trash trucks
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
        return "垃圾車";
    }
}
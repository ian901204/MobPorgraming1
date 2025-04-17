import java.util.ArrayList;

public class GuineaPigCarCar extends GuineaPig {
    private ICar car;
    private double distance = 0;
    
    public GuineaPigCarCar(String name, Car car) {
        super(name);
        this.car = car;
    }
    
    @Override
    public void eat(Food food) {
        super.eat(food);
        
        // If stomach contains more than 5 foods, do pupu
        if (getStomachSize() > 5) {
            pupu();
        }
        
        // If food is carrot and specific car type, increase speed
        if (food == Food.Carrot) {
            car.accelerate();
        }
    }
    
    @Override
    public ArrayList<Food> pupu() {
        ArrayList<Food> waste = super.pupu();
        car.resetSpeed(); // Reset to initial speed after pupu
        System.out.println(getName() + "的賽：" + waste);
        return waste;
    }
    
    public void accelerate() {
        car.accelerate();
    }
    
    public int getSpeed() {
        return car.getSpeed();
    }
    
    public void resetSpeed() {
        car.resetSpeed();
    }
    
    public void move(int seconds) {
        distance += getSpeed() * seconds;
    }
    
    public double getDistance() {
        return distance;
    }
    
    public String getType() {
        return car.getType();
    }
}
import java.util.ArrayList;

public class GuineaPig {
    protected ArrayList<Food> stomach;
    protected String name;
    
    public GuineaPig(String name) {
        this.name = name;
        this.stomach = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String noise() {
        return "PUI PUI!";
    }
    
    public void eat(Food food) {
        stomach.add(food);
    }
    
    public ArrayList<Food> pupu() {
        ArrayList<Food> waste = new ArrayList<>(stomach);
        stomach.clear();
        return waste;
    }
    
    public int getStomachSize() {
        return stomach.size();
    }
}
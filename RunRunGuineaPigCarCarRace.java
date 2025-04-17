import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class RunRunGuineaPigCarCarRace {
    private static final int RACE_LENGTH = 4000;
    private List<GuineaPigCarCar> racers = new ArrayList<>();
    
    public RunRunGuineaPigCarCarRace() {
        // Create three GuineaPigCarCar racers
        GuineaPigCarCar shiromo = new GuineaPigCarCar("西羅摩", new PoliceCar());
        GuineaPigCarCar abbey = new GuineaPigCarCar("阿比", new Ambulance());
        GuineaPigCarCar teddy = new GuineaPigCarCar("泰迪", new TrashTruck());
        
        racers.add(shiromo);
        racers.add(abbey);
        racers.add(teddy);
    }
    
    public void startRace() {
        int time = 0;
        boolean raceEnded = false;
        
        while (!raceEnded) {
            // Move all racers for 1 second
            for (GuineaPigCarCar racer : racers) {
                racer.move(1);
            }
            
            time++; // Increase time by 1 second
            
            // Check if time is a multiple of 10
            if (time % 10 == 0) {
                // Find leading and trailing racers
                List<GuineaPigCarCar> leaders = getLeadingRacers();
                GuineaPigCarCar trailer = getTrailingRacer();
                
                // All leaders eat lettuce
                for (GuineaPigCarCar leader : leaders) {
                    leader.eat(Food.Lettuce);
                }
                
                // Trailer eats carrot
                trailer.eat(Food.Carrot);
                
                System.out.println("Time " + time + "s:");
                for (GuineaPigCarCar racer : racers) {
                    System.out.println(racer.getName() + " - Speed: " + racer.getSpeed() + 
                                      " m/s, Distance: " + racer.getDistance() + " m");
                }
                System.out.println();
            }
            
            // Check if any racer has reached the finish line
            for (GuineaPigCarCar racer : racers) {
                if (racer.getDistance() >= RACE_LENGTH) {
                    raceEnded = true;
                    break;
                }
            }
        }
        
        // Race has ended, print results
        GuineaPigCarCar winner = getLeadingRacer();
        System.out.println("比賽結束！");
        System.out.println("跑跑大賽的冠軍得主：" + winner.getName());
        System.out.println();
        
        System.out.println("比賽結束時各參賽者成績：");
        for (GuineaPigCarCar racer : racers) {
            System.out.println(racer.getName() + "：" + racer.getDistance() + " m");
        }
    }
    
    private List<GuineaPigCarCar> getLeadingRacers() {
        List<GuineaPigCarCar> leaders = new ArrayList<>();
        double maxDistance = 0;
        
        // First find the maximum distance
        for (GuineaPigCarCar racer : racers) {
            if (racer.getDistance() > maxDistance) {
                maxDistance = racer.getDistance();
            }
        }
        
        // Then find all racers at that distance
        for (GuineaPigCarCar racer : racers) {
            if (racer.getDistance() == maxDistance) {
                leaders.add(racer);
            }
        }
        
        return leaders;
    }
    
    // This method is kept for determining the winner at the end
    private GuineaPigCarCar getLeadingRacer() {
        GuineaPigCarCar leader = racers.get(0);
        for (GuineaPigCarCar racer : racers) {
            if (racer.getDistance() > leader.getDistance()) {
                leader = racer;
            }
        }
        return leader;
    }
    
    private GuineaPigCarCar getTrailingRacer() {
        GuineaPigCarCar trailer = racers.get(0);
        for (GuineaPigCarCar racer : racers) {
            if (racer.getDistance() < trailer.getDistance()) {
                trailer = racer;
            }
        }
        return trailer;
    }
    
    public static void main(String[] args) {
        RunRunGuineaPigCarCarRace race = new RunRunGuineaPigCarCarRace();
        race.startRace();
    }
}
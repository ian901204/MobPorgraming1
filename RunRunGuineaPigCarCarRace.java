import java.util.ArrayList;
import java.util.List;

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
                GuineaPigCarCar leader = getLeadingRacer();
                GuineaPigCarCar trailer = getTrailingRacer();
                
                // Leader eats lettuce
                leader.eat(Food.Lettuce);
                
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
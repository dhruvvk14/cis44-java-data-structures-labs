import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    // You can add shared attributes or methods here if needed
    // An abstract method for toString() can be helpful for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;
    private int n;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        n = riverSize;
        //it would make the most sense for 3/5 of the river to be blank, and 1/5 bear and 1/5 fish

        for (int i = 0; i < riverSize; i++) {
            int x = random.nextInt(7);
            if (x <= 2) {
                //fish
                river[i] = new Fish();
            }
            else if (x <= 3) {
                //bear 
                river[i] = new Bear();
            }
            else river[i] = null;
        }
        

        // You can add logic here to initially populate the river
    }

    public void runStep() {
        // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next move.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.

        //quick note: only two elements may ever be at one square before we handle the collision.

        //therefore, we can just store the amount of bears & fishes per indice
        int bears[] = new int[n];
        int fishes[] = new int[n];
        int bearsToPlace = 0, fishesToPlace = 0;
        int empty = 0;
        for (int i = 0; i < n; i++) {
            if (river[i] instanceof Bear) {
                int x = random.nextInt(3);
                if (x == 0){
                    //go left
                    if (i == 0) {bears[i]++;}
                    else bears[i-1]++;
                }
                else if (x == 1) {
                    //go right
                    if (i == n-1) bears[i]++;
                    else bears[i+1]++;
                }
                else bears[i]++;
            }
            if (river[i] instanceof Fish) {
                int x = random.nextInt(3);
                if (x == 0){
                    //go left
                    if (i == 0) fishes[i]++;
                    else fishes[i-1]++;
                }
                else if (x == 1) {
                    //go right
                    if (i == n-1) fishes[i]++;
                    else fishes[i+1]++;
                }
                else fishes[i]++;
            }
            
        }
        for (int i = 0; i < n; i++) {
            river[i] = null;
            if (bears[i] == 1 && fishes[i] == 1) {
                //no matter what, there will ALWAYS be a bear here
                river[i] = new Bear();
            }
            else if (bears[i] == 2 ) bearsToPlace++;
            else if (fishes[i] == 2)fishesToPlace++;
            else if (bears[i] == 1 && fishes[i] == 0) river[i] = new Bear();
            else if (bears[i] == 0 && fishes[i] == 1) river[i] = new Fish();
            if (river[i] == null)empty++;
        }
        while (bearsToPlace > 0) {
            int rand = random.nextInt(empty) + 1;
            int cnt = 1; 
            for (int i = 0; i < n; i++) {
                if (river[i] == null) {
                    if (cnt == rand) {
                        river[i] = new Bear();
                        bearsToPlace--; empty--;
                        break;
                    }
                    cnt++;
                }
            }

        }

        while (fishesToPlace > 0) {
            int rand = random.nextInt(empty) + 1;
            int cnt = 1; 
            for (int i = 0; i < n; i++) {
                if (river[i] == null) {
                    if (cnt == rand) {
                        river[i] = new Fish();
                        fishesToPlace--; empty--;
                        break;
                    }
                    cnt++;
                }
            }
        }
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.visualize();

        for (int i = 1; i <= 12; i++) {
            eco.runStep();
            eco.visualize();
        }
        // Loop to run multiple steps...
    }
}
              



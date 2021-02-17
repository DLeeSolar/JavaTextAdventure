import java.util.Random;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            // System objects
            Scanner in = new Scanner(System.in);
            Random rand = new Random();

            // Game variables
            String[] creatures = { "Rat", "Skeleton", "Spider", "Zombie" };
            int maxCreatureHealth = 75;
            int creatureAttackDamage = 25;

            // Player variables
            int health = 100;
            int attackDamage = 50;
            int healthPotCount = 3; // Number of health potions the player will start with
            int healthPotHeal = 30; // Value it heals for
            int healthPotDropChance = 50; // Percentage drop chance when a creature is slain

            boolean running = true; // Condition for a while loop so that the game runs until some conditions are met

            System.out.println("Welcome to the Dungeon!");

            GAME: // Labels the while loop as GAME
            while(running) {
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                int creatureHealth = rand.nextInt(maxCreatureHealth);
                String creature = creatures[rand.nextInt(creatures.length)]; // Randomly select a creature from the creatures array
                System.out.println("\t# " + creature + " appeared! #\n"); //      # Skeleton appeared! #

                while(creatureHealth > 0) {
                    System.out.println("\tYour HP: " + health);
                    System.out.println("\t" + creature + "'s HP: " + creatureHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack!");
                    System.out.println("\t2. Drink health potion.");
                    System.out.println("\t3. Run!");

                    String input = in.nextLine();
                    if(input.equals("1")){
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(creatureAttackDamage);

                        creatureHealth -= damageDealt;
                        health -= damageTaken;

                        System.out.println("\t> You strike the " + creature + " for " + damageDealt + " damage.");
                        System.out.println("\t> You take " + damageTaken + " from the " + creature + ".");

                        if(health < 1) {
                            System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                            break;
                        }
                    }
                    else if(input.equals("2")){
                        if(healthPotCount > 0) {
                            health += healthPotHeal;
                            healthPotCount--;
                            System.out.println("\t> You drink a health potion, healing for " + healthPotHeal + "."
                                                + "\n\t> You now have " + health + " HP."
                                                + "\n\t> You have " + healthPotCount + " health potions left.\n");
                        }
                        else {
                            System.out.println("\t> You have no health potions left. Defeat creatures for a chance to get one.");
                        }
                    }
                    else if(input.equals("3")){
                        System.out.println("\t> You run away from the " + creature + "!");
                        continue GAME; // Jump back to top of GAME while loop, rather than the current-level while loop
                    }
                    else {
                        System.out.println("\t> Invalid Command! Input must be 1, 2 or 3.");
                    }
                }

                if(health < 1) {
                    System.out.println("You limp out of the dungeon.");
                    break;
                }

                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println(" # " + creature + " was defeated! #");
                System.out.println(" # You have " + health + " HP left. #");
                //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                if(rand.nextInt(100) < healthPotDropChance) {
                    healthPotCount++;
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println(" # You found a health potion. # ");
                    System.out.println(" # You now have a total of " + healthPotCount + ". # ");
                }

                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
                System.out.println("What would you like to do?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit dungeon");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command!");
                    input = in.nextLine();
                }

                if(input.equals("1")) {
                    System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println("You continue on your adventure.");
                    //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
                }
                else if(input.equals("2")) {
                    System.out.println("You exit the dungeon.");
                    break;
                }

            }

            System.out.println(" ####################### ");
            System.out.println(" # Thanks for playing! # ");
            System.out.println(" ####################### ");

        }
}

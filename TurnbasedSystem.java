import java.util.Scanner;

//handles all text
public class TurnbasedSystem{

    public Player intro(String playerName, char playerGender, Pokemon starterPokemon){
    
        Scanner sc = new Scanner(System.in);
        playerGender = ' ';
        playerName = " ";
        starterPokemon = null;
        int starterChoice;

        
        System.out.println("Welcome to the JAVAMON!");
        System.out.println("Please introduce yourself:");

       
        System.out.println("Enter your name: ");
        playerName = sc.nextLine();
        

   
        while(playerGender != 'm' && playerGender != 'f'){
            System.out.println("Select your gender: [M] or [F] ");
            playerGender = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
        }
        proceedDialogue(sc);


        while(starterPokemon == null){
            System.out.println("Select your starter pokemon: ");
            System.out.println("[1] Charizard");
            System.out.println("[2] Blastoise");
            System.out.println("[3] Venosaur");
            starterChoice = sc.nextInt();
            starterPokemon = Main.starterPokemons[starterChoice -1];
            sc.nextLine();
            proceedDialogue(sc);
        }

        System.out.println(starterPokemon);
        System.out.println("Hello, " + playerName + "!");
        System.out.println("You are a " + playerGender + " player.");
        System.out.println("Let's start the adventure!");

    
        return (new Player(playerName, playerGender, starterPokemon));
    }

    public int zoneSelector(Player player) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Select an area you want to go.");
        System.out.println("[1] Area 1          [9] Area 9");
        System.out.println("[2] Area 2          [10] Area 10");
        System.out.println("[3] Area 3          [11] Area 11");
        System.out.println("[4] Area 4          [12] Area 12");
        System.out.println("[5] Area 5          [13] Area 13");
        System.out.println("[6] Area 6          [14] Area 14");
        System.out.println("[7] Area 7");
        System.out.println("[8] Area 8");
    
        int areaChoice = sc.nextInt() - 1;
        while (areaChoice < 0 || areaChoice >= 14) {  // Prevents out-of-bounds input
            System.out.println("Invalid zone, please try again.");
            areaChoice = sc.nextInt() - 1;
        }
        
    
        // Poké Center option
        System.out.println("Do you want to visit the Poké Center before continuing?");
        System.out.println("[1] Yes \n[2] No");
        int pokeCenterChoice = sc.nextInt();
        
        if (pokeCenterChoice == 1) {
            player.resetPokemon();
            System.out.println("All your Pokémon have been healed!");
        }
    
        player.changeZone(areaChoice);
        sc.nextLine();
        proceedDialogue(sc);
        
        return areaChoice;
    }
    

    public void zoneTypeSelector(Player player){
        Scanner sc = new Scanner(System.in);

        System.out.println("This zone has two types. Please select one.");
        System.out.println("[1] Wilds \n[2] Gym");

        int zoneTypechoice = sc.nextInt();

        while (zoneTypechoice != 1 && zoneTypechoice != 2) { 
            System.out.println("Invalid input, please try again.");
            System.out.println("[1] Wilds \n[2] Gym");
            zoneTypechoice = sc.nextInt();
        }

        player.insideGym = zoneTypechoice != 1;

    }

    public void displayZoneDetails(Zone zone){
        System.out.println("You have entered "+ zone.zoneId);
        System.out.println("This zone has an element of "+ zone.zoneElement);
        System.out.println("Only pokemons of said elements can be encountered here.");
        proceedDialogue(new Scanner(System.in));
    }

    public Pokemon encounterPokemonTurn(Encounter encounterSystem){
        System.out.println("You are about to encounter a pokemon.");
        System.out.println(".");
        System.out.println("..");
        System.out.println("...");
        return encounterSystem.encounterPokemon();
    }

    public void proceedDialogue(Scanner sc){
        System.out.println("Input anything to proceed.");
        sc.nextLine();
    }

    public void encounterTrainer(){

    }


    public void loseScene(){

    }
}
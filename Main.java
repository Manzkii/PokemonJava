import java.util.*;

public class Main {
    
    static Pokemon[] grassPokemons = {
        new Pokemon("Venusaur",PokemonTypes.Grass, 200, 82, 100, 83),
        new Pokemon("Vileplume", PokemonTypes.Grass, 75, 80, 85, 100),
        new Pokemon("Victreebel", PokemonTypes.Grass, 80, 105, 65, 100),
        new Pokemon("Parasect", PokemonTypes.Grass, 60, 95, 80, 80),
        new Pokemon("Exeggutor", PokemonTypes.Grass, 95, 95, 85, 125)   
    }; 

    static Pokemon[] firePokemons = {
        new Pokemon("Charizard", PokemonTypes.Fire, 78, 84, 78, 85),
        new Pokemon("Ninetales", PokemonTypes.Fire, 73, 76, 75, 100),
        new Pokemon("Arcanine", PokemonTypes.Fire, 90, 110, 80, 80),
        new Pokemon("Rapidash", PokemonTypes.Fire, 65, 100, 70, 80),
        new Pokemon("Flareon", PokemonTypes.Fire, 65, 130, 60, 95 ),
        new Pokemon("Moltres", PokemonTypes.Fire, 90, 100, 90, 125),         
    };
     
    static Pokemon[] waterPokemons = {
        new Pokemon("Blastoise",  PokemonTypes.Water, 79, 83, 100, 85),
        new Pokemon("Golduck",    PokemonTypes.Water, 80, 82, 78, 95),
        new Pokemon("Poliwrath",  PokemonTypes.Water, 90, 85, 95, 70),
        new Pokemon("Tentacruel", PokemonTypes.Water, 80, 70, 65, 120),
        new Pokemon("Cloyster",   PokemonTypes.Water, 50, 95, 180, 85),
        new Pokemon("Dewgong",    PokemonTypes.Water, 90, 70, 80, 95),
        new Pokemon("Kingler",    PokemonTypes.Water, 55, 130, 115, 50),
        new  Pokemon("Seaking",   PokemonTypes.Water, 80, 92, 65, 80),
        new Pokemon ("Starmie",   PokemonTypes.Water, 60, 75, 85,  100),
        new Pokemon("Gyarados", PokemonTypes.Water, 95, 125, 100, 79),
        new Pokemon("Lapras", PokemonTypes.Water, 130, 85, 95, 80)
    };

    static Pokemon[] electricPokemons = {
        new Pokemon("Raichu", PokemonTypes.Electric, 60, 90, 55, 90),
        new Pokemon("Electrode", PokemonTypes.Electric, 60, 50, 70, 80),
        new Pokemon("Jolteon", PokemonTypes.Electric, 65, 65, 60, 110),
        new Pokemon("Zapdos", PokemonTypes.Electric, 90, 90, 85, 125 ),        
    };

    static Pokemon[] normalPokemons = {
        new Pokemon("Pidgeot", PokemonTypes.Normal, 83, 80, 70, 75),
        new Pokemon("Raticate", PokemonTypes.Normal, 55, 81, 50, 60),
        new Pokemon("Persian", PokemonTypes.Normal, 65, 70, 65, 60),
        new Pokemon("Dodrio", PokemonTypes.Normal, 60, 110, 60, 70),
        new Pokemon("Farfetch’d", PokemonTypes.Normal, 52, 65, 58, 55),
        new Pokemon("Kangaskhan", PokemonTypes.Normal, 105, 95, 40, 80),
        new Pokemon("Tauros", PokemonTypes.Normal, 75, 100, 70, 95),
        new Pokemon("Snorlax", PokemonTypes.Normal, 160, 110, 65, 65)
    };

    static Pokemon[] psychicPokemons = {
        new Pokemon("Alakazam", PokemonTypes.Psychic, 55, 50, 135, 45),
        new Pokemon("Slowbro", PokemonTypes.Psychic, 95, 75, 80, 110),
        new Pokemon("Hypno", PokemonTypes.Psychic, 85, 73, 115, 70),
        new Pokemon("Mr. Mime", PokemonTypes.Psychic, 40, 45, 100, 65),
        new Pokemon("Jynx", PokemonTypes.Psychic, 65, 50, 115, 35),
        new Pokemon("Starmie", PokemonTypes.Psychic, 60, 75, 100, 85),
        new Pokemon("Mewtwo", PokemonTypes.Psychic, 106, 110, 154, 90),
        new Pokemon("Mew", PokemonTypes.Psychic, 100, 100, 100, 100)
    };
    
    static Pokemon[] ghostPokemons = {
        new Pokemon("Gengar", PokemonTypes.Ghost, 60, 65, 130, 60)
    };
    
    static Pokemon[] dragonPokemons = {
        new Pokemon("Dragonite", PokemonTypes.Dragon, 91, 134, 100, 95)
    };

    static Pokemon[] bugPokemons = {
        new Pokemon("Butterfree", PokemonTypes.Bug, 60, 45, 80, 50),
        new Pokemon("Beedrill", PokemonTypes.Bug, 65, 90, 45, 40),
        new Pokemon("Parasect", PokemonTypes.Bug, 60, 95, 80, 80),
        new Pokemon("Venomoth", PokemonTypes.Bug, 70, 65, 90, 60),
        new Pokemon("Pinsir", PokemonTypes.Bug, 65, 125, 55, 100),
        new Pokemon("Scyther", PokemonTypes.Bug, 70, 110, 55, 80)
    };

    static Pokemon[] rockPokemons = {
        new Pokemon("Golem", PokemonTypes.Rock, 80, 110, 55, 130),
        new Pokemon("Omastar", PokemonTypes.Rock, 70, 60, 115, 125),
        new Pokemon("Kabutops", PokemonTypes.Rock, 60, 115, 70, 105),
        new Pokemon("Aerodactyl", PokemonTypes.Rock, 80, 105, 60, 65)
    };

    static Pokemon[] groundPokemons = {
        new Pokemon("Sandslash", PokemonTypes.Ground, 75, 100, 55, 110),
        new Pokemon("Dugtrio", PokemonTypes.Ground, 35, 80, 50, 50),
        new Pokemon("Nidoqueen", PokemonTypes.Ground, 90, 82, 75, 87),
        new Pokemon("Nidoking", PokemonTypes.Ground, 81, 92, 75, 77),
        new Pokemon("Marowak", PokemonTypes.Ground, 60, 80, 50, 110),
        new Pokemon("Rhydon", PokemonTypes.Ground, 105, 130, 45, 120)
    };

    static Pokemon[] icePokemons = {
        new Pokemon("Dewgong", PokemonTypes.Ice, 90, 70, 95, 80),
        new Pokemon("Jynx", PokemonTypes.Ice, 65, 50, 115, 35),
        new Pokemon("Lapras", PokemonTypes.Ice, 130, 85, 95, 80),
        new Pokemon("Articuno", PokemonTypes.Ice, 90, 85, 125, 100)
    };
    
    static Pokemon[] poisonPokemons = {
        new Pokemon("Beedrill", PokemonTypes.Poison, 65, 90, 45, 40),
        new Pokemon("Arbok", PokemonTypes.Poison, 60, 85, 65, 69),
        new Pokemon("Nidoqueen", PokemonTypes.Poison, 90, 82, 75, 87),
        new Pokemon("Nidoking", PokemonTypes.Poison, 81, 92, 75, 77),
        new Pokemon("Venomoth", PokemonTypes.Poison, 70, 65, 90, 60),
        new Pokemon("Muk", PokemonTypes.Poison, 105, 105, 65, 75),
        new Pokemon("Weezing", PokemonTypes.Poison, 65, 90, 85, 120)
    };

    static Pokemon[] fightingPokemons = {
        new Pokemon("Primeape", PokemonTypes.Fighting, 65, 105, 60, 60),
        new Pokemon("Poliwrath", PokemonTypes.Fighting, 90, 85, 70, 95),
        new Pokemon("Machamp", PokemonTypes.Fighting, 90, 130, 65, 80),
        new Pokemon("Hitmonlee", PokemonTypes.Fighting, 50, 120, 35, 53),
        new Pokemon("Hitmonchan", PokemonTypes.Fighting, 50, 105, 35, 79)
    };
    
    static Pokemon[] starterPokemons = {
        firePokemons[0],
        waterPokemons[0],
        grassPokemons[0]
    }; 

    static Pokemon[][] allPokemons = {
        grassPokemons, firePokemons, waterPokemons, electricPokemons, normalPokemons, 
        psychicPokemons, ghostPokemons, dragonPokemons, bugPokemons, rockPokemons, 
        groundPokemons, icePokemons, poisonPokemons, fightingPokemons, starterPokemons
    };

    public void main(String[] args) {

        while (true) { 
            Scanner sc = new Scanner(System.in);
            char playerGender = ' ';
            String playerName = " ";
            Pokemon starterPokemon = null;
            List<Zone> zones = new ArrayList<>();
            TurnbasedSystem turnbasedSystem = new TurnbasedSystem();
            

            
            Player player = turnbasedSystem.intro(playerName, playerGender, starterPokemon);
            player.restartPlayer(); // Reset Pokémon when starting a new game
            turnbasedSystem.proceedDialogue(sc);
            zonesDecider(zones);

            Bag bag = new Bag();
            Catch catchSystem = new Catch(bag, player);
            Encounter encounterSystem = new Encounter(player, zones);
            BattleSystem battleSystem = new BattleSystem(bag, catchSystem, encounterSystem);


            while (!player.hasLost) {
                if (player.gymsBeaten >= 4) { // If the player has beaten 4 Gyms, end the game
                    System.out.println("Congratulations! You have beaten 4 Gyms and completed the game!");
                    System.exit(0); // End the game
                }
            
                int areachoice = turnbasedSystem.zoneSelector(player);

                if(zones.get(areachoice).zoneType.equals(Arrays.asList(ZoneTypes.Wilds, ZoneTypes.Gym)) && zones.get(areachoice).finishedZoneGym == false){
                    turnbasedSystem.zoneTypeSelector(player);
                }else{
                    player.insideGym = false;
                }

                turnbasedSystem.displayZoneDetails(zones.get(areachoice));
                if (player.insideGym == false) {
                    Pokemon pokemonOpponent = encounterSystem.encounterPokemon();
                    battleSystem.startBattle(pokemonOpponent, player, turnbasedSystem);
                } else {
                    AITrainer trainerOpponent = encounterSystem.encounterTrainer();
                    battleSystem.startBattle(trainerOpponent, player, turnbasedSystem);
                }
            }
        
            System.out.println("You have lost the game. Restarting...");
            player.restartPlayer(); // Reset Pokémon when restarting

        }
    }

    public static void zonesDecider(List<Zone> zones){
        int numOfGyms = 8;
        List<Integer> gymIndexes = new ArrayList<>();
        List<ZoneElements> availableZoneElements = new ArrayList<>(Arrays.asList(ZoneElements.values()));
        Collections.shuffle(availableZoneElements);
        Random random = new Random();

        while (gymIndexes.size() < numOfGyms) {
            int gymIndex = random.nextInt(15);
            if (!gymIndexes.contains(gymIndex)) {
                gymIndexes.add(gymIndex);
            }
        }
        

        for (int i = 0; i < 14; i++) {
            ZoneElements zoneElement = availableZoneElements.get(i);

            if(gymIndexes.contains(i)){
                zones.add(new Zone(Arrays.asList(ZoneTypes.Wilds, ZoneTypes.Gym), i + 1, zoneElement));
            }else{
                zones.add(new Zone(Arrays.asList(ZoneTypes.Wilds), i + 1, zoneElement));
            }
        }
    }
}

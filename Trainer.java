import java.util.*;

public class Trainer {
    private Bag bag; 
    public String name;
    private char gender;
    public List<Pokemon> pokemonCollection = new ArrayList<>();
    public int equippedPokemon = 0;
    public int zone;
    public boolean hasLost = false;
    final public int maximumPokemonAmount = 6;

    public Trainer(String name, char gender) {
        this.name = name;
        this.gender = gender;
        this.bag = new Bag(); 
    }

    public Pokemon returnequippedPokemon() {
        return pokemonCollection.get(equippedPokemon);
    }

    public int numofPokemonsAlive() {
        int pokemonAlive = 0;
        for (Pokemon pokemon : pokemonCollection) {
            if (!pokemon.isDead) {
                pokemonAlive += 1;
            }
        }
        return pokemonAlive;
    }

    public List<Pokemon> PokemonsAlive() {
        List<Pokemon> pokemonAlive = new ArrayList<>();
        for (Pokemon pokemon : pokemonCollection) {
            if (!pokemon.isDead) {
                pokemonAlive.add(pokemon);
            }
        }
        return pokemonAlive;
    }

    public void interactWithBagCommand() {
        System.out.println("Interacting with the bag...");
        bag.displayBagContents();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a Pokéball to use or enter 0 to cancel:");
        String choice = sc.nextLine();

        if (!choice.equals("0")) {
            if (bag.useItem(choice)) {
                System.out.println("You used a " + choice + "!");
            } else {
                System.out.println("You don't have any " + choice + "!");
            }
        }
    }

    public void fightCommand(int atkType, Pokemon opponent) {
        if (atkType == 1) {
            pokemonCollection.get(this.equippedPokemon).physicalAttack(opponent);
        } else {
            pokemonCollection.get(this.equippedPokemon).elementalAttack(opponent);
        }
    }

    public void switchPokemon() {
        List<Pokemon> alivePokemons = this.PokemonsAlive();
        if (alivePokemons.size() <= 1) {
            System.out.println("You have no other Pokémon to switch to!");
            return;
        }
    
        System.out.println("Choose a Pokémon to switch to:");
        for (int i = 0; i < this.pokemonCollection.size(); i++) {
            Pokemon pokemon = this.pokemonCollection.get(i);
            if (!pokemon.isDead) {
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " (HP: " + pokemon.currenthp + "/" + pokemon.maxhp + ")");
            } else {
                System.out.println("[" + (i + 1) + "] " + pokemon.name + " [Fainted]");
            }
        }
    
        Scanner sc = new Scanner(System.in);
        int pokemonChoice = sc.nextInt() - 1;
    
        if (pokemonChoice < 0 || pokemonChoice >= pokemonCollection.size()) {
            System.out.println("Invalid choice. Try again.");
            return;
        }
    
        Pokemon selectedPokemon = pokemonCollection.get(pokemonChoice);
    
        if (selectedPokemon.isDead) {
            System.out.println(selectedPokemon.name + " is fainted and cannot be switched in!");
            return;
        }
    
        if (pokemonChoice == this.equippedPokemon) {
            System.out.println(selectedPokemon.name + " is already in battle!");
            return;
        }
    
        this.equippedPokemon = pokemonChoice;
        System.out.println("You switched to " + selectedPokemon.name + "!");
    }
    


    public void lose() {
        // makes trainer lose
    }

    public void win() {
        // makes trainer win
    }
}

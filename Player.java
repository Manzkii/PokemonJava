import java.util.Random;
;

public class Player extends Trainer{
    int pokeballs = 0;
    boolean insideGym;
    
    public int gymsBeaten = 0;

    public Player(String name, char gender, Pokemon starter){
        super(name, gender);
        this.pokemonCollection.add(starter);
    }

    public void catchPokemon(Pokemon wildPokemon) {
        if (pokeballs > 0) {
            System.out.println("You caught " + wildPokemon.getName() + "!");
            pokemonCollection.add(wildPokemon);
            pokeballs--;
        } else {
            System.out.println(wildPokemon.getName() + " ran away!");
        }
    }

    public void changeZone(int zone){
        this.zone = zone;
    }

    @Override
    public void lose(){
        this.hasLost = true;
    }

    public void restartPlayer() {
        this.hasLost = false;
        this.pokeballs = 0;
        this.resetPokemon(); // Reset all Pokémon

        for (Pokemon pokemon : this.pokemonCollection) {
            pokemon.heal(pokemon.maxhp); 
            System.out.print(pokemon.currenthp);
            pokemon.isDead = false;  
        }
    }

    public void victory(){
        for(Pokemon pokemon : this.pokemonCollection){
            pokemon.heal(pokemon.maxhp);
            pokemon.patk *= 2;
            pokemon.eatk *= 2;
        }
    }

    public void resetPokemon() {
        for (Pokemon pokemon : this.pokemonCollection) {
            pokemon.heal(pokemon.maxhp); // Heal the Pokémon to full health
            pokemon.isDead = false; // Reset the fainted status
        }
    }

    public void receiveRandomPokeballs(Bag bag) {
        Random rand = new Random();
        String[] pokeballTypes = {"Pokéball", "Great Ball", "Ultra Ball", "Master Ball"};
        int randomIndex = rand.nextInt(pokeballTypes.length); // Randomly select a Pokéball type
        String pokeballType = pokeballTypes[randomIndex];

        int randomAmount = rand.nextInt(5) + 1; // Random amount between 1 and 5
        bag.addItem(pokeballType, randomAmount);

        System.out.println("You received " + randomAmount + " " + pokeballType + "(s)!");
    }
}
import java.util.Random;

public class Catch {
    private Bag bag;
    private Player player;

    public Catch(Bag bag, Player player) {
        this.bag = bag;
        this.player = player;
    }

    public boolean tryToCatch(Pokemon wildPokemon, int pokeballIndex) {
        String pokeballType = getPokeballType(pokeballIndex);
    
        if (pokeballType == null || !bag.hasItem(pokeballType)) {
            System.out.println("You don't have any " + pokeballType + "!");
            return false;
        }
    
        bag.useItem(pokeballType);
        Random rand = new Random();
        int catchRate = getCatchRate(pokeballType);
        int hpFactor = (wildPokemon.getHp() * 100) / wildPokemon.maxhp;
        int catchChance = rand.nextInt(100);
    
        if (catchChance < (catchRate - hpFactor)) {
            player.pokemonCollection.add(wildPokemon); // Save the caught Pokémon
            return true; // Successfully caught
        } else {
            System.out.println(wildPokemon.getName() + " broke free!");
            return false; // Failed to catch
        }
    }

    public String getPokeballType(int index) {
        switch (index) {
            case 1: return "Pokéball";
            case 2: return "Great Ball";
            case 3: return "Ultra Ball";
            case 4: return "Master Ball";
            default: return null; 
        }
    }

    private int getCatchRate(String pokeballType) {
        switch (pokeballType) {
            case "Pokéball": return 50;
            case "Great Ball": return 75;
            case "Ultra Ball": return 90;
            case "Master Ball": return 100; // Always catches
            default: return 0;
        }
    }
}

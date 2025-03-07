import java.util.*;


enum ZoneTypes{
    Wilds, Gym
}
enum ZoneElements{
    Bug, Dragon, Electric, Fighting, Fire, Poison, Rock, Ghost, Grass, Ground, Ice, Psychic, Water, Normal
}

public class Zone {
    public List<Pokemon> wildPokemons; 
    public List<ZoneTypes> zoneType;
    ZoneElements zoneElement;
    int zoneId;
    public boolean finishedZoneGym = false;

    public Zone(List<ZoneTypes> zoneType, int zoneId, ZoneElements zoneElement) {
        this.zoneType = zoneType;
        this.zoneId = zoneId;
        this.zoneElement = zoneElement;
    }

    public Pokemon encounterWildPokemonByElement() {
        List<Pokemon> filteredPokemons = returnFilteredPokemonbyZoneElement(this.zoneElement);
       
        if (filteredPokemons.isEmpty()) {
            System.out.println("No wild Pokémon available of this element in this zone.");
            return null;
        }
        Random rand = new Random();
        return filteredPokemons.get(rand.nextInt(filteredPokemons.size()));
    }
    

    public AITrainer returnTrainerPokemonElement(){
        List<Pokemon> filteredPokemons = returnFilteredPokemonbyZoneElement(this.zoneElement);
        Random rand = new Random();
        AITrainer trainer = new AITrainer(zoneElement + " Gym", 'm');
        trainer.pokemonCollection.add(filteredPokemons.get(rand.nextInt(filteredPokemons.size())));
        trainer.pokemonCollection.add(filteredPokemons.get(rand.nextInt(filteredPokemons.size())));
        trainer.pokemonCollection.add(filteredPokemons.get(rand.nextInt(filteredPokemons.size())));

        return trainer;
        
    }

    private List<Pokemon> returnFilteredPokemonbyZoneElement(ZoneElements zoneElement){
        List<Pokemon> filteredPokemons = new ArrayList<>();

        switch (zoneElement) {
            case Grass:
                filteredPokemons.addAll(Arrays.asList(Main.grassPokemons));
                break;
            case Fire:
                filteredPokemons.addAll(Arrays.asList(Main.firePokemons));
                break;
            case Water:
                filteredPokemons.addAll(Arrays.asList(Main.waterPokemons));
                break;
            case Electric:
                filteredPokemons.addAll(Arrays.asList(Main.electricPokemons));
                break;
            case Normal:
                filteredPokemons.addAll(Arrays.asList(Main.normalPokemons));
                break;
            case Psychic:
                filteredPokemons.addAll(Arrays.asList(Main.psychicPokemons));
                break;
            case Ghost:
                filteredPokemons.addAll(Arrays.asList(Main.ghostPokemons));
                break;
            case Dragon:
                filteredPokemons.addAll(Arrays.asList(Main.dragonPokemons));
                break;
            case Bug:
                filteredPokemons.addAll(Arrays.asList(Main.bugPokemons));
                break;
            case Rock:
                filteredPokemons.addAll(Arrays.asList(Main.rockPokemons));
                break;
            case Ground:
                filteredPokemons.addAll(Arrays.asList(Main.groundPokemons));
                break;
            case Ice:
                filteredPokemons.addAll(Arrays.asList(Main.icePokemons));
                break;
            case Poison:
                filteredPokemons.addAll(Arrays.asList(Main.poisonPokemons));
                break;
            case Fighting:
                filteredPokemons.addAll(Arrays.asList(Main.fightingPokemons));
                break;
            default:
                break;
        }

        return filteredPokemons;
    }
}

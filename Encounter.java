import java.util.*;

public class Encounter{
    Player player;
    List<Zone> zones;

    public Encounter(Player player, List<Zone> zones){
        this.player = player;
        this.zones = zones;
    }

    public Pokemon encounterPokemon(){
        Pokemon wildPokemon = zones.get(player.zone).encounterWildPokemonByElement();
        if(wildPokemon != null){
            System.out.println("You encountered a wild " + wildPokemon.getName() + "!");        
        }
        return wildPokemon;
    }

    public AITrainer encounterTrainer(List<String> availableNames){
        AITrainer wildTrainer = this.zones.get(player.zone).returnTrainerPokemonElement(availableNames);

        if(wildTrainer != null){
            System.out.println("You are fighting " + wildTrainer.name + "!");        
        }
        return wildTrainer;
    }
}
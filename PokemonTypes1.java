import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PokemonTypes1 {
    public static final Map<PokemonTypes, PokemonTypes[]> strengths = new EnumMap<>(PokemonTypes.class);
    public static final Map<PokemonTypes, PokemonTypes[]> weaknesses = new EnumMap<>(PokemonTypes.class);

    static {
        strengths.put(PokemonTypes.Fire, new PokemonTypes[]{PokemonTypes.Grass, PokemonTypes.Ice, PokemonTypes.Bug});
        strengths.put(PokemonTypes.Water, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Rock, PokemonTypes.Ground});
        strengths.put(PokemonTypes.Grass, new PokemonTypes[]{PokemonTypes.Water, PokemonTypes.Rock, PokemonTypes.Ground});
        strengths.put(PokemonTypes.Electric, new PokemonTypes[]{PokemonTypes.Water, PokemonTypes.Flying});
        strengths.put(PokemonTypes.Ice, new PokemonTypes[]{PokemonTypes.Dragon, PokemonTypes.Grass, PokemonTypes.Ground, PokemonTypes.Flying});
        strengths.put(PokemonTypes.Fighting, new PokemonTypes[]{PokemonTypes.Normal, PokemonTypes.Rock, PokemonTypes.Ice});
        strengths.put(PokemonTypes.Poison, new PokemonTypes[]{PokemonTypes.Grass});
        strengths.put(PokemonTypes.Ground, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Electric, PokemonTypes.Rock, PokemonTypes.Poison});
        strengths.put(PokemonTypes.Flying, new PokemonTypes[]{PokemonTypes.Grass, PokemonTypes.Fighting, PokemonTypes.Bug});
        strengths.put(PokemonTypes.Psychic, new PokemonTypes[]{PokemonTypes.Fighting, PokemonTypes.Poison});
        strengths.put(PokemonTypes.Bug, new PokemonTypes[]{PokemonTypes.Grass, PokemonTypes.Psychic});
        strengths.put(PokemonTypes.Rock, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Ice, PokemonTypes.Flying, PokemonTypes.Bug});
        strengths.put(PokemonTypes.Ghost, new PokemonTypes[]{PokemonTypes.Psychic, PokemonTypes.Ghost});
        strengths.put(PokemonTypes.Dragon, new PokemonTypes[]{PokemonTypes.Dragon});

        weaknesses.put(PokemonTypes.Fire, new PokemonTypes[]{PokemonTypes.Water, PokemonTypes.Rock, PokemonTypes.Ground});
        weaknesses.put(PokemonTypes.Water, new PokemonTypes[]{PokemonTypes.Electric, PokemonTypes.Grass});
        weaknesses.put(PokemonTypes.Grass, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Ice, PokemonTypes.Poison, PokemonTypes.Flying, PokemonTypes.Bug});
        weaknesses.put(PokemonTypes.Electric, new PokemonTypes[]{PokemonTypes.Ground});
        weaknesses.put(PokemonTypes.Ice, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Fighting, PokemonTypes.Rock});
        weaknesses.put(PokemonTypes.Fighting, new PokemonTypes[]{PokemonTypes.Flying, PokemonTypes.Psychic});
        weaknesses.put(PokemonTypes.Poison, new PokemonTypes[]{PokemonTypes.Ground, PokemonTypes.Psychic});
        weaknesses.put(PokemonTypes.Ground, new PokemonTypes[]{PokemonTypes.Water, PokemonTypes.Ice, PokemonTypes.Grass});
        weaknesses.put(PokemonTypes.Flying, new PokemonTypes[]{PokemonTypes.Electric, PokemonTypes.Ice, PokemonTypes.Rock});
        weaknesses.put(PokemonTypes.Psychic, new PokemonTypes[]{PokemonTypes.Bug, PokemonTypes.Ghost});
        weaknesses.put(PokemonTypes.Bug, new PokemonTypes[]{PokemonTypes.Fire, PokemonTypes.Flying, PokemonTypes.Rock});
        weaknesses.put(PokemonTypes.Rock, new PokemonTypes[]{PokemonTypes.Water, PokemonTypes.Grass, PokemonTypes.Fighting, PokemonTypes.Ground});
        weaknesses.put(PokemonTypes.Ghost, new PokemonTypes[]{PokemonTypes.Ghost});
        weaknesses.put(PokemonTypes.Dragon, new PokemonTypes[]{PokemonTypes.Ice, PokemonTypes.Dragon});
    }

    public static boolean isEffectiveAgainst(PokemonTypes attacker, PokemonTypes defender) {
        return strengths.containsKey(attacker) && Arrays.asList(strengths.get(attacker)).contains(defender);
    }

    public static boolean isWeakAgainst(PokemonTypes attacker, PokemonTypes defender) {
        return weaknesses.containsKey(attacker) && Arrays.asList(weaknesses.get(attacker)).contains(defender);
    }
}
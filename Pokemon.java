enum PokemonTypes{
    Bug, Dragon, Electric, Fighting, Fire, Poison, Rock, Flying, Ghost, Grass, Ground, Ice, Psychic, Water, Normal
}
            
public class Pokemon {
    String name;
    PokemonTypes type;
    public boolean isDead = false;
    int maxhp, def, sp = 100, patk, eatk, currenthp;
    

    public Pokemon(String name, PokemonTypes type, int maxhp, int patk, int eatk, int def) {
        this.name = name;
        this.type = type;
        this.maxhp = maxhp;
        this.currenthp = maxhp;
        this.def = def;
        this.patk = patk;
        this.eatk = eatk;
    }

    public void takeDamage(int damage){
        this.currenthp -= damage;
        checkPokemonDeath(this);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return currenthp;
    }

    @Override
    public String toString() {
        return name + " (" + type + " Type)";
    }

    public void physicalAttack(Pokemon opponentPokemon) {
        int damage = (patk * 7) / (opponentPokemon.def);
    
        if (PokemonTypes1.isEffectiveAgainst(this.type, opponentPokemon.type)) {
            damage *= 2;
            System.out.println(this.name + " deals super effective damage to " + opponentPokemon.name + "!");
        } else if (PokemonTypes1.isWeakAgainst(this.type, opponentPokemon.type)) {
            damage /= 2;
            System.out.println(this.name + " deals not very effective damage to " + opponentPokemon.name + "!");
        }
    
        opponentPokemon.takeDamage(damage);
        
    }
    
    public void elementalAttack(Pokemon opponentPokemon) {
        int damage = (eatk * 7) / (opponentPokemon.def);
    
        if (PokemonTypes1.isEffectiveAgainst(this.type, opponentPokemon.type)) {
            damage *= 2;
            System.out.println(this.name + " deals super effective damage to " + opponentPokemon.name + "!");
        } else if (PokemonTypes1.isWeakAgainst(this.type, opponentPokemon.type)) {
            damage /= 2;
            System.out.println(this.name + " deals not very effective damage to " + opponentPokemon.name + "!");
        }
    
        opponentPokemon.takeDamage(damage);
        
    }

    public void checkPokemonDeath(Pokemon pokemon){
        if(pokemon.currenthp <= 0){
            pokemon.death();
        }
    }
    
    
    public void death(){
        this.isDead = true;
    }

    public void heal(int amount) {
        this.currenthp += amount;
        if (this.currenthp > this.maxhp) {
            this.currenthp = this.maxhp; // Cap HP at maxhp
        }
    }
}
            
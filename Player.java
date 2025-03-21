import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
;

public class Player extends Trainer{
    int pokeballs = 0;
    boolean insideGym, isGoingOut;
    
    public AITrainer goingOutWith;
    public int gymsBeaten = 0;

    ArrayList<String> GoodDialogue = new ArrayList<>(Arrays.asList(
        "Hey, I just wanted to tell you that your clothing looks really good on you and fits your whole vibe.",
        "Hii, your hair looks really good and smells like a field surrounded by beautiful and vibrant flowers.",
        "Your voice sounds so eloquent, every word from your mouth is a sweet rhythm that blesses my ears and fills my stomach with butterflies.",
        "Hi, your eyes look really good and equally as beautiful as the clear blue skies."
    ));

    ArrayList<String> BadDialogue = new ArrayList<>(Arrays.asList(
        "Oh hey, I just wanted to tell you that your fashion sense doesn't make sense and your clothes are as ugly as you.",
        "Err, how much did it cost to get a haircut as ugly as yours? I want to avoid your barber.",
        "Can you please stop looking at me with those weird eyes? It's uncomfortable that a swine like you is staring at me.",
        "Please stop talking, your breath stinks and feels like two clown horns honking in both my ears."
    ));

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
            pokemon.hasTrainer = false; //Reset the hasTrainer stat
        }
    }

    public void healPokemon(){
        for (Pokemon pokemon : this.pokemonCollection) {
            pokemon.heal(pokemon.maxhp); // Heal the Pokémon to full health
            pokemon.isDead = false; // Reset the fainted status
            
        }
    }

    public void talk(AITrainer trainer, Scanner sc){
        //initiate conversation with trainer
        Random random = new Random();
        String goodDialogue = GoodDialogue.get(random.nextInt(GoodDialogue.size()));
        String badDialogue = BadDialogue.get(random.nextInt(BadDialogue.size()));
        List<String> dialogues = new ArrayList();
        dialogues.add(badDialogue);
        dialogues.add(goodDialogue);
        Collections.shuffle(dialogues);

        System.out.println("What should you say?");
        System.out.println("[1] " + dialogues.get(0));
        System.out.println("[2] " + dialogues.get(1));

        int dialogueChoice = sc.nextInt();
        boolean isGoodDialogue;
        while (dialogueChoice < 1 || dialogueChoice > 2) { 
            dialogueChoice = sc.nextInt();
        }

        if(dialogues.get(dialogueChoice - 1).equals(goodDialogue)){
            isGoodDialogue = true;
        }else{
            isGoodDialogue = false;
        }
        

        trainer.respond(isGoodDialogue, sc, this);
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
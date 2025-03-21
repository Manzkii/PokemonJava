import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AITrainer extends Trainer {
    static public ArrayList<String> names = new ArrayList<>(Arrays.asList(
        "Michael Leonard S. Orit", "Todoroki", "Bakugo", "Gojo", "Karane", "Asuka", "Mikasa", "Harima", "Makima", "Kana")
    );

    ArrayList<String> GoodResponse = new ArrayList<>(Arrays.asList(
        "Oh wow, thank you so much for the compliment! I really appreciate it!",
        "Aww, that made my day! You're so sweet!",
        "Oh my, that's really kind of you. Thank you!",
        "That’s one of the nicest things someone has said to me. Thanks!"
    ));

    ArrayList<String> BadResponse = new ArrayList<>(Arrays.asList(
        "Oh... I see. I guess I'll just go now.",
        "Wow, that was rude. I didn't expect that...",
        "You didn’t have to say that. That was unnecessary...",
        "Ouch, that hurt... Why would you say that?"
    ));

    ArrayList<String> askingOutResponses = new ArrayList<>(Arrays.asList(
        "Uhm.. I know this is shameless of me and I mean we've only just met but, do you perhaps want to go out to eat?",
        "Would you like to go out with me?",
        "I like you. Please go out with me.",
        "I wuv you. Please date me.?"
    ));
    
    public int hearts = 0;

    public AITrainer(String name, char gender) {
        super(name, gender); 
    }

    public void makeMove(Pokemon opponent) {
        int random = (int)(Math.random() * 2);
        if(random == 0) {
            int random2 = (int)(Math.random() * 2);
            if(random2 == 0){
                this.fightCommand(1, opponent); 
            }else{
                this.fightCommand(2, opponent);}  
            } else{
                this.interactWithBagCommand();
            }
    }

    public void heartBreak(){
        for(Pokemon pokemon : this.pokemonCollection){
            pokemon.heal(pokemon.maxhp);
            pokemon.patk *= 10;
            pokemon.eatk *= 10;
        }
    }

    public void respond(boolean isGoodDialogue, Scanner sc, Player player){
        Random random = new Random();
        if (isGoodDialogue) {
            System.out.println(this.name + ": " + GoodResponse.get(random.nextInt(GoodResponse.size())));
            hearts++;
            System.out.println("Hearts increased");
            System.out.println(hearts + "/5 Hearts Fulfilled");
        }else{
            System.out.println(this.name + ": " + BadResponse.get(random.nextInt(BadResponse.size())));
            hearts--;
            System.out.println("Hearts decreased");
            System.out.println(hearts + "/5 Hearts Fulfilled");
        }

        if(hearts >= 5){
            System.out.println(this.name + ": " + askingOutResponses.get(random.nextInt(askingOutResponses.size())));
            System.out.println("[1] Yes");
            System.out.println("[2] No");
            int dateChoice = sc.nextInt();
            while(dateChoice < 1 || dateChoice > 2){
                dateChoice = sc.nextInt();
            }

            if(dateChoice == 1){
                System.out.println(this.name + ": " + "Thank you!");
                player.isGoingOut = true;
            }else{
                System.out.println(this.name + ": " + "No, this can't be!");
                System.out.println("Warning! Heartbreak has been activated.");
                System.out.println("How dare you make someone cry.");
                this.heartBreak();
            }
        }
    }

    
}

    
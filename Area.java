import java.util.Random;

enum AreaTypes{
     Bug, Dragon, Electric, Fighting, Fire, Poison, Rock, Flying, Ghost, Grass, Ground, Ice, Psychic, Water, Normal
}


public class Area{
    boolean hasGym;
    int areaNumber;
    AreaTypes areaType;

    private void gymDecider(){
        int randomChoice = (int)Math.random();
        if(randomChoice == 1){
            hasGym = true;
        }else{
            hasGym = false;
        }
    }

    public void randomizeAreaType(){
        Random rand= new Random();
        areaType = AreaTypes.values()[rand.nextInt(AreaTypes.values().length)];
    }

    void Main(){
        gymDecider();
        randomizeAreaType();
    }
}
import java.util.ArrayList;

public class date extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public date() {
        commandPhrases.add("joke");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String joke;
        int rand = (int)Math.floor(Math.random()*(10-1+1)+1);
        switch (rand) {
            case 1:  joke = "I went to buy some camo pants, but couldn’t find any";
                break;
            case 2:  joke = "I was wondering why the frisbee kept getting bigger, and bigger, but then it hit me.";
                break;
            case 3:  joke = "I can’t believe I got fired from the calendar factory. All I did was take a day off.";
                break;
            case 4:  joke = "I was addicted to the hokey pokey, but then I turned myself around.";
                break;
            case 5:  joke = "Two fish are in a tank. One says, ‘How do you drive this thing?’";
                break;
            case 6:  joke = "Build a man a fire and he’ll be warm for a day. Set a man on fire and he’ll be warm for " +
                    "the rest of his life.";
                break;
            case 7:  joke = "I’m reading a book about anti-gravity. It’s impossible to put down.";
                break;
            case 8:  joke = "Before you criticize someone, walk a mile in their shoes. That way, when you do criticize" +
                    " them, you’re a mile away and you have their shoes.";
                break;
            case 9:  joke = "I just got kicked out of a secret cooking society. I spilled the beans.";
                break;
            case 10: joke = "Well, to be Frank with you, I’d have to change my name.";
                break;
        }
    }
}

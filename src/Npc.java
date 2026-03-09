import java.util.Random;

public class Npc{
    private int score;
    private String[] moveSet = {"Rock", "Paper", "Scissors"};
    private Random rand = new Random();
    
    private String[] rockSkills = {"Boulder Smash", "Boulder Guard", "Stone Skin"};
    private String[] paperSkills = {"Origami Storm", "Origami Wall", "Paper Shield"};
    private String[] scissorSkills = {"Guillotine", "Metal Deflect", "Blade Guard"};

    
    public Npc(){
        this.score = 0;
    }
    public void resetScore() {
        this.score = 0;
    }

    public String getMove() {
            String chosenMove = moveSet[rand.nextInt(moveSet.length)];
            return chosenMove;
        }

    public String getSkill(String move) {
        
        String skill = "";

        switch (move.toLowerCase()) {
            case "rock":
                skill = rockSkills[rand.nextInt(rockSkills.length)];
                break;
            case "paper":
                skill = paperSkills[rand.nextInt(paperSkills.length)];
                break;
            case "scissors":
                skill = scissorSkills[rand.nextInt(scissorSkills.length)];
                break;
        }
        return skill;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    

}
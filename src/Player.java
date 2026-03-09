public class Player{

    private int score;
    private String name;
    private int hp = 100;

    private String[] rockSkills = {"Boulder Smash", "Boulder Guard", "Stone Skin"};
    private String[] paperSkills = {"Origami Storm", "Origami Wall", "Paper Shield"};
    private String[] scissorSkills = {"Guillotine", "Metal Deflect", "Blade Guard"};

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public void addScore(){
        score++;
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int health(){
        return hp;
    }

    public String getSkill(String type, int skillAccess) {
        switch (type.toLowerCase()) {
            case "rock":
                if (skillAccess >= 0 && skillAccess < rockSkills.length) {
                    return rockSkills[skillAccess];
                }
                break;
            case "paper":
                if (skillAccess >= 0 && skillAccess < paperSkills.length) {
                    return paperSkills[skillAccess];
                }
                break;
            case "scissors":
                if (skillAccess >= 0 && skillAccess < scissorSkills.length) {
                    return scissorSkills[skillAccess];
                }
                break;
        }
        return "Invalid skill";
    }

}
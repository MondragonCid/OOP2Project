public class Game{
    public static String checkWinner(String playerMove, int playerSkillType, String npcMove, int npcSkillType) {
        
        String winner = "draw";

        if (playerMove.equals("rock") && npcMove.equals("scissors") ||
            playerMove.equals("paper") && npcMove.equals("rock") ||
            playerMove.equals("scissors") && npcMove.equals("paper")) {
            winner = "player";
        } else if (npcMove.equals("rock") && playerMove.equals("scissors") ||
                npcMove.equals("paper") && playerMove.equals("rock") ||
                npcMove.equals("scissors") && playerMove.equals("paper")) {
            winner = "npc";
        }

        
        if (winner.equals("player")) {
            if (npcSkillType == 1) { 
                System.out.println("NPC defended the attack!");
                winner = "draw"; 
            }
        } else if (winner.equals("npc")) {
            if (playerSkillType == 1) { 
                System.out.println(playerMove + " skill blocked the loss!");
                winner = "draw";
            }
        } else if (winner.equals("draw")) {
            if (playerSkillType == 2) {
                System.out.println("Your passive activated! You gain 1 bonus point.");
                winner = "player";
            } else if (npcSkillType == 2) {
                System.out.println("NPC's passive activated! NPC gains 1 bonus point.");
                winner = "npc";
            }
        }

        return winner;
    }
}
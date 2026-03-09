import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        Characters choose = new Characters();
        Npc npc = new Npc();
        Random rand = new Random();

        System.out.println("Welcome to Rock Paper Scissors!");

        for (int i = 10; i <= 100; i+=10){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.print(" " + i + "%");
        }

        System.out.println("\nGame Ready!");
        
        System.out.println("\n-----------System------------");
        System.out.print("Choose your Character:\n[0] Cid\n [1] Vincent\n [2] Nash\nChoose: ");
        int chooseCharacter = scanner.nextInt();
        scanner.nextLine();
        
        Player player = new Player(choose.getCharacter((chooseCharacter)));
        
        String[] map = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        
        int playerPos = 0;
        map[playerPos] = "P";

        while (true){
            for (int i = 0; i < map.length; i++){
                System.out.print(" " + map[i] + " ");
            }
            System.out.println();

            System.out.print("Enter command (a: left, d: right, q: quit): ");
            String command = scanner.nextLine();

            if (command.equals("a") && playerPos > 0){
                map[playerPos] = " ";   
                playerPos--;
            } else if (command.equals("d") && playerPos < map.length - 1){
                map[playerPos] = " ";   
                playerPos++;
            } else if (command.equals("q")){
                System.out.println("Game Over");
                break;
            } else {
                System.out.println("Invalid command. Please enter 'a', 'd', or 'q'.");
                continue;
            }

            map[playerPos] = "P";

            if (rand.nextInt(100) < 30) {  
                System.out.println("\nAn encounter is happening...");

                for (int i = 10; i <= 100; i += 10) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                        System.out.print(" " + i + "%");
            }
            System.out.println("\nA wild enemy appears! Prepare for battle!");
            battle(player, npc, scanner);
        }
}

        scanner.close();
    }

        public static void battle(Player player, Npc npc, Scanner scanner){
        npc.resetScore(); 
        player.resetScore();

        Random rand = new Random();

        while (player.getScore() < 3 && npc.getScore() < 3){
            System.out.print("\nChoose your move, Rock, Paper, Scissors: ");
            String playerMove = scanner.nextLine();

            System.out.print("What skill you will use in " + playerMove + " ? :\n[0]Offense\n[1]Defense\n[2]Passive\nChoose: ");
            int skillAccess = scanner.nextInt();
            scanner.nextLine();

            String chosenSkill = player.getSkill(playerMove, skillAccess);
            System.out.println("You used: " + chosenSkill + "!");

            String npcMove = npc.getMove();
            String npcSkill = npc.getSkill(npcMove);
            int npcSkillType = rand.nextInt(3);

            System.out.println("-----------------------------");
            System.out.println("The NPC chose: " + npcMove + " with " + npcSkill);

            String result = Game.checkWinner(playerMove, skillAccess, npcMove, npcSkillType);

            if (result.equals("player")) {
                System.out.println("You win this round!");
                player.addScore();
            } else if (result.equals("npc")) {
                System.out.println("NPC wins this round!");
                npc.addScore();
            } else {
                System.out.println("It's a draw!");
            }

            System.out.println("Score --> " + player.getName() + " : " + player.getScore() + " | NPC: " + npc.getScore());
        }

        System.out.println("-----------------------------");
        if (player.getScore() == 3){
            System.out.println("You defeated the enemy!");
        } else {
            System.out.println("The enemy defeated you...");
        }
        System.out.println("-----------------------------\n");
    }

}
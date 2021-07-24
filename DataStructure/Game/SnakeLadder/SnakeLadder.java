package Game.SnakeLadder;

import java.util.*;

public class SnakeLadder {
    public static void main(String[] args) {
        System.out.println("Snake and Ladder Demonstration ....");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total Number of cells - ");
        int boardSize = sc.nextInt();
        Map<Integer,Integer> snakesOnBoard = new HashMap<>();
        Map<Integer,Integer> laddersOnBoard = new HashMap<>();

        int[] board = initializeBoard(boardSize , snakesOnBoard , laddersOnBoard);
        System.out.println("Enter the total Number of Dice you want - ");
        int totalDice = sc.nextInt();

        Queue<Player> playerQueue = new LinkedList<>();
        Player player1 = new Player(1 , "Abhilash");
        Player player2 = new Player(2 , "Apurva");
        Player player3 = new Player(3 , "Sharvil");
        playerQueue.add(player1);
        playerQueue.add(player2);
        playerQueue.add(player3);

        startSnakeAndLadder(board ,playerQueue , snakesOnBoard , laddersOnBoard , totalDice);

        System.out.println("Player 1 - Path = " + player1.getPositionsConsidered());
        System.out.println("Player 2 - Path = " + player2.getPositionsConsidered());
        System.out.println("Player 3 - Path = " + player3.getPositionsConsidered());
    }

    private static void startSnakeAndLadder(int[] board, Queue<Player> playerQueue, Map<Integer, Integer> snakesOnBoard,
                                            Map<Integer, Integer> laddersOnBoard , int totalDice) {

        Player player;
        int nextPosition;

        while (!playerQueue.isEmpty())
        {
            player = playerQueue.poll();
            nextPosition = rollDice(totalDice);

            if((player.getCurrentPosition() + nextPosition) > board.length){
                player.getPositionsConsidered().add(player.getCurrentPosition());
                playerQueue.add(player);
            }
            else if ((player.getCurrentPosition() + nextPosition) == board.length){
                player.getPositionsConsidered().add(board.length);
                System.out.println("Player - " + player.getPlayerName() + " has won the game.");
            }
            else if((snakesOnBoard.containsKey(player.getCurrentPosition()+nextPosition))){
                player.setCurrentPosition(snakesOnBoard.get(player.getCurrentPosition()+nextPosition));
                player.getPositionsConsidered().add(player.getCurrentPosition());
                playerQueue.add(player);
            }
            else if((laddersOnBoard.containsKey(player.getCurrentPosition()+nextPosition))){
                player.setCurrentPosition(laddersOnBoard.get(player.getCurrentPosition()+nextPosition));
                player.getPositionsConsidered().add(player.getCurrentPosition());
                playerQueue.add(player);
            } else {
                player.setCurrentPosition(player.getCurrentPosition() + nextPosition);
                player.getPositionsConsidered().add(player.getCurrentPosition());
                playerQueue.add(player);
            }
        }

    }

    private static int rollDice(int totalDice) {
        return new Random().nextInt(6 * totalDice)+1;
    }

    private static int[] initializeBoard(int boardSize, Map<Integer, Integer> snakesOnBoard,
                                         Map<Integer, Integer> laddersOnBoard) {

        int[] board = new int[boardSize];
        Random random = new Random();

        int startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));
        startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));
        startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));
        startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));
        startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));
        startSnakeHead = random.nextInt(boardSize);
        snakesOnBoard.put(startSnakeHead , random.nextInt(startSnakeHead));

        int startLadderHead , nextRandomLadderPoint;
        while (laddersOnBoard.size() != 6){
            startLadderHead = random.nextInt(boardSize);
            nextRandomLadderPoint = random.nextInt(boardSize);

            if(startLadderHead>=0 && nextRandomLadderPoint>=0 && nextRandomLadderPoint > startLadderHead)
                laddersOnBoard.put(startLadderHead , nextRandomLadderPoint);
        }

        System.out.println("Snakes - " + snakesOnBoard);
        System.out.println("Ladders - " + laddersOnBoard);

        return board;
    }
}


class Player {
    int playerId;
    String playerName;
    int currentPosition;
    List<Integer>positionsConsidered;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.currentPosition = 0;
        this.positionsConsidered = new ArrayList<>();
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Integer> getPositionsConsidered() {
        return positionsConsidered;
    }
}



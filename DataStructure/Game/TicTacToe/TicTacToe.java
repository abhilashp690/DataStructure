package Game.TicTacToe;

import java.util.*;

public class TicTacToe{
    public static void main(String[] args) {
        System.out.println("TIC TAC TOE DEMONSTRATION ......");
        System.out.println("==================================================");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board size - ");
        int boardSize = sc.nextInt();

        Queue<Player> queue = new LinkedList<>();
        char[][] ticTacToe = initializeSetup(boardSize , queue);

        playTicTacToe(ticTacToe , queue);
        System.out.println("Total Time Complaexity is O(N^3) as we will in worst case play N^2 moves and for very move check if player wins or not - O(N)");
    }

    private static void playTicTacToe(char[][] ticTacToe, Queue<Player> queue) {
        List<Integer> availableSet = new ArrayList<>();

        for(int i=0 ; i<ticTacToe.length* ticTacToe.length ; i++)
            availableSet.add(i);

        int boardLength = ticTacToe.length;
        Player currentTurn;
        int nextPosition;

        while (availableSet.size() != 0){
            currentTurn = queue.poll();
            nextPosition = getNextPositionOnBoard(availableSet);
            ticTacToe[nextPosition/boardLength][nextPosition%boardLength] = currentTurn.getPlayerSymbol();

            currentTurn.getPositions().add(nextPosition/boardLength + "-" + nextPosition%boardLength);
            if(checkIfPlayerWins(ticTacToe , currentTurn.getPlayerSymbol() , nextPosition)){
                System.out.println("Player - " + currentTurn.playerName + " has won the game.");
                printTicTacToeBoard(ticTacToe);
                return;
            } else {
                queue.add(currentTurn);
                availableSet.remove(new Integer(nextPosition));
            }
        }

        System.out.println("Game is draw , no player wins.");
        printTicTacToeBoard(ticTacToe);

        System.out.println("Moves Used by both the Players are - ");
        Player player = queue.poll();
        System.out.println("Player 1 - " + player.playerName + " played moves - " + player.getPositions());
        player = queue.poll();
        System.out.println("Player 2 - " + player.playerName + " played moves - " + player.getPositions());
    }

    private static boolean checkIfPlayerWins(char[][] ticTacToe, Character playerSymbol, int nextPosition) {

        // Right Now the time complexity of this function to check if player has won or not is O(N) , but this still can be
        // improved to O(1) if we used rowWise sum and colSum Array and diagonal , reverseDiagonal sum equals to N , then simple look up will help.
        // But in order to do that , will need to change Player characters from '0' to -1 and 'X' to 1 , then if Math.abs(sum) == N ,return true.

        int rowNumber = nextPosition/ticTacToe.length;
        int colNumber = nextPosition%ticTacToe.length;
        boolean rowMatch = true , colMatch = true , diagonalMatch = true , reverseDiagonalMatch = true;

        for(int idx=0 ; idx<ticTacToe.length ; idx++){
            if(ticTacToe[rowNumber][idx] != playerSymbol)
                rowMatch = false;

            if(ticTacToe[idx][colNumber] != playerSymbol)
                colMatch = false;

            if(ticTacToe[idx][idx] != playerSymbol)
                diagonalMatch = false;

            if(ticTacToe[idx][ticTacToe.length - idx - 1] != playerSymbol)
                reverseDiagonalMatch = false;
        }

        return reverseDiagonalMatch || diagonalMatch || rowMatch || colMatch;
    }

    private static void printTicTacToeBoard(char[][] ticTacToe) {
        for(int i=0 ; i<ticTacToe.length ; i++){
            for (int j=0 ; j<ticTacToe.length ; j++){
                System.out.print(ticTacToe[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int getNextPositionOnBoard(List<Integer> availableSet) {
        return availableSet.get(new Random().nextInt(availableSet.size()));
    }

    private static char[][] initializeSetup(int boardSize, Queue<Player> queue) {
        Player p1 = new Player(1 , "Abhilash" , 'O');
        Player p2 = new Player(2 , "Sharvil" , 'X');

        queue.add(p1);
        queue.add(p2);

        return new char[boardSize][boardSize];
    }
}


class Player {
    int playerId;
    String playerName;
    Character playerSymbol;
    List<String> positions;

    public Player(int playerId, String playerName,Character playerSymbol) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.positions = new ArrayList<>();
    }

    public Character getPlayerSymbol() {
        return playerSymbol;
    }

    public List<String> getPositions() {
        return positions;
    }
}
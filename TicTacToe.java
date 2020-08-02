import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char [][] gameBoard = {{' ', '|', ' ', '|',' '},
                {'-', '+', '-', '+','-'},
                {' ', '|', ' ', '|',' '},
                {'-', '+', '-', '+','-'},
                {' ', '|', ' ', '|',' '}};

        printBoard(gameBoard);
        int count = 0;

        while (count < 9) {
            count++;
            Scanner scan = new Scanner(System.in);
            System.out.println("enter your placement 1-9");
            int pos = scan.nextInt();
            while (playerPositions.contains(pos) || cpuPositions.contains(pos)) {
                System.out.println("position taken enter correct palcemnt ");
                pos = scan.nextInt();
            }

            placePiece(gameBoard,pos,"player");
            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            //todo setup actual AI 
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            System.out.println(cpuPos);

            placePiece(gameBoard,cpuPos,"cpu");
            printBoard(gameBoard);
            result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
        }

    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol =Arrays.asList(1,4,7);
        List midCol =Arrays.asList(2,5,8);
        List rightCol =Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winningCond = new ArrayList<List>();
        winningCond.add(topRow);
        winningCond.add(midRow);
        winningCond.add(botRow);
        winningCond.add(leftCol);
        winningCond.add(rightCol);
        winningCond.add( midCol);
        winningCond.add(cross1);
        winningCond.add(cross2);

        for(List l : winningCond) {
            if(playerPositions.containsAll(l)) {
                return "Congratualtions!!!!";
            } else if(cpuPositions.containsAll(l)) {
                return "cpu wins!!!";
            } else if(playerPositions.size() + cpuPositions.size() > 9) {
                return "CAT ! its a tie";
            }
        }

        return "";
    }

    public static void placePiece(char[][] gameBoard,int pos,String user) {
        char playerChoice= ' ';
        if(user.equals("player")) {
            playerChoice = 'X';
            playerPositions.add(pos);
        } else {
            playerChoice = 'O';
            cpuPositions.add(pos);
        }

        switch(pos) {
            case 1:
                gameBoard[0][0] = playerChoice;
                break;
            case 2:
                gameBoard[0][2] = playerChoice;
                break;
            case 3:
                gameBoard[0][4] = playerChoice;
                break;
            case 4:
                gameBoard[2][0] = playerChoice;
                break;
            case 5:
                gameBoard[2][2] = playerChoice;
                break;
            case 6:
                gameBoard[2][4] = playerChoice;
                break;
            case 7:
                gameBoard[4][0] = playerChoice;
                break;
            case 8:
                gameBoard[4][2] = playerChoice;
                break;
            case 9:
                gameBoard[4][4] = playerChoice;
                break;
            default:
                break;
        }

    }


    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

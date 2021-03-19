package game;

public class Game {
    private Player player1;
    private Player player2;
    private final int[] winToEnd;
    private int winner;
    private int counterOfMatches = 1;
    public Game(final Player player1, final Player player2, int winToEnd, int m, int n, int k) {
        this.player1 = player1;
        this.player2 = player2;
        this.winToEnd = new int[3];
        this.winToEnd[0]=winToEnd;
        this.winToEnd[1] = this.winToEnd[0];
    }

    public void matches(Board board, int winToEnd) {
        winner = 1;
        while (true) {
            System.out.println(counterOfMatches + "'s match begins.\n");
            play(board);
            if (this.winToEnd[0] == 0) {
                System.out.println(board.getWinTern() + "'s player won a series of " + (2 * winToEnd - this.winToEnd[1] + this.winToEnd[2]) + " matches !");
                break;
            } else if (this.winToEnd[1] == 0) {
                System.out.println(board.getWinTern() + "'s player won a series of " + (2 * winToEnd - this.winToEnd[0] + this.winToEnd[2]) + " matches !");
                break;
            }
            counterOfMatches++;
            Player newPlayer = this.player1;
            this.player1 = this.player2;
            this.player2 = newPlayer;

        }
    }

    private void play(final Board board) {
        int result;
        while (true) {
            result = makeMove(board, this.player1, 1);
            if (result >= 0) {
                break;
            }
            result = makeMove(board, this.player2, 2);
            if (result >= 0) {
                break;
            }
        }
        if (result == 0) {
            System.out.println("Draw");
            winToEnd[2]++;
        } else {
            System.out.println("Player " + (result == winner ? "X" : "O") + " won!\n");
            if (result == 1) {
                winToEnd[0]--;
            } else {
                winToEnd[1]--;
            }
            if (winToEnd[0] != 0 && winToEnd[1] != 0) {
                int local = winToEnd[0];
                winToEnd[0] = winToEnd[1];
                winToEnd[1] = local;
            }
        }
        winner = winner == 1 ? 2 : 1;
    }

    private int makeMove(final Board board, final Player player, final int no) {
        Move moveTo;
        while (true) {
            Board copy = board;
            moveTo = player.makeMove(copy, copy.getTurn());
            if (board.isValid(moveTo)) {
                break;
            }
            System.out.println("Invalid move.\nRe-enter, please");
        }
        final Move move = moveTo;
        System.out.println("\nMove: " + move.toString());
        final Result result = board.makeMove(move);
        if (result == Result.WIN) {
            return no;
        } else if (result == Result.LOSE) {
            return 3 - no;
        } else if (result == Result.DRAW) {
            return 0;
        } else if (result == Result.UNKNOWN) {
            return -1;
        } else {
            throw new AssertionError("Unknown result type" + no);
        }
    }
}

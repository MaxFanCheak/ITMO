package game;

public class Main{

    public static void main(String[] args){
        Input input = new Input();
        Game game = new Game(new HumanPlayer(), new HumanPlayer(), input.winToEnd, input.m, input.m, input.k);
        Board board = new Board(input.m, input.m, input.k);
        game.matches(board, input.k);
    }

}

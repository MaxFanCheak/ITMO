package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Scanner in;
    public HumanPlayer(final Scanner in){
        this.in = in;
    }
    public HumanPlayer(){
        this(new Scanner(System.in));
    }
    @Override
    public Move makeMove(final Position position, final Cell cell) {
       while (true){
           try {
               System.out.println(position.toString());
               System.out.println(cell + "'s turn");
               System.out.print("Row: ");
               int row = in.nextInt() - 1;
               System.out.print("Col: ");
               int col = in.nextInt() - 1;
               return new Move(row, col, cell);
           }catch (InputMismatchException e){
               System.out.println("Invalid move, enter integer, please.");
           }
       }
    }


}

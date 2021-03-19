package game;

import java.util.Random;

public class RandomPlayer implements Player{
    private final Random random = new Random();
    @Override
    public Move makeMove(final Position position, final Cell cell){
        int row;
        int col;
        do{
            row = random.nextInt(position.getM());
            col = random.nextInt(position.getN());
        }while (position.get(row, col, true) != Cell.E);
        return new Move(row, col, cell);
    }

}

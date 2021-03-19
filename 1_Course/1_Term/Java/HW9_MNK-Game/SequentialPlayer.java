package game;

public class SequentialPlayer implements Player{
    @Override
    public Move makeMove(final Position position, final Cell cell){

        for(int row = 0; row<position.getM();row++){
            for(int col = 0; col< position.getN();col++){
                if(position.get(row,col,true)==Cell.E){
                    final Move move = new Move(row,col,cell);
                    if(position.isValid(move)) {
                        return move;
                    }
                }
            }
        }
        throw new AssertionError("No empty cells");
    }
}

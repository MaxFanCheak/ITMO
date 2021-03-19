package game;

public class Move {
    private final int row;
    private final int col;
    private final Cell value;

    public Move(final int row, final int col, final Cell value){
        this.row=row;
        this.col=col;
        this.value=value;
    }
    public String toString(){
        return (row+1 + " " + (col+1) + " " + value);
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public Cell getValue(){
        return value;
    }
}

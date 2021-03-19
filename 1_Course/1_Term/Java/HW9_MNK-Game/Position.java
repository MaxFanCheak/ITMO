package game;

public interface Position {

    Cell get(int row, int col, boolean checker);
    int getM();
    int getN();
    int getK();
    char getWinTern();
    boolean isValid(Move move);
}

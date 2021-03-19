package game;

import java.util.Arrays;

public class Board implements Position{
    private final int m,n,k;
    private final Cell[][] cells;
    private Cell turn, firstTurn, winTurn;
    protected Board(int m, int n, int k){
        this.m=m;
        this.n=n;
        this.k=k;
        cells = new Cell[m][n];
        clearBoard();
        firstTurn=Cell.X;
        turn=Cell.X;
    }

    private void changeFirstPLayer(){
        firstTurn = firstTurn == Cell.X ? Cell.O : Cell.X;
        turn = firstTurn;
    }

    private void clearBoard(){
        for(int r = 0;r<m;r++){
            Arrays.fill(cells[r], Cell.E);
        }
    }
    @Override
    public int getM() {
        return m;
    }
    @Override
    public char getWinTern() {
        return winTurn==Cell.X ? 'X' : 'O';
    }
    @Override
    public int getN() {
        return n;
    }
    @Override
    public int getK() {
        return k;
    }
    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder(" ");
        for(int r = 0;r<n;r++){
            sb.append(r+1);
        }
        sb.append('\n');
        for(int r = 0;r<m;r++){
            sb.append(r+1);
            for(Cell cell : cells[r]){
                if(cell==Cell.E){
                    sb.append('.');
                }else{
                    sb.append(cell);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public Cell get(int row, int col, boolean checker) {
        return checker ? cells[row][col] : cells[col][row];
    }

    @Override
    public boolean isValid(Move move) {
            return 0 <= move.getRow() && move.getRow() < m
                    && 0 <= move.getCol() && move.getCol() < n
                    && get(move.getRow(), move.getCol(), true) == Cell.E
                    && move.getValue() == turn;
    }

    public Cell getTurn() {
        return turn;
    }

    private void finalPosition(){
        System.out.println();
        System.out.println("Final position: ");
        System.out.println(toString());
        clearBoard();
    }
    private Result hasWinner(boolean win){
        finalPosition();
        winTurn=turn;
        changeFirstPLayer();
        return win ? Result.WIN : Result.DRAW;
    }
    private Result checkResult(int row ,int col){
        int[] diagonal = {1,1};
        for(int u = 1;u<Math.min(n,m);u++) {
            if (row + u < m && col + u < n) {
                if (get(row + u, col + u, true) == turn)  diagonal[0]++;
            }
            if (row - u > -1 && col - u > -1) {
                if (get(row - u, col - u, true) == turn)  diagonal[0]++;
            }
            if (row + u < m && col - u > -1) {
                if (get(row + u, col - u, true) == turn)  diagonal[1]++;
            }
            if (row - u > -1 && col + u < n) {
                if (get(row - u, col + u, true) == turn)  diagonal[1]++;
            }
        }
        if(diagonal[0]>=k||diagonal[1]>=k) return hasWinner(true);
        int check1 = row;
        int check2 = col;
        int size = m;
        int count = 1;
        boolean check = true;
        for(int two = 0;two < 2;two++) {
            if(two==1){
                check1 = col;
                check2 = row;
                size = n;
                count = 1;
                check = false;
            }
            for (int u = 1; u < size; u++) {
                if ((check1 + u < size) || check1 - u > -1) {
                    if (check1 + u < size) {
                        if (get(check1 + u, check2, check) == turn)  count++;
                    }
                    if (check1 - u > -1) {
                        if (get(check1 - u, check2, check) == turn)  count++;
                    }
                    continue;
                }
                if (count < k)  count = 0;
            }
            if(count >= k) return hasWinner(true);
        }
        int empty = 0;
        for(int u = 0;u<m;u++){
            for(int v = 0;v<n;v++){
                if(get(u,v,true)==Cell.E) empty++;
            }
        }
        if(empty==0) return hasWinner(false);
        turn = turn==Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }
    public Result makeMove(final Move move) {
        cells[move.getRow()][move.getCol()] = move.getValue();
        return checkResult(move.getRow(), move.getCol());
    }
}

package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceMovesCalculator {
    protected final ChessBoard board;
    protected final ChessPosition myPosition;
    protected final int currentRow;
    protected final int currentCol;
    protected final ChessPiece piece;

    public PieceMovesCalculator(ChessBoard board, ChessPosition myPosition) {
        this.board = board;
        this.myPosition = myPosition;
        this.currentCol = myPosition.getColumn();
        this.currentRow = myPosition.getRow();
        this.piece = board.getPiece(myPosition);
    }

    public Collection<ChessMove> diagonalMoves(){
        Collection<ChessMove> moves = new ArrayList<>();
        boolean q1 = true;
        boolean q2 = true;
        boolean q3 = true;
        boolean q4 = true;
        int shift = 1;

        while(shift < 8 && (q1 || q2 || q3 || q4)){
            if (q1){
                ChessPosition next = new ChessPosition(currentRow+shift, currentCol-shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q1 = false;
                }
            }
            if (q2){
                ChessPosition next = new ChessPosition(currentRow+shift, currentCol+shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q2 = false;
                }
            }
            if (q3){
                ChessPosition next = new ChessPosition(currentRow-shift, currentCol-shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q3 = false;
                }
            }
            if (q4){
                ChessPosition next = new ChessPosition(currentRow-shift, currentCol+shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q4 = false;
                }
            }
            shift ++;
        }

        return moves;
    }

    public Collection<ChessMove> orthogonalMoves(){
        Collection<ChessMove> moves = new ArrayList<>();
        boolean q1 = true;
        boolean q2 = true;
        boolean q3 = true;
        boolean q4 = true;
        int shift = 1;

        while(shift < 8 && (q1 || q2 || q3 || q4)){
            if (q1){
                ChessPosition next = new ChessPosition(currentRow+shift, currentCol);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q1 = false;
                }
            }
            if (q2){
                ChessPosition next = new ChessPosition(currentRow, currentCol+shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q2 = false;
                }
            }
            if (q3){
                ChessPosition next = new ChessPosition(currentRow, currentCol-shift);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q3 = false;
                }
            }
            if (q4){
                ChessPosition next = new ChessPosition(currentRow-shift, currentCol);
                List<Boolean> result = checkValidMove(next);
                if (result.getFirst()){
                    moves.add(new ChessMove(myPosition, next, null));
                }
                if (result.get(1)){
                    q4 = false;
                }
            }
            shift ++;
        }

        return moves;
    }

    public List<Boolean> checkValidMove(ChessPosition position){
        if ((position.getRow() < 1 || position.getRow() > 8) || (position.getColumn() < 1 || position.getColumn() > 8)){
            return List.of(false,true);
        } else if (board.getPiece(position) == null){
            return List.of(true, false);
        } else if (board.getPiece(position).getTeamColor() == piece.getTeamColor()){
            return List.of(false, true);
        } else if (board.getPiece(position).getTeamColor() != piece.getTeamColor()){
            return List.of(true, true);
        }
        return List.of(false,false);
    }
}

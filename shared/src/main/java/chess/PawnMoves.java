package chess;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMoves extends PieceMovesCalculator{
    public PawnMoves(ChessBoard board, ChessPosition myPosition) {
        super(board, myPosition);
    }

    public Collection<ChessMove> pieceMoves(){
        Collection<ChessMove> moves = new ArrayList<>();
        List<ChessPosition> moveOption = getMoveOptions();
        List<Boolean> result0 = checkValidMove(moveOption.getFirst());
        List<Boolean> result1 = checkValidMove(moveOption.get(1));
        List<Boolean> result2 = checkValidMove(moveOption.get(2));
        List<Boolean> result3 = checkValidMove(moveOption.get(3));

        if (result0.getFirst() && result0.get(1)){
            moves.addAll(getAllMoves(moveOption.getFirst()));
        }
        if (result1.getFirst() && result1.get(1)){
            moves.addAll(getAllMoves(moveOption.get(1)));
        }
        if (result2.getFirst() && !(result2.get(1))){
            moves.addAll(getAllMoves(moveOption.get(2)));
            if (inStartPosition()){
                if (result3.getFirst() && !(result3.get(1))){
                    moves.add(new ChessMove(myPosition, moveOption.get(3), null));
                }
            }
        }

        return moves;
    }

    public Boolean checkPromotable(){
        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE){
            return currentRow == 7;
        }
        return currentRow == 2;
    }

    public Collection<ChessMove> getAllMoves(ChessPosition endPosition){
        Collection<ChessMove> moves = new ArrayList<>();
        if (checkPromotable()){
            moves.add(new ChessMove(myPosition, endPosition, ChessPiece.PieceType.KNIGHT));
            moves.add(new ChessMove(myPosition, endPosition, ChessPiece.PieceType.BISHOP));
            moves.add(new ChessMove(myPosition, endPosition, ChessPiece.PieceType.ROOK));
            moves.add(new ChessMove(myPosition, endPosition, ChessPiece.PieceType.QUEEN));
        } else {
            moves.add(new ChessMove(myPosition, endPosition, null));
        }
        return moves;
    }

    public Boolean inStartPosition(){
        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE){
            return currentRow == 2;
        }
        return currentRow == 7;
    }

    public List<ChessPosition> getMoveOptions(){
        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE){
            ChessPosition capture1 = new ChessPosition(currentRow+1, currentCol-1);
            ChessPosition capture2 = new ChessPosition(currentRow+1, currentCol+1);
            ChessPosition forward1 = new ChessPosition(currentRow+1, currentCol);
            ChessPosition forward2 = new ChessPosition(currentRow+2, currentCol);
            return List.of(capture1, capture2, forward1, forward2);
        } else if (piece.getTeamColor() == ChessGame.TeamColor.BLACK){
            ChessPosition capture1 = new ChessPosition(currentRow-1, currentCol-1);
            ChessPosition capture2 = new ChessPosition(currentRow-1, currentCol+1);
            ChessPosition forward1 = new ChessPosition(currentRow-1, currentCol);
            ChessPosition forward2 = new ChessPosition(currentRow-2, currentCol);
            return List.of(capture1, capture2, forward1, forward2);
        }
        return List.of();
    }
}

package chess;

import java.util.Collection;
import java.util.List;

public class QueenMoves extends PieceMovesCalculator{
    public QueenMoves(ChessBoard board, ChessPosition myPosition) {
        super(board, myPosition);
    }

    public Collection<ChessMove> pieceMoves(){
        Collection<ChessMove> moves = diagonalMoves();
        moves.addAll(orthogonalMoves());
        return moves;
    }
}

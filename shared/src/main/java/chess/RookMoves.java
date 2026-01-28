package chess;

import java.util.Collection;
import java.util.List;

public class RookMoves extends PieceMovesCalculator{
    public RookMoves(ChessBoard board, ChessPosition myPosition) {
        super(board, myPosition);
    }

    public Collection<ChessMove> pieceMoves(){
        return orthogonalMoves();
    }
}

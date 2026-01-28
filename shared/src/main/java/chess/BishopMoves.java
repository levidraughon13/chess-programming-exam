package chess;

import java.util.Collection;
import java.util.List;

public class BishopMoves extends PieceMovesCalculator{
    public BishopMoves(ChessBoard board, ChessPosition myPosition) {
        super(board, myPosition);
    }

    public Collection<ChessMove> pieceMoves(){
        return diagonalMoves();
    }
}

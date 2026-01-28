package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMoves extends PieceMovesCalculator{
    public KnightMoves(ChessBoard board, ChessPosition myPosition) {
        super(board, myPosition);
    }

    public Collection<ChessMove> pieceMoves(){
        List<ChessPosition> squares = getMoveOptions();
        Collection<ChessMove> moves = new ArrayList<>();
        for (ChessPosition square : squares){
            if (checkValidMove(square).getFirst()){
                moves.add(new ChessMove(myPosition, square, null));
            }
        }
        return moves;
    }

    public List<ChessPosition> getMoveOptions(){
        ChessPosition s1 = new ChessPosition(currentRow+2, currentCol-1);
        ChessPosition s2 = new ChessPosition(currentRow+2, currentCol+1);
        ChessPosition s3 = new ChessPosition(currentRow-2, currentCol+1);
        ChessPosition s4 = new ChessPosition(currentRow-2, currentCol-1);
        ChessPosition s5 = new ChessPosition(currentRow+1, currentCol+2);
        ChessPosition s6 = new ChessPosition(currentRow-1, currentCol+2);
        ChessPosition s7 = new ChessPosition(currentRow+1, currentCol-2);
        ChessPosition s8 = new ChessPosition(currentRow-1, currentCol-2);
        return List.of(s1,s2,s3,s4,s5,s6,s7,s8);
    }
}

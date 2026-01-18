package piece;

import main.Gamepanel;
import main.Type;
public class Bishop extends Piece {
    public Bishop(int color, int col, int row) {
        super(color, col, row);
        
        type = Type.BISHOP;
        
        if (color == Gamepanel.WHITE) {
            image = getImage("/piece/w-bishop");
        } else {
            image = getImage("/piece/b-bishop");
        }
    }

public boolean canMove(int targetCol, int targetRow) {
    if (isWithinBoard(targetCol, targetRow) && !isSameSquare(targetCol, targetRow)) {
        // Checks if the move is along a diagonal path
        if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) {
            // Validates the target square and ensures no piece is blocking the diagonal path
            if (isValidSquare(targetCol, targetRow) && !pieceIsOnDiagonalLine(targetCol, targetRow)) {
                return true;
            }
        }
    }
    return false;
}
}

    
//    public boolean canMove (int targetCol, int targetRow) {
//        if (isWithinBoard (targetCol,targetRow) && isSameSquare (targetCol, targetRow) == false) {
//            if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) {
//                if(isValidSquare (targetCol,targetRow) && pieceIsOnDiagonalLine(targetCol , targetRow) == false) {
//                	return true;
//                }
//            }
//        }
//        return false;
//    }
//}
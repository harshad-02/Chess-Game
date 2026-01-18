package piece;

import main.Gamepanel;
import main.Type;

public class King extends Piece {
    public King(int color, int col, int row) {
        super(color, col, row);
        
        type = Type.KING;
        
        if (color == Gamepanel.WHITE) {
            image = getImage("/piece/w-king");
        } else {
            image = getImage("/piece/b-king");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if (!isWithinBoard(targetCol, targetRow)) {
            return false; // If the target is not within the board, return false.
        }

        // Regular move logic (assuming this is for a King)
        if (Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
            Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) {
            if (isValidSquare(targetCol, targetRow)) {
                return true;
            }
        }

        // CASTLING
        if (!moved) {
            // Right castling
            if (targetCol == preCol + 2 && targetRow == preRow && !pieceIsOnStraightLine(targetCol, targetRow)) {
                for (Piece piece : Gamepanel.simPieces) {
                    if (piece.col == preCol + 3 && piece.row == preRow && !piece.moved) {
                        Gamepanel.castlingP = piece;
                        return true;
                    }
                }
            }
            // Left castling
            if (targetCol == preCol - 2 && targetRow == preRow && !pieceIsOnStraightLine(targetCol, targetRow)) {
                Piece p[] = new Piece[2];
                for (Piece piece : Gamepanel.simPieces) {
                    if (piece.col == preCol - 3 && piece.row == targetRow) {
                        p[0] = piece;
                    }
                    if (piece.col == preCol - 4 && piece.row == targetRow) {
                        p[1] = piece;
                    }
//                    System.out.println(p[1]);
                    if (p[0] == null && p[1] != null && !p[1].moved) {
                        Gamepanel.castlingP = p[1];
                        return true;
                    }
                }
            }
        }
        // If none of the conditions are met, return false.
        return false;
    }
}

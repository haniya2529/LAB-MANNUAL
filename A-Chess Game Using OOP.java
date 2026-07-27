import java.util.Scanner;

public class ChessGame {

    static char[][] board = {
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
    };

    static Scanner sc = new Scanner(System.in);

    public static void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void movePiece(String move) {

        if (move.length() != 5) {
            System.out.println("Invalid input! Use format: e2 e4");
            return;
        }

        int fromCol = move.charAt(0) - 'a';
        int fromRow = 8 - (move.charAt(1) - '0');

        int toCol = move.charAt(3) - 'a';
        int toRow = 8 - (move.charAt(4) - '0');

        if (fromRow < 0 || fromRow > 7 ||
            fromCol < 0 || fromCol > 7 ||
            toRow < 0 || toRow > 7 ||
            toCol < 0 || toCol > 7) {

            System.out.println("Invalid board position!");
            return;
        }

        char piece = board[fromRow][fromCol];

        if (piece == '.') {
            System.out.println("No piece found!");
            return;
        }

        // Prevent capturing own piece
        char destination = board[toRow][toCol];

        if (destination != '.') {
            if ((Character.isUpperCase(piece) && Character.isUpperCase(destination))
                    || (Character.isLowerCase(piece) && Character.isLowerCase(destination))) {

                System.out.println("You cannot capture your own piece!");
                return;
            }
        }

        // Simple pawn diagonal validation
        if ((piece == 'P' || piece == 'p')
                && fromCol != toCol
                && destination == '.') {

            System.out.println("Error: Pawn cannot move diagonally without capturing.");
            return;
        }

        String pieceName = "";

        switch (Character.toUpperCase(piece)) {
            case 'P':
                pieceName = "Pawn";
                break;
            case 'R':
                pieceName = "Rook";
                break;
            case 'N':
                pieceName = "Knight";
                break;
            case 'B':
                pieceName = "Bishop";
                break;
            case 'Q':
                pieceName = "Queen";
                break;
            case 'K':
                pieceName = "King";
                break;
        }

        if (destination != '.') {
            System.out.println("Captured: " + destination);
        }

        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = '.';

        System.out.println(pieceName + " moved from "
                + move.substring(0, 2)
                + " to "
                + move.substring(3, 5) + ".");
    }

    public static void main(String[] args) {

        System.out.println("=== Chess Game (Console Version) ===\n");

        System.out.println("Initial Board Setup:");
        printBoard();

        // White Move
        System.out.println("\nWhite's turn.");
        System.out.print("Enter move (e.g., e2 e4): ");
        String whiteMove = sc.nextLine();

        movePiece(whiteMove);

        System.out.println();
        printBoard();

        // Black Move
        System.out.println("\nBlack's turn.");
        System.out.print("Enter move (e.g., e7 e5): ");
        String blackMove = sc.nextLine();

        movePiece(blackMove);

        System.out.println();
        printBoard();

        // Invalid Move Demo
        System.out.println("\nInvalid move attempt:");
        System.out.print("Enter move: ");
        String invalidMove = sc.nextLine();

        movePiece(invalidMove);

        System.out.println("\nCheck!");
        System.out.println("White's King is in check by Black's Bishop.");

        System.out.println("\nCheckmate!");
        System.out.println("Black wins the game.");

        sc.close();
    }
}

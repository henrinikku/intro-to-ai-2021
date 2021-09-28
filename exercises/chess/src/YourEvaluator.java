import java.util.Arrays;
import java.util.Collections;

public class YourEvaluator extends Evaluator {

	private double[] pieceValues = new double[13];

	private final double[][][] pieceTables = new double[13][][];

	private final double[][] emptyTable = new double[][] {
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0},
		{0,0,0,0,0,0}
	};
	
	private final double[][] pawnTable = new double[][] {
		{75,75,75,75,75,75},
		{50,50,50,50,50,50},
		{0,20,30,30,20,0},
		{0,-5,5,0,-5,0},
		{5,10,-20,-10,10,5},
		{0,0,0,0,0,0}
	};

	private final double[][] knightTable = new double[][] {
		{-50,-40,-30,-30,-40,-50},
		{-40,-20,0,0,-20,-40},
		{-30,5,15,15,5,-30},
		{-30,10,15,15,10,-30},
		{-40,-20,5,5,-20,-40},
		{-50,-40,-30,-30,-40,-50}
	};

	private final double[][] rookTable = new double[][] {
		{0,0,0,0,0,0},
		{5,10,10,10,10,5},
		{-5,0,0,0,0,-5},
		{-5,0,0,0,0,-5},
		{-5,0,0,0,0,-5},
		{0,0,5,5,0,0}
	};

	private final double[][] queenTable = new double[][] {
		{-20,-10,-5,-5,-10,-20},
		{-10,0,5,5,0,-10},
		{-5,0,5,5,0,-5},
		{-5,5,5,5,0,-5},
		{-10,0,0,0,0,-10},
		{-20,-10,-5,-5,-10,-20}
	};

	private final double[][] kingTable = new double[][] {
		{-30,-40,-50,-50,-40,-30},
		{-30,-40,-50,-50,-40,-30},
		{-30,-40,-50,-50,-40,-30},
		{-10,-30,-50,-50,-30,-10},
		{20,0,0,0,0,20},
		{20,10,0,0,10,20}
	};

	private final double[][] kingTableEndGame = new double[][] {
		{-50,-40,-20,-20,-40,-50},
		{-30,-20,0,0,-20,-30},
		{-30,-10,20,20,-10,-30},
		{-30,-10,20,20,-10,-10},
		{-30,-20,0,0,-20,-30},
		{-50,-40,0,0,-40,-50}
	};

	private final double[][] blackKingTableEndGame = reverse(kingTableEndGame);

	public YourEvaluator() {
		pieceValues[Position.Empty] = 0;
		pieceValues[Position.WPawn] = 100;
		pieceValues[Position.BPawn] = -100;
		pieceValues[Position.WKnight] = 300;
		pieceValues[Position.BKnight] = -300;
		pieceValues[Position.WRook] = 500;
		pieceValues[Position.BRook] = -500;
		pieceValues[Position.WQueen] = 900;
		pieceValues[Position.BQueen] = -900;
		pieceValues[Position.WKing] = 9000;
		pieceValues[Position.BKing] = -9000;

		pieceTables[Position.Empty] = emptyTable;
		pieceTables[Position.WPawn] = pawnTable;
		pieceTables[Position.BPawn] = reverse(pawnTable);
		pieceTables[Position.WKnight] = knightTable;
		pieceTables[Position.BKnight] = reverse(knightTable);
		pieceTables[Position.WRook] = rookTable;
		pieceTables[Position.BRook] = reverse(rookTable);
		pieceTables[Position.WQueen] = queenTable;
		pieceTables[Position.BQueen] = reverse(queenTable);
		pieceTables[Position.WKing] = kingTable;
		pieceTables[Position.BKing] = reverse(kingTable);
	}

	public double eval(Position p) {
		double value = 0;
		boolean endgame = isEndgame(p);
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				int piece = p.board[x][y];
				value += pieceValues[piece];

				double[][] pieceTable = pieceTables[piece];
				if (endgame) {
					if (piece == Position.WKing)
						pieceTable = kingTableEndGame;
					if (piece == Position.BKing)
						pieceTable = blackKingTableEndGame;
				}
				value += pieceTable[y][x];
			}
		}
		return value;
	}

	private boolean isEndgame(Position p) {
		boolean wQueen = false;
		boolean bQueen = false;
		int wPiecesLeft = 0;
		int bPiecesLeft = 0;
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				int piece = p.board[x][y];
				if (piece == Position.WQueen)
					wQueen = true;
				if (piece == Position.BQueen)
					bQueen = true;
				if (piece == Position.WKnight)
					wPiecesLeft += 1;
				if (piece == Position.WRook)
					wPiecesLeft += 2;
				if (piece == Position.BKnight)
					bPiecesLeft += 1;
				if (piece == Position.BRook)
					bPiecesLeft += 2;
			}
		}
		
		return (!wQueen || wPiecesLeft <= 1) && (!bQueen || bPiecesLeft <= 1);
	}

	private double[][] reverse(double[][] arr) {
		double[][] copy = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < copy.length; i++) {
			copy[i] = Arrays.copyOf(copy[i], copy[i].length);
			Collections.reverse(Arrays.asList(copy[i]));
		}
		Collections.reverse(Arrays.asList(copy));
		return copy;
	}
}


public class TicTacToeBoard {
	/** This class represents the tic tac toe games 'board'
	 * it will use a 2D array to 'place' the X and O. It will
	 * also be able to determine if there's a winner or not*/
	
	private GamePiece[][] game_board = new GamePiece[3][3]; //tic tac toe so 3x3 board
	private int total_pieces_on_board = 0;
	
	public void place_on_board(GamePiece given_piece) {
		total_pieces_on_board += 1;
		game_board[given_piece.get_row()][given_piece.get_col()] = given_piece; //add to desired location on board
	}
	
	public void print_board() {
		for (int i = 0; i < game_board.length; i++) { //row
			System.out.println();
			for (int j = 0; j < game_board[0].length; j++) { //column
				if (game_board[i][j] == null) {
					System.out.print("[]" + " ");
				} else {
					System.out.print(game_board[i][j].get_type() + " ");
				}
			}
		}
		System.out.println();
	}
	
}

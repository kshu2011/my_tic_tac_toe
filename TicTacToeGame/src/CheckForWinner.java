import java.util.ArrayList;

public class CheckForWinner {
	/** This class will be able to check if a 
	 * TicTacToeBoard has a winner or not*/
	
	//Note that this is outside the check() method which is called recursively
	//check() adds things to this list but it's outside of the recursion so retains everything added
	private ArrayList<GamePiece> checked_pieces = new ArrayList<GamePiece>();//keep track of whats been checked
	
	public int check(TicTacToeBoard given_board, String player, int row, int col) {
		//this method takes two parameters, TicTacToeBoard and a player 
		// x or o and see if they have won
		
		int result = 0; //default
				
		//make sure within board and that game piece is there to be checked
		if ( row >= 0 && row <= 2 && col >= 0 && col <= 2 && 
				given_board.get_board()[row][col] != null && given_board.get_board()[row][col].get_type() == player 
				&& given_board.get_board()[row][col].get_checked() == false) {
			result += 1; //increment
			given_board.get_board()[row][col].set_checked(true); //mark the piece as checked
			checked_pieces.add(given_board.get_board()[row][col]); //add it to the checked list
			result += check(given_board, player, row - 1, col);
			result += check(given_board, player, row - 1, col - 1);
			result += check(given_board, player, row, col - 1);
			result += check(given_board, player, row + 1, col - 1);
			result += check(given_board, player, row + 1, col);
			result += check(given_board, player, row + 1, col + 1);
			result += check(given_board, player, row, col + 1);
			result += check(given_board, player, row - 1, col + 1);
		}
		return result;
	}
	
	public void reset_checker() { //reset all pieces to not checked then clear the list too
		for (int i = 0; i < checked_pieces.size(); i++) {
			checked_pieces.get(i).set_checked(false);
		}
		checked_pieces.clear();
	}
	
	public void print_list() { //just for testing, I wanted to see what was being saved to the ArrayList
		for (int i = 0; i < checked_pieces.size(); i++) {
			System.out.println("Piece is: " + checked_pieces.get(i).get_type() + " Checked: "
					+ checked_pieces.get(i).get_checked());
		}
	}
}

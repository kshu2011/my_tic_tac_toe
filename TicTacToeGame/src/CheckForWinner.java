import java.util.ArrayList;

public class CheckForWinner {
	/** This class will be able to check if a 
	 * TicTacToeBoard has a winner or not. It uses recursion
	 * to check if another 'o' or 'x' is next to the piece, if
	 * it finds at least 3 in a line then there's a winner*/
	
	
	//Note that this is outside the check() method which is called recursively
	//check() adds things to this list but it's outside of the recursion so retains everything added
	private ArrayList<GamePiece> checked_pieces = new ArrayList<GamePiece>();//keep track of whats been checked
	
	public String check(TicTacToeBoard given_board, String player, int row, int col) {
		/** This method takes 4 parameters, the TicTacToeBoard, String player, 
		 * int row, int col. Then it calls on check_vertical_horizontal() and 
		 * check_diagonal to see if there are pieces that are next to each other.
		 * Lastly, the check_slope is called to determine if any of the neighboring
		 * pieces allow the formation of a "line", if so, then we have a winner!*/

		String winner = "None";
		int check_result = 0;
		check_result = check_vertical_horizontal(given_board, player, row, col);
		if (check_result < 3) {//if vertical does not have 3 total pieces, let's check diagonal
			reset_checker(); //reset so that pieces won't be marked as "checked"
			check_result = check_diagonal(given_board, player, row, col);
		}

		String slope_result = check_slope(row, col); 
		if (slope_result == "Line" && check_result >= 3) { //it's a line and there's 3 of them, WIN!
			winner = player + " WON!";
		}
		
		return winner;
	}
	
	
	public int check_vertical_horizontal(TicTacToeBoard given_board, String player, int row, int col) {
		/** This method takes in the TicTacToeBoard, String Player, int row, int col as parameters.
		 * It then uses recursion to check if there are neighboring 'pieces' that are of the same type
		 * if so it will add them to checked_pieces array list and return the total number of
		 * neighbors found as a result.*/
		
		int result = 0; //default
		//make sure within board, game piece is there, and it's same type of player (o/x)
		if ( row >= 0 && row <= 2 && col >= 0 && col <= 2 && 
				given_board.get_board()[row][col] != null && given_board.get_board()[row][col].get_type() == player 
				&& given_board.get_board()[row][col].get_checked() == false) {
			result += 1; //increment
			given_board.get_board()[row][col].set_checked(true); //mark the piece as checked
			checked_pieces.add(given_board.get_board()[row][col]); //add it to the checked list
			result += check_vertical_horizontal(given_board, player, row - 1, col);
			result += check_vertical_horizontal(given_board, player, row, col - 1);
			result += check_vertical_horizontal(given_board, player, row + 1, col);
			result += check_vertical_horizontal(given_board, player, row, col + 1);
		}
		
		return result;
	}
	
	public int check_diagonal(TicTacToeBoard given_board, String player, int row, int col) {
		/** This method takes in the TicTacToeBoard, String Player, int row, int col as parameters.
		 * It then uses recursion to check if there are neighboring 'pieces' that are of the same type
		 * if so it will add them to checked_pieces array list and return the total number of
		 * neighbors found as a result.*/
		
		int result = 0; //default
		//make sure within board, game piece is there, and it's same type of player (o/x)
		if ( row >= 0 && row <= 2 && col >= 0 && col <= 2 && 
				given_board.get_board()[row][col] != null && given_board.get_board()[row][col].get_type() == player 
				&& given_board.get_board()[row][col].get_checked() == false) {
			result += 1; //increment
			given_board.get_board()[row][col].set_checked(true); //mark the piece as checked
			checked_pieces.add(given_board.get_board()[row][col]); //add it to the checked list
			result += check_diagonal(given_board, player, row - 1, col - 1);
			result += check_diagonal(given_board, player, row + 1, col - 1);
			result += check_diagonal(given_board, player, row + 1, col + 1);
			result += check_diagonal(given_board, player, row - 1, col + 1);
		}
		
		return result;
	}
	
	
	private String check_slope(int current_row, int current_col) {
		/** This function takes in 2 parameters, the row and the column. It will
		 * check all the GamePieces in the checked_pieces array to see if there's at
		 * least 3 pieces that form a "line", if so we have a winner! and this function will return
		 * "Line" in that case. */
		
		String slope_result = "None"; //default result
		ArrayList<Integer> slopes_are = new ArrayList<Integer>(); //save the slope calculations
		
		if (checked_pieces.size() >= 3) {
			int x_current = current_row; //row can be x
			int y_current = current_col; //col can be y
			String x = Integer.toString(x_current);
			String y = Integer.toString(y_current);
			String current_location = x + y; //current location in String form
			int pieces_with_same_slope = 0;
			int slope = 0; //default
			
			for (int i = 0; i < checked_pieces.size(); i++) {
				x = Integer.toString(checked_pieces.get(i).get_row());
				y = Integer.toString(checked_pieces.get(i).get_col());
				String next_loc = x + y;
				if (!(current_location.equals(next_loc))) {
					int x_next = checked_pieces.get(i).get_row(); //next one
					int y_next = checked_pieces.get(i).get_col(); //next one
					if ((x_current - x_next) != 0) { 
						 slope = (y_current - y_next) / (x_current - x_next); //calculate slope
						 slopes_are.add(slope); 
					} else { // be "something" / 0, so it's infinite
						slope = 999999; //just put something large here
						slopes_are.add(slope); 
					}	
				}
			}
			for (int i = 0; i < slopes_are.size(); i++) {
				int target_slope = slopes_are.get(i); //pick a slope to match
				pieces_with_same_slope = 0; //reset to 0 and so can correctly check number of slopes for next
				for (int j = i; j < slopes_are.size(); j++) {
					if (slopes_are.get(j) == target_slope) {
						pieces_with_same_slope += 1;
					}
				}
				if (pieces_with_same_slope == 2) { //then we're done, found 2 slopes that are equal
					slope_result = "Line";
					break;
				}
			}
		}
		return slope_result;
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

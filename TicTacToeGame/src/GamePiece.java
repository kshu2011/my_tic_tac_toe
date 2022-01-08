
public class GamePiece {
	/** This object will represent 'X' or 'O' for
	 * the tic tac toe game. It will know it's own type
	 * and its location and whether or not it has been "checked" when
	 * game is determining if there is a winner or not*/
	
	private String piece_type;
	private boolean checked;
	private char[] the_location;
	
	GamePiece(String given_type, String given_location) {
		piece_type = given_type;
		checked = false;
		the_location = given_location.toCharArray();
	}
	
	public boolean get_checked() {
		return checked;
	}
	
	public String get_type() {
		return piece_type;
	}
	
	public int get_row() { //get the row number
		int row_is = Integer.parseInt(Character.toString(the_location[0]));
		return row_is;
	}
	
	public int get_col() { //get the col number
		int col_is = Integer.parseInt(Character.toString(the_location[1]));
		return col_is;
	}
	
	public void set_checked(boolean input_boolean) {
		checked = input_boolean;
	}
}


public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------testing GamePiece ---------");
		GamePiece first = new GamePiece("x", "10");
		System.out.println(first.get_checked());
		System.out.println(first.get_type());
		System.out.println(first.get_row());
		System.out.println(first.get_col());
		first.set_checked(true);
		System.out.println(first.get_checked());
		
		TicTacToeBoard theboard = new TicTacToeBoard();
		theboard.place_on_board(first);
		theboard.print_board();
		GamePiece second = new GamePiece("o", "22");
		theboard.place_on_board(second);
		theboard.print_board();
	}

}

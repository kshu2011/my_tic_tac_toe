import java.util.Scanner;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------testing GamePiece and Board (place/print)---------");
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
		
		
		//testing my recursion solution thingy with a new game....
		System.out.println("--------new board testing CheckForWinner-------");
		TicTacToeBoard new_board = new TicTacToeBoard();
		GamePiece apiece = new GamePiece("x", "10");
		new_board.place_on_board(apiece);
		new_board.print_board();
		
		CheckForWinner checker = new CheckForWinner();
		System.out.println(checker.check(new_board, "x", 1, 0));
		checker.reset_checker(); //uncheck everything
		
		apiece = new GamePiece("x", "00");
		new_board.place_on_board(apiece);
		new_board.print_board();
		System.out.println(checker.check(new_board, "x", 0, 0));
		checker.reset_checker();
		
		apiece = new GamePiece("x", "20");
		new_board.place_on_board(apiece);
		new_board.print_board();
		System.out.println(checker.check(new_board, "x", 2, 0));
		checker.print_list();
		
		checker.reset_checker();
		System.out.println(checker.check(new_board, "x", 2, 0));
		checker.reset_checker();

		
		
		apiece = new GamePiece("x", "22");
		new_board.place_on_board(apiece);
		new_board.print_board();
		System.out.println(checker.check(new_board, "x", 2, 2));
		checker.reset_checker();
		
		//can test using user input
//		Scanner input = new Scanner(System.in);
//		String user_input = "";
//		while (user_input != "STOP") {
//			System.out.print("Your input: ");
//			user_input = input.next();
//			
//			String player_is = user_input.replaceAll("[0-9]", ""); //get the letter, eliminates all numbers
//			String desired_location = user_input.replaceAll("[^0-9]", ""); //get number, eliminate everything else
//			GamePiece another = new GamePiece(player_is, desired_location);
//			theboard.place_on_board(another);
//			theboard.print_board();
//		}
	}

}

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
		GamePiece apiece = new GamePiece("x", "00");
		new_board.place_on_board(apiece);
		new_board.print_board();
		
		CheckForWinner checker = new CheckForWinner();
		System.out.println(checker.check(new_board, "x", 0, 0));
		checker.reset_checker(); //uncheck everything
		
		apiece = new GamePiece("x", "11");
		new_board.place_on_board(apiece);
		new_board.print_board();
		System.out.println(checker.check(new_board, "x", 1, 1));
		checker.reset_checker();
		
		apiece = new GamePiece("x", "22");
		new_board.place_on_board(apiece);
		new_board.print_board();
		String result = checker.check(new_board, "x", 2, 2);
		checker.print_list();
		System.out.println(result);
		
		System.out.println("------ new game -------");
		
		TicTacToeBoard game2 = new TicTacToeBoard();
		GamePiece p1 = new GamePiece("o", "00");
		game2.place_on_board(p1);
		GamePiece p2 = new GamePiece("x", "10");
		game2.place_on_board(p2);
		GamePiece p3 = new GamePiece("o", "02");
		game2.place_on_board(p3);
		GamePiece p4 = new GamePiece("x", "22");
		game2.place_on_board(p4);
		GamePiece p5 = new GamePiece("o", "11");
		game2.place_on_board(p5);
		game2.print_board();
		CheckForWinner c1 = new CheckForWinner();
		String r1 = c1.check(game2,  "o", 1, 1);
		System.out.println(r1);
		c1.reset_checker();
		
		GamePiece p6 = new GamePiece("x", "12");
		game2.place_on_board(p6);
		game2.print_board();
		String r2 = c1.check(game2,  "x", 1, 2);
		System.out.println(r2);
		c1.reset_checker();
		
		GamePiece p7 = new GamePiece("o", "21");
		game2.place_on_board(p7);
		game2.print_board();
		String r3 = c1.check(game2,  "o", 2, 1);
		System.out.println(r3);
		c1.reset_checker();
		
		GamePiece p8 = new GamePiece("x", "20");
		game2.place_on_board(p8);
		game2.print_board();
		String r4 = c1.check(game2,  "x",  2, 0);
		System.out.println(r4);
		c1.reset_checker();
		
		GamePiece p9 = new GamePiece("o", "01");
		game2.place_on_board(p9);
		game2.print_board();
		String r5 = c1.check(game2, "o", 0, 1);
		System.out.println(r5);
		c1.reset_checker();
		
		System.out.println("---------- new game again! (no winners) -------------");
		CheckForWinner check = new CheckForWinner();
		TicTacToeBoard game3 = new TicTacToeBoard();
		GamePiece pp = new GamePiece("o", "00");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "o", 0, 0)); // should be None
		check.reset_checker();
		
		pp = new GamePiece("x", "11");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "x", 1, 1)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("o", "10");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "o", 1, 0)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("x", "22");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "x", 2, 2)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("o", "02");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "o", 0, 2)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("x", "20");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "x", 2, 0)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("o", "21");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "o", 2, 1)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("x", "01");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "x", 0, 1)); //should be None still
		check.reset_checker();
		
		pp = new GamePiece("o", "12");
		game3.place_on_board(pp);
		game3.print_board();
		System.out.println(check.check(game3, "o", 1, 2)); //should be None still
		check.reset_checker();
		
		
	}

}

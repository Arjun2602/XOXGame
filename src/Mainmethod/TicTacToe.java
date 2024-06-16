package Mainmethod;

import java.util.*;

public class TicTacToe{
	static String board[];
	static String turn;
	
	public static String checkWinner() {
		for(int i = 0; i < 8; i++) {
			String line = null;
			switch(i) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;	
			}
			
			if(line.equals("XXX")) {
				return "X";
			}else if(line.equals("OOO")) {
				return "O";
			}
		}
		for(int i = 1; i <= 9; i++) {
			if(Arrays.asList(board).contains(String.valueOf(i))) {
				break;
			}else {
				if(i == 9) {
					return "draw";
				}
			}
		}
		System.out.println(turn+"'s turn");
		return null;
	}
	
	public static void printBoard() {
		System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
		System.out.println("-+-+-");
		System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
		System.out.println("-+-+-");
		System.out.println(board[6]+"|"+board[7]+"|"+board[8]);
	}
	
	public static void main(String args[]) {
		board = new String[9];
		turn = "X";
		String winner = null;
		
		for(int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i+1);
		}
		
		Scanner sc = new Scanner(System.in);
		printBoard();
		System.out.println("Welcome to tic tac toe Game!");
		System.out.println("Game starts with X!(1-9)");
		
		while(winner == null) {
			int num = sc.nextInt();
			if(board[num - 1].equals(String.valueOf(num))) {
				board[num - 1] = turn;
				
				if(turn.equals("X")) {
					turn = "O";
				}else {
					turn = "X";
				}
				
				printBoard();
				winner = checkWinner();
			}else {
				System.out.println("Position already places.try another! :");
			}
		}
		if(winner.equals("draw")) {
			System.out.println("Draw the Match!");
		}else {
			System.out.println("Congratulations "+winner+" Wins!");
		}
	}
}


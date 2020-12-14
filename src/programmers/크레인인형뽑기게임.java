package programmers;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int answer = 0;
		
		Stack<Integer> basket = new Stack<Integer>();
		
		for(int cnt = 0; cnt<moves.length; cnt++) {
			int column = moves[cnt];
			for(int i=0; i<board.length; i++) {
				if(board[i][column-1] != 0) {
					basket.push(board[i][column-1]);
					board[i][column-1] = 0;
					break;
				}
			}
			
			if(basket.size() > 1) {
				int doll1 = basket.peek();
				int doll2 = basket.elementAt(basket.size()-2);
				
				if(doll1 == doll2) {
					basket.pop();
					basket.pop();
					answer += 2;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}

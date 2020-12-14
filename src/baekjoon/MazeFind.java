package baekjoon;

import java.util.*;

/*
 문제URL : https://ktko.tistory.com/entry/%ED%83%90%EC%83%89%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89DFS-Depth-First-Search
 */



public class MazeFind {
	static int[] moveX = {0, 1, 0, -1};  //상 우 하 좌
	static int[] moveY = {-1, 0, 1, 0};
	static int startX = 0;
	static int startY = 0;
	static int stepCnt = 0;
	static int answer = 0;
	static boolean[][] visit;
	int[][] ad;
	int N;
	
	public static void dfs(boolean[][] visit, int stepCnt) {
		
		if(startX == 4 && startY == 4) {
			answer = stepCnt;
		}
			
		
		else {
			
			visit[startY][startX] = true;

			for(int i=0; i<4; i++) {
				int nextX = startX + moveX[i];
				int nextY = startY + moveY[i];
				
				if(nextX<0 || nextX>4 || nextY<0 || nextY>4) 
					continue;
				
				if(visit[nextY][nextX] == true)
					continue;
				
				startX = nextX;
				startY = nextY;
				stepCnt++;
				
				dfs(visit, stepCnt);
			}
		}
	}
	
	public static void main(String[] args) {
		
		visit = new boolean[][] {
			{false, false, false, false, false},
			{true, true, true, true, false},
			{false, false, false, false, false},
			{false, true, false, true, true},
			{false, false, false, false ,false}
		};
		
		
		dfs(visit, stepCnt);
		
		System.out.println(answer);
	}

}

package SWEA;

import java.util.*;
import java.io.*;

class Ä¡ÁîµµµÏ {
	static int[] moveX = {0,1,0,-1};
	static int[] moveY = {-1,0,1,0}; 
	static int maxDay = 100; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		
		for(int cases=0; cases<T; cases++) {
			int N = Integer.parseInt(br.readLine());
			int[][] cheese = new int[N][N];
			int global = 0;
			
			for(int i=0; i<N; i++) {
				String[] row = br.readLine().split(" ");
				
				for(int j=0; j<row.length; j++) {
					cheese[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			int start = 0;
			
			while(start <= maxDay) {
				boolean[][] isEat = new boolean[N][N];
				int local = 1;
				
				for(int i=0; i<cheese.length; i++) {
					for(int j=0; j<cheese.length; j++) {
						cheese[i][j] -= 1;
						if(cheese[i][j] <=0) 
							isEat[i][j] = true;
					}
				}
				
				for(int i=0; i<isEat.length; i++) {
					for(int j=0; j<isEat.length; j++) {
						if(!isEat[i][j]) {
							local++;
							dfs(isEat, i, j);
						}
					}
				}
				
				if(local >= global) {
					global = local;
				}
				start++;
			}
			
			answer[cases] = global;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.printf("#%d %d\n", i+1, answer[i]);
		}
		
		br.close();
		
	}
	
	static void dfs(boolean[][] isEat, int y, int x) {
		isEat[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX < 0 || nextX >= isEat.length || nextY < 0 || nextY >= isEat.length) 
				continue;
			
			if(isEat[nextY][nextX])
				continue;
			
			dfs(isEat, nextY, nextX);
		}
	}

}

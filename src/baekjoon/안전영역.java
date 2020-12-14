package baekjoon;

import java.util.*;
import java.io.*;

public class 안전영역 {
	static int[] moveX = {0,1,0,-1}; 
	static int[] moveY = {-1,0,1,0};
	static int maxDay = 0;
	static int start = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int N = Integer.parseInt(s);
		int[][] area = new int[N][N];
		boolean[][] lockDown = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j=0; j<row.length; j++) {
				area[i][j] = Integer.parseInt(row[j]);
				if(maxDay < area[i][j])
					maxDay = area[i][j];
			}
		}
		//System.out.println();
		//printArea(area);
		getSafetyZone(area); 
		
	}
	
	
	static void printArea(int[][] area) {
		for(int[] arr : area) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	static void getSafetyZone(int[][] area) {
		int global = 1;
		
		while(start < maxDay) {
			int local = 0;
			boolean[][] lockDown = new boolean[area.length][area.length];
			
			for(int i=0; i<area.length; i++) {
				for(int j=0; j<area.length; j++) {
					area[i][j] -= 1;
					if(area[i][j] <=0) {
						lockDown[i][j] = true;
					}
				}
			}
			
			for(int i=0; i<lockDown.length; i++) {
				for(int j=0; j<lockDown.length; j++) {
					if(lockDown[i][j]!=true) {
						local += 1;
						dfs(lockDown, i,j);
					}
				}
			}
			
			if(local >= global)
				global = local;
			
			start++;
		}
		
		System.out.println(global);
		
	}
	
	static void dfs(boolean[][] lockDown, int y, int x) {
		lockDown[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX < 0 || nextX >= lockDown.length || nextY < 0 || nextY >= lockDown.length) 
				continue;
			
			if(lockDown[nextY][nextX])
				continue;
			
			dfs(lockDown, nextY, nextX);
			
		}
	}

}

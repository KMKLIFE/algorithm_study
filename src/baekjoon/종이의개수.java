package baekjoon;

import java.util.*;
import java.io.*;

public class 종이의개수 {
	static int[][] paper;
	static int N;
	static int minus = 0;
	static int zero = 0;
	static int one = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		check(0, 0, N);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	
	private static void check(int y, int x, int N) {
		int first = paper[y][x];
		boolean flag = false;
		
		for(int i=y; i<y+N; i++) {
			for(int j=x; j<x+N; j++) {
				if(paper[i][j] != first) {
					div(y, x, N);
					flag = true;
					break;
				}
			}
			if(flag) 
				break;
		}
		
		if(!flag) {
			if(first == -1) 
				minus += 1;
			else if(first == 0)
				zero += 1;
			else
				one += 1;
		}
	}
	
	private static void div(int y, int x, int N) {
		int newN = N / 3;
		//상왼 상중 상오
		check(y, x, newN);
		check(y, x+newN, newN);
		check(y, x+newN*2, newN);
		
		//중왼 중중 중오
		check(y+newN, x, newN);
		check(y+newN, x+newN, newN);
		check(y+newN, x+newN*2, newN);
		
		//하왼 하중 하오
		check(y+newN*2, x, newN);
		check(y+newN*2, x+newN, newN);
		check(y+newN*2, x+newN*2, newN);
		
	}

}

package baekjoon;

import java.util.*;
import java.io.*;

public class ÄõµåÆ®¸® {
	static String str = "";
	static int[][] image;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		
		for(int i=0; i<image.length; i++) {
			String row = br.readLine();
			for(int j=0; j<row.length(); j++) {
				image[i][j] = row.charAt(j) - '0';
			}
		}
		
		//printImage(image);
		check(0,0,N);
		System.out.println(str);
		
	}
	
	private static void check(int y, int x, int n) {
        int first = image[y][x];
        boolean flag = false;
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (image[i][j] != first) {
                    split(y, x, n);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (!flag) {
            if (first == 1) {
                str+= "1";
            } else {
            	str += "0";
            }
        }
    }
	
	private static void split(int y, int x, int n) {
		int newN = n / 2;
		
		str += "(";
		check(y, x, newN);
		check(y, x+newN, newN);
		check(y+newN, x, newN);
		check(y+newN, x+newN, newN);
		str += ")";
	}
	
}

package baekjoon;
import java.io.*;
import java.util.*;

public class 肺嚎没家扁 {

	static class Point{
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		Queue<肺嚎没家扁.Point> qu = new LinkedList<肺嚎没家扁.Point>();
		
		int N = Integer.parseInt(st.nextToken());
		int Px = Integer.parseInt(st.nextToken());
		int Py = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String[] candidate = br.readLine().split(" ");
			for(int j=0; j<candidate.length; j++) {
				int x_codinate = Integer.parseInt(candidate[0]);
				int y_codinate = Integer.parseInt(candidate[1]);
				
				肺嚎没家扁.Point point = new 肺嚎没家扁.Point(x_codinate, y_codinate);
				qu.add(point);
			}
		}
		
	}
	
	static double getDistance(肺嚎没家扁.Point p1, 肺嚎没家扁.Point p2) {
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
		
		return distance;
	}

}

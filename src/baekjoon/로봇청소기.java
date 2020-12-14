package baekjoon;
import java.io.*;
import java.util.*;

public class �κ�û�ұ� {

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
		Queue<�κ�û�ұ�.Point> qu = new LinkedList<�κ�û�ұ�.Point>();
		
		int N = Integer.parseInt(st.nextToken());
		int Px = Integer.parseInt(st.nextToken());
		int Py = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String[] candidate = br.readLine().split(" ");
			for(int j=0; j<candidate.length; j++) {
				int x_codinate = Integer.parseInt(candidate[0]);
				int y_codinate = Integer.parseInt(candidate[1]);
				
				�κ�û�ұ�.Point point = new �κ�û�ұ�.Point(x_codinate, y_codinate);
				qu.add(point);
			}
		}
		
	}
	
	static double getDistance(�κ�û�ұ�.Point p1, �κ�û�ұ�.Point p2) {
		double distance = 0;
		
		distance = Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
		
		return distance;
	}

}

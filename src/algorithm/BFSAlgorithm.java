package algorithm;
import java.util.*;

public class BFSAlgorithm {

	static int N;
	static int E;
	static boolean[] visit;
	static int[][] ad;
	public static void bfs(int i){
		
		Queue<Integer> qu = new LinkedList<Integer>(); 
		
		qu.offer(i);
		visit[i] = true;
		
		while(!qu.isEmpty()) {
			int temp = qu.poll();
			System.out.print(temp + " ->");
			
			for(int j=1; j<=N; j++) {
				if(ad[temp][j] == 1 && visit[j] == false) {
					qu.offer(j);
					visit[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		N = 6;
		E = 16;
		ad = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		int[][] graph = new int[][]  {
			{1,5},
			{1,6},
			{2,3},
			{2,4},
			{2,6},
			{3,4},
			{3,5},
			{5,6}
		};
		
		for(int i=0; i<graph.length; i++) {
			int a = graph[i][0];
			int b = graph[i][1];
			
			ad[a][b] = ad[b][a] = 1;
		}
		  
		bfs(1);
		
	}
}

package algorithm;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class A implements Comparable<A>{
	int from;
	int to;
	int weight;

	public A(int from, int to, int weight) {
		this.to = to;
		this.from = from; 
		this.weight = weight;
	}
	
	@Override
	public int compareTo(A o) {
		return this.weight >= o.weight ? 1 : -1;
	}

}


public class KruskalAlgorithm {
	
	//node의 부모노드를 찾는 메서드
	public static int findParent(int a) {
		
		if(a == parent[a]) return a;
		parent[a] = findParent(parent[a]);
		
		return parent[a];
	}
	
	public static void union(int a, int b) {
		
		int aRoot = findParent(a);  //a의 최상위 부모노드 탐색
		int bRoot = findParent(b);  //b의 최상위 부모노드 탐색
		
		//a와 b의 최상위 노드가 다른 경우 aRoot의 최상위 노드를 b로 지정
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		} 
		
		//부모가 같은 경우
		else {
			return;
		}
	}
	
	static int N; //node
	static int E; //arc
	static PriorityQueue<A> pq; //간선 값을 Min Heap으로 하는 우선순위 큐
	static int[] parent;  //disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
	static int result;  //결과값 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = 9;
		E = 14;
		
		parent = new int[N]; //Disjoint-set
		result = 0;
		
		pq = new PriorityQueue<A>();
		
		int[][] graph = new int[][] {
			{0,1,3},
			{0,7,8},
			{1,2,8},
			{1,7,11},
			{2,3,7},
			{2,5,4},
			{2,8,2},
			{3,4,9},
			{3,5,14},
			{4,5,10},
			{5,6,2},
			{6,7,1},
			{6,8,6},
			{7,8,7}
		};
		
		
		//모든 arc에 대하여 [to, from, cost]를 가진 클래스로 우선순위 큐에 add
		for(int i=0; i<graph.length; i++) {
			pq.add(new A(graph[i][0], graph[i][1], graph[i][2]));
		}
		
		//자기 자신을 최상위 node로 초기화
		for(int i=0; i<N; i++) { 
			parent[i] = i;
		
		}	
		
		for(int i=0; i<E; i++) {
			
			A minNode = pq.poll();  //현재 큐에 있는 모든 인스턴스 중 weight가 가장 적은 간선이 뽑힘.
		
			System.out.println(minNode.from + " " + minNode.to + " " + minNode.weight);
			
			int from = minNode.from;
			int to = minNode.to;
			
			int a = findParent(from);
			int b = findParent(to);
			
			//a와 b의 root node가 같을 경우 continue
			if(a == b) continue;
		
			//a와  b의 root node가 다를 경우 from을 to의 최상위 node로 설정
			union(from, to); 
			result += minNode.weight;
		}
		
		System.out.println(result);
	}
}



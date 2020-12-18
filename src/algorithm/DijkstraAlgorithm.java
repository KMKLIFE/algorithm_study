package algorithm;
import java.util.*;

/* 다익스트라 알고리즘 
 * 1.출발 노드 설정
 * 2.출발 노드를 기준으로 각 노드의 최소 비용 저장
 * 3.방문하지 않는 노드 중에서 최소 비용의 노드 선택
 * 4.해당 노드를 거쳐 특정 노드로 가는 경우를 고려해 최소 비용을 갱신
 * 3 ~ 4번 반복
 */

class Element implements Comparable<Element> {
	
	//각 Node의 번호와 거리에 관한 변수
	private int index;
	private int distance;

	public Element(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}
	
	//거리를 기준으로 우선순위로 정렬
	public int compareTo(Element e) {
		return this.distance >= e.distance ? 1 : -1;
	}

}

public class DijkstraAlgorithm {

	static boolean[] visit;
	static int[] dist;
	static int[][] ad;
	static int nE, nV;
	static final int INF = 100000;

	public static void ssp(int start) {
		PriorityQueue<Element> q = new <Element>PriorityQueue();
		dist[start] = 0;
		q.offer(new Element(start, dist[start]));

		while (!q.isEmpty()) {
			int cost = q.peek().getDistance();
			int here = q.peek().getIndex();
			q.poll();

			if (cost > dist[here])
				continue;
			
			//방문한 노드 순서 출력
			System.out.print(here + " -> ");

			for (int i = 1; i <= nV; i++) {
				
				//인접행렬의 값이 0이 아니고(here에서 i번째 노드로 갈 수 있음을 의미) here노드에서 i노드로 가는 비용이 기존의 i노드의 비용보다 작을경우 
				if (ad[here][i] != 0 && dist[i] > dist[here] + ad[here][i]) {
					dist[i] = dist[here] + ad[here][i];
					q.offer(new Element(i, dist[i]));
				}
			}

		}
		System.out.println();
		
		for (int i = 1; i <= nV; i++) {
			System.out.println("1 to  " + i + " : " + dist[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		nV = scan.nextInt();
		nE = scan.nextInt();

		dist = new int[nV + 1];
		ad = new int[nV + 1][nV + 1];

		for (int i = 0; i <= nV; i++) {
			dist[i] = INF;
		}

		for (int i = 0; i < nE; i++) {
			int t1 = 0;
			int t2 = 0;
			int t3 = 0;

			t1 = scan.nextInt();
			t2 = scan.nextInt();
			t3 = scan.nextInt();

			ad[t2][t1] = ad[t1][t2] = t3;
		}

		ssp(1);

	}

}

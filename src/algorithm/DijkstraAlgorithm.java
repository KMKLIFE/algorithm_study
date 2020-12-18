package algorithm;
import java.util.*;

/* ���ͽ�Ʈ�� �˰��� 
 * 1.��� ��� ����
 * 2.��� ��带 �������� �� ����� �ּ� ��� ����
 * 3.�湮���� �ʴ� ��� �߿��� �ּ� ����� ��� ����
 * 4.�ش� ��带 ���� Ư�� ���� ���� ��츦 ����� �ּ� ����� ����
 * 3 ~ 4�� �ݺ�
 */

class Element implements Comparable<Element> {
	
	//�� Node�� ��ȣ�� �Ÿ��� ���� ����
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
	
	//�Ÿ��� �������� �켱������ ����
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
			
			//�湮�� ��� ���� ���
			System.out.print(here + " -> ");

			for (int i = 1; i <= nV; i++) {
				
				//��������� ���� 0�� �ƴϰ�(here���� i��° ���� �� �� ������ �ǹ�) here��忡�� i���� ���� ����� ������ i����� ��뺸�� ������� 
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

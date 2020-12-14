package 프로그래머스;

/*
  array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */
import java.util.*;

class Solution2 {
	public int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int[] answer = new int[commands.length];
		int j=0;
		for (int[] arr : commands) {
			int[] numArr;
			numArr = Arrays.copyOfRange(array, arr[0] - 1, arr[1]);
			for (int i = 0; i < numArr.length; i++) {
				arrList.add(numArr[i]);
			}
			Collections.sort(arrList);
			answer[j] = arrList.get(arr[2]-1);
			arrList.removeAll(arrList);
			j++;
		}
		for(int num : answer) {
			System.out.print(num + " ");
		}

		return answer;
	}

}


public class NumberK {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		sol.solution(array, commands);
	}

}

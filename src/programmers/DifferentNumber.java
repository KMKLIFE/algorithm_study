package 프로그래머스;

import java.util.*;

class Solution {
	public int[] solution(int[] arr) {
		ArrayList<Integer> arrList = new ArrayList<>();
		int preNum = 10;
		for(int num : arr) {
			if(preNum != num) {
				arrList.add(num);
			}
			preNum = num;
		}
	
		int[] answer = new int[arrList.size()];
		for(int i=0; i<arrList.size(); i++) {
			answer[i] = arrList.get(i);
		}
		return answer;

	}
}  

public class DifferentNumber {

	public static void main(String[] args) {
		int[] numArr = new int[] { 5,1,1,2,2,3,0,0,0,1};
		Solution sol = new Solution();
		sol.solution(numArr);

	}

}

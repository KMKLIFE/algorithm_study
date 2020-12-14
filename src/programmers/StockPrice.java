package 프로그래머스;
import java.util.*;
public class StockPrice {

	public static void main(String[] args) {
		int[] prices = new int[] {5,3,3,3,1};
        int[] answer = new int[prices.length];
        List<Integer> list2 = new ArrayList<>();
        for(int i=0; i<prices.length; i++)
            list2.add(prices[i]);
        int start = 0;
        while(start < prices.length){
            List<Integer> list = new ArrayList<>();
            int maintain = 0;
            for(int i=0; i<list2.size(); i++){
                if(i == 0){
                    list.add(list2.get(i));
                    maintain++;
                    continue;
                }
                if(list.get(0) <= list2.get(i)){
                    list.add(list2.get(i));
                    maintain++;
                } else if(list.get(0) > list2.get(i)){
                    answer[start] = maintain;
                    list2.remove(0);
                    break;
                }
            }
            if(maintain == list2.size()){
                answer[start] = maintain - 1;
                list2.remove(0);
            }
            start++;
        }
        System.out.println(Arrays.toString(answer));
	}

}

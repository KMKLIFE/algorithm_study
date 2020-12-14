package 프로그래머스;
import java.util.*;
public class TradingCost {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
        List<Integer> answerList = new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();
        int cnt = 0;
        int s = 0;
        
        for(int num : prices) {
            priceList.add(num);
            System.out.print(num + " ");
        }
        System.out.println();
        
        while(priceList.size() > 0){
            if(priceList.size() > 1){
                for(int i=1; i<priceList.size(); i++){
                if(priceList.get(0) <= priceList.get(i)){
                    cnt++;
                    System.out.println(cnt);
                    if(cnt == priceList.size()-1){
                        answerList.add(cnt);
                        priceList.remove(0);
                        cnt = 0;
                        break;
                    }
                }
                else{
                    cnt++;
                    answerList.add(cnt);
                    priceList.remove(0);
                    cnt = 0;
                    break;
                }
              }
            }
            else{
                answerList.add(0);
                priceList.remove(0);
            }       
        }
        for(int num : answerList){
            System.out.print(num + " ");
        }
        
        
	}

}

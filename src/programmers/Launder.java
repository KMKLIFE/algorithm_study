package 프로그래머스;

import java.util.*;
public class Launder {

	public static void main(String[] args) {
        int answer = 0;
        int typeNum = 0;
        HashMap<String,Integer> map = new HashMap<>();
        String[][] clothes = {{"yellow_hat","headgear"}, {"blue_sunglasses","eyewear"}, {"green_turban","headgear"}, {"white_hat","headgear"}, {"white_sunglasses","eyewear"}
        						,{"blue_jean","bottom"},{"white_jean","bottom"}};
        
        for(int i=0; i<clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];

            if(!map.containsKey(type)){
                typeNum++;
                map.put(type, 0);
            }
            map.put(type, map.get(type)+1);
        }

        // 종류별 옷의 개수를 배열로 저장
        int[] size = new int[typeNum]; int j=0;
        for(String str : map.keySet()){
            size[j++] = map.get(str);
        }
        
        // 비트 배열을 이용하여 총 가지 수 구함
        for(int i=1; i<Math.pow(2,typeNum); i++){
            int num = i; int idx = 0;
            int a = 1;  // 현재 비트의 가지 수             
            while(num>1){
                if(num%2 == 1){
                    a = a*size[idx];
                }
                idx++;
                num = num/2;
            }
            if(num==1)
                a = a*size[idx];
            answer += a;
        }
        
        System.out.println(answer);
	}

}

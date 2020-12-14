package 프로그래머스;
import java.util.*;

class Truck {
    int weight;
    int entry;
    
    Truck(int weight, int entry){
        this.weight = weight;
        this.entry = entry;
    }
}

public class Bridge {
	
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10; 
		
		int[] truck_weights = new int[] {7,4,5,6};
		Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++) {
        	waiting.offer(new Truck(truck_weights[i], 0));
        }
        
        int time = 0;
        int totalWeight = 0;
        
        while(!waiting.isEmpty() || !bridge.isEmpty()){   
        	time++;
        	if(!bridge.isEmpty()) {
        		Truck t = bridge.peek();
        		if(time - t.entry >= bridge_length) {
        			totalWeight -= t.weight;
        			bridge.poll();
        		}
        	}
        	
        	if(!waiting.isEmpty()) {
        		if(totalWeight + waiting.peek().weight < weight) {
        			Truck truck = waiting.poll();
        			totalWeight += truck.weight;
        			bridge.offer(new Truck(truck.weight, time));
        		}
        	}
        }
        System.out.println(time);
        
	}

}

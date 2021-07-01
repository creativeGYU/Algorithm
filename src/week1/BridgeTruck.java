package week1;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
	class truck {
		int weight;
		int move;
		
		public truck(int weight) {
			this.weight = weight;
			this.move = 1;
		}
		
		public void moving() {
			move++;
		}
	}
	
	int weight;
	
	public int solution(int bridge_length, int weights, int[] truck_weights) {
		Queue<truck> waitQ = new LinkedList<>();
		Queue<truck> moveQ = new LinkedList<>();
		
		for (int t : truck_weights) {
			waitQ.offer(new truck(t));
		}
		
		int answer = 0;
		int cur_weight = 0;
		
		while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
			answer++;
			
			if (moveQ.isEmpty()) {
				truck t = waitQ.poll();
				cur_weight += t.weight;
				moveQ.offer(t);
				continue;
			}
			
			for (truck t : moveQ) {
				t.moving();
			}
			
			if (moveQ.peek().move > bridge_length) {
				truck t = moveQ.poll();
				cur_weight -= t.weight;
			}
			
			if (!waitQ.isEmpty() && cur_weight + waitQ.peek().weight <= weight) {
				truck t = waitQ.poll();
				cur_weight += t.weight;
				moveQ.offer(t);
			}
		}
		
		return answer;
	}
}

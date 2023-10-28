package ls_10_23.ls_28_10_23;

import java.util.PriorityQueue;
import java.util.Queue;

public class LearnQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(1);
        queue.add(7);
        queue.add(6);
        queue.add(3);

        System.out.println(queue);
    }
}

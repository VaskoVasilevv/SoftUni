package StacksAndQueues;

import java.util.Comparator;


public class PriorityQueueImplementation {
    public static void main(String[] args) {

        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>(Comparator.reverseOrder());



        priorityQueue.offer(42);
        priorityQueue.offer(13);
        priorityQueue.offer(73);
        priorityQueue.offer(69);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}

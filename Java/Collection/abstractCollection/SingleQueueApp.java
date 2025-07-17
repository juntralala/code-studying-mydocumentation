package abstractCollection;

import java.util.Queue;

public class SingleQueueApp {
    public static void main(String[] args) {
        Queue<String> queue = new SingleQueue<>();
        System.out.println(queue.size());

        System.out.println(queue.offer("Ujun"));
        System.out.println(queue.offer("Muhammad"));
        System.out.println(queue.offer("Junaidi"));

        System.out.println(queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
    }
}

package queue;

/**
* deque singkatan dari double ended Queue, artinya Queue yang bisa beroperasi dari depan atau belakang
* jika pada queue, operasi yang didukung hanya FIFO, namun pada Deque, tidak hanya FIFO, tapi juga mendukung LIFO(Last In Fist Out)
* bisa dibilang Deque adalah implementqsi struktur data Queue dan stack
*/

/** METHOD tambahan Deque
 * addFirst(E) : void
 * addLast(E) : void
 * offerFirst(E) : boolean
 * offerLast(E) : boolean
 * removeFirst() : E
 * removeLast() : E
 * pollFirst() : E
 * pollLast() : E
 * getFirst() : E
 * getLast() : E
 * peekFirst() : E
 * peekLast() : E
 * removeFirstOccurrence(Object) : boolean
 * removeLastOccurrence(Object) : boolean
 * push(E) : void
 * pop() : E
 * descendingIterator() : Iterator<E>
 */

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {
        Deque<String> names = new LinkedList<>();
        names.offer("ujun");
        names.offer("arif");
        names.offer("juli");
        names.offer("rija");
        
        for (String name = names.pollLast() ; name != null ; name = names.pollLast()) {
            System.out.println(name);
        }
        
        System.out.println(names.size());
    }
}
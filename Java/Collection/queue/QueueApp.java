package queue;

/**
* Queue adalah implementasi dari struktur data antrian atau FIFO (First In First Out)
*/

/**  METHOD Queue interface
 * add(E) : boolean        // tambah data
 * offer(E) : boolean
 * remove() : E            // mengambil dan menghapus
 * poll() : E
 * elemen() : E            // mengambil tanpa menghapus
 * peek() : E
*/

/** ArrayDequeue vs LinkedDequeue vs PriorityQueue
 * ArrayDeque menggunakan array sebagai implementasi Queue nya
 * LinkedList menggunakan double linked list sebagai implementasi Queue nya
 * PriorityQueue menggunakan array sebagai implementasi Queue nya, namun di urutkan menggunakan Comparable atau Comparator
*/

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class QueueApp {
    public static void main(String[] args) {
        Queue<String> names = new ArrayDeque(10);
        names.offer("ujun");
        names.offer("arif");
        names.offer("juli");
        names.offer("rija");
        
        for (String name = names.poll() ; name != null ; name = names.poll()) {
            System.out.println(name);
        }
        
        System.out.println(names.size());
    }
}
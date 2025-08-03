# ConcurrentMap
* ConcurrentMap merupakan turunan dari Map yang thread safe, dan cocok jika memang diakses oleh lebih dari satu thread
* Tidak ada hal yang spesial dari ConcurrentMap, semua operasi method nya sama seperti Map, yang membedakan adalah pada ConcurrentMap, dijamin thread safe
* Implementasi dari interface ConcurrentMap adalah class ConcurrentHashMap
* https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ConcurrentMap.html

> Implementasi ConcurrentMap Adalah ConcurrentHashMap
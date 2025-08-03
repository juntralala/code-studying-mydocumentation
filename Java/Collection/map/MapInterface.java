/**
* Map adalah struktur data collections yang berisikan mapping key dan value
* dimana key di map itu harus unik, tidak  boleh duplikat, dan satu key hanya boleh mapping ke satu key
* Map mirip seperti Array, cuman beda nya di Array, Key adalah index(Integer), sedangkan di Map bebas kita tentukan sesuai dengan keinginan kita 
*/

/** method-method Map
* size() : int
* isEmty() : boolean
* containsKey() : boolean
* containsValue() : boolean
* get(Object) : V
* put(K, V) : V
* remove(Object) : V
* putAll(Map<? extends K, ? extends V>) : void
* clear() : void
* keySet() : Set<K>
* values() : Colleaction<V>
* entrySet() : Set<Entry<E, V>>
* getOrDefault(Object, V) : V
* foEach(BiConsumer<? super K, ? super V>>) : void
* replaceAll(BiFunction<? super K, ? super V, ? extends V>) : void
* putIfAbsent(K, V) : boolean
* remove(Object, Object) : boolean
* replace(K, V, V) : boolean
* replace(K, V) : V
* computeIfAbsent(K, Function<? super K, ? extends V>) : V
* computeIfPresent(K, BiFunction<? super K, ? super V, ? extends V> ) : V
* compute(K, BiFunction<? super K, ? super V, ? extends V>) : V
* merge(K, V, BiFunction<? super K, ? super V, ? extends V>) : V
*/
package DataStructure.QualysCompany;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ImplementYourOwnHashMap {
    public static void main(String[] args) {
        CustomHashMap<Integer , Integer> map = new CustomHashMap<>();
        System.out.println("Checking if hashmap is empty = " + map.isEmpty());
        map.put(1,1);
        map.put(2,2);

        System.out.println("Map.get(1) - " + map.get(1));
        System.out.println("Map.get(2) - " + map.get(2));

        map.put(1,5);
        System.out.println("Map.get(1) - " + map.get(1));
        System.out.println("Map contains key(2) - " + map.containsKey(2));
        System.out.println("Map contains key(1) - " + map.containsKey(1));
        System.out.println("Map contains key(4) - " + map.containsKey(4));

        System.out.println("Total hashmap size = " + map.size());
        System.out.println("Checking if hashmap is empty = " + map.isEmpty());

        System.out.println("Map contains value(2) - " + map.containsValue(2));
        System.out.println("Map contains value(5) - " + map.containsValue(5));
        System.out.println("Map contains value(1) - " + map.containsValue(1));

        System.out.println("Map remove key (2) - " + map.remove(2));
        System.out.println("Map remove key (1) - " + map.remove(1));
        System.out.println("Map remove key (5) - " + map.remove(5));

        System.out.println("Updated hashmap size = " + map.size());

        CustomHashMap<String , String> sMap = new CustomHashMap<>();
        sMap.put("Abhilash" , "Abhilash");
        sMap.put("Apurva" , "Apurva");
        System.out.println("Retrieving value for Apurva = " + sMap.get("Apurva"));
        System.out.println("Size = " + sMap.size());

    }
}

class CustomHashMap<K,V> implements Map<K,V>{

    Entry<K,V>[] entry = null;
    int modCount = 0;
    int size = 0;

    public CustomHashMap() {
        entry = new Entry[16];
    }

    public CustomHashMap(int capacity){
        if(capacity <= 0)
            throw new IllegalArgumentException("Specify a higher value ...");
        entry = new Entry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry node = getNode(key);
        return node!= null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0 ; i< entry.length;i++){
            Entry<K,V> node = entry[i];

            while (node != null){
                    if(node.value == value || node.value.equals(value))
                        return true;
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Entry node = getNode(key);
        return node == null ? null : (V)node.getValue();
    }

    public Entry<K,V> getNode(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode % entry.length;
        Entry<K,V> node = entry[index];
        while (node != null){
            if(node.hash == hashCode){
                if(node.key == key || node.key.equals(key))
                    return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % entry.length;
        Entry<K,V> node = entry[index] , prevNode = entry[index];

        if(node == null){
            entry[index] = new Entry<>(key , hashCode , value , null);
        }
        else {
            while (node != null) {
                if (node.hash == hashCode) {
                    if (node.key == key || node.key.equals(key)) {
                        V oldValue = node.getValue();
                        node.setValue(value);
                        return oldValue;
                    }
                }
                prevNode = node;
                node = node.next;
            }
            prevNode.next = new Entry(key , hashCode , value , null);
        }
        size++;
        modCount++;
        return null;
    }

    @Override
    public V remove(Object key) {
        int hashCode = key.hashCode();
        int index = hashCode%entry.length;

        Entry<K,V> node = entry[index] , prevNode = entry[index];
        while (node != null){
            if(node.hash == hashCode && (node.getKey() == key || node.getKey().equals(key))){
                modCount++;
                size --;
                if(node.equals(entry[index]))
                {
                    entry[index] = node.next;
                } else {
                    prevNode.next = node.next;
                }
                return node.getValue();
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        modCount++;
        for(int i=0 ; i<entry.length ; i++)
            entry[i] = null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }


    static class Entry<K,V> implements Map.Entry<K,V>{
        K key;
        int hash;
        V value;
        Entry next;

        public Entry(K key , int hash , V value , Entry next) {
            this.next = next;
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        public final boolean equals(Object o){
            System.out.println("Checking for equality");
            if(o == this)
                return true;

            if(o instanceof Map.Entry){
                Map.Entry<? , ?> map = (Map.Entry) o;
                if(Objects.equals(key , map.getKey()) && Objects.equals(value , map.getValue()))
                    return true;
            }
            return false;
        }


        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}

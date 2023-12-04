package com.sunandan.Map;

// TODO: Make the keys to accept other types. Same for the values.
// TODO: Propetries of a good hash function


class MyHashMap{

	private int DEFAULT_BUCKET_COUNT_CAPACITY = 16;
	private Node[] buckets;

	public MyHashMap(){
		buckets = new Node[DEFAULT_BUCKET_COUNT_CAPACITY];
	}

	public MyHashMap(int capacity){
		buckets = new Node[capacity];
	}


	public Object get(Object key){
		int bucketIndex = hashCode(key);
		Node n = buckets[bucketIndex];
		while(n!=null){
			if(n.getKey().equals(key))
				return n.getValue();
			n = n.getNext();
		}
		return null;
	}

	public void put(Object key, Object value){
		int bucketIndex = hashCode(key);
		Node n = buckets[bucketIndex];
		if(n != null){
			boolean insertionCheck = false;
			while(!insertionCheck){
				if(key.equals(n.getKey())){
					n.setValue(value);
					insertionCheck = true;
				}
				else if(n.getNext() == null){
					n.setNext(new Node(key,value));
					insertionCheck = true;
				}
				n = n.getNext();
			}

		}
		else{
			buckets[bucketIndex] = new Node(key,value);
		}


	}

	private int hashCode(Object key){
		return (3^(key.hashCode()))%16;
	}

}

class Node<K,V>{


	private final K key;
	private V value;
	private Node<K,V> next;


	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}


}
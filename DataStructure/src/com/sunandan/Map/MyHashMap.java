


class MyHashMap{

	private int DEFAULT_BUCKET_COUNT = 16;
	private Node[] buckets;

	public MyHashMap(){
		buckets = new Node[DEFAULT_BUCKET_COUNT];
	}

	public MyHashMap(int capacity){
		buckets = new Node[capacity];
	}


	public String get(String key){
		int bucketIndex = hashCode(key);
		Node n = buckets[bucketIndex];
		while(n!=null){
			if(n.getKey().equals(key))
				return n.getValue();
			n = n.getNext();
		}
		return null;
	}

	public void put(String key, String value){
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

	private int hashCode(String key){
		return ((int)key.charAt(0))%buckets.length;
	}

}

class Node{

	private final String key;
	private String value;
	private Node next;


	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}


}
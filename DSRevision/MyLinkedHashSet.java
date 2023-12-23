import java.util.Iterator;
import java.util.LinkedHashMap;

public class MyLinkedHashSet<E> {

    private transient LinkedHashMap<E, Object> map;

    private static final Object DUMMY = new Object();

    public MyLinkedHashSet() {
        map = new LinkedHashMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }


    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    
    public boolean add(E e) {
        return map.put(e, DUMMY) == null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == DUMMY;
    }

    public void clear() {
        map.clear();
    }
}

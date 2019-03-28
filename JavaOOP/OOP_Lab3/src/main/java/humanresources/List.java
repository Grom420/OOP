package humanresources;

import java.lang.reflect.Array;
import java.util.Iterator;

class List<T> implements Iterable<T> {
    protected Node<T> head;
    protected Node<T> tail;
    private int size;


    public int getSize() {
        return size;
    }

    public void add(T t) {

    }

    public boolean remove (int index) {

    }
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) Array.newInstance(Object.class, size);
        //todo дальши цикл
    }

    @Override
    public Iterator<T> iterator() {
        return null; //todo надо будет имплементить
    }
}

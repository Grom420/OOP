package humanresources;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

class List<T> implements Iterable<T> {
    protected Node<T> head;
    protected Node<T> tail;
    private int size;


    public int getSize() {
        return size;
    }


    public void add(T t) {
        Node<T> a = new Node<>();
        a.value = t;
        if (tail == null)
        {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    public int employeesQuantity(JobTitilesEnum jobTitle) {
        int employeesQuantity = 0;
        Departament departament = new Departament();
        for (int i = 0; i < size; i++) {
            employeesQuantity += departament.employeesQuantity(jobTitle);
        }

        return employeesQuantity;
    }

    @SuppressWarnings("unchecked")
    T[] toArray() {
        T[] result = (T[]) Array.newInstance(Object.class, size);//todo дальши цикл(Done)
        Node<T> a = head;
        for (int i = 0; i < size; i++) {
            result[i] = a.value;
            a = a.next;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator () {
        return new Iterator<T>() {
            Node<T> t = head;

            @Override
            public boolean hasNext() {
                return t.next != null;
            }

            @Override
            public T next() {
                if(hasNext()) {
                    t = t.next;
                    return head.value;
                }
                throw new NoSuchElementException("No element");
            }
        };
    }
}

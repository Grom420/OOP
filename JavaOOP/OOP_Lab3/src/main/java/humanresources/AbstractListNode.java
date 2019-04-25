package humanresources;

import java.util.*;

public class AbstractListNode<T> implements List<T> {

    protected int size;
    protected Node<T> head;
    protected Node<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> currentNode = head;
        while (currentNode.next != null){
            if(currentNode.value.equals(o))
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
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

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] array = (T[]) new Object[size];
        int j = 0;
        for(T object : this){
            if(object != null)
                array[j++] = object;
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            return (T1[]) Arrays.copyOf(toArray(), size -1, a.getClass());
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        add(size, t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (head.value.equals(o))  {
            head = head.next;
            this.size--;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value.equals(o)) {
                if (tail.value.equals(currentNode.next.value)) {
                    tail = currentNode;
                }
                currentNode.next = currentNode.next.next;
                this.size--;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() > size()) {
            try {
                throw new AlreadyAddedException("Error");
            } catch (AlreadyAddedException e) {
                e.printStackTrace();
            }
        }
        Node<T> currentNode = head;
        for (T t : c) {
            currentNode.value = t;
            currentNode = currentNode.next;
            this.size++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Node<T> currentNode = head;
        int indexNode = 0;
        for(T e : c){
            if(c.contains(e))
                try {
                    throw new AlreadyAddedException("Error");
                } catch (AlreadyAddedException e1) {
                    e1.printStackTrace();
                }
            if(indexNode >= index){
                currentNode.value = e;
                currentNode = currentNode.next;
                this.size++;
            }
            indexNode++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Node<T> currentNode = head;
        for(Object o : c){
            if(currentNode.value.equals(o))
                remove(o);
            if(currentNode.next != null)
                currentNode = currentNode.next;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Node<T> currentNode = head;
        for(Object o : c){
            if(!currentNode.value.equals(o))
                remove(o);
            if(currentNode.next != null)
                currentNode = currentNode.next;
        }
        return true;
    }

    @Override
    public void clear() {
        this.forEach(this::remove);
    }

    @Override
    public T get(int index) {
        int i = 0;
        return this.stream().filter(employee -> i == index).findFirst().orElse(null);
    }

    @Override
    public T set(int index, T element) {
        int countObject = 0;
        for(T t : this){
            if(countObject == index){
                t = element;
                return t;
            }
            countObject++;
        }
        return null;
    }

    @Override
    public void add(int index, T element) {
        for(T t : this){
            if(t.equals(element))
                try {
                    throw new AlreadyAddedException("This group already exists.");
                } catch (AlreadyAddedException e) {
                    e.printStackTrace();
                }
        }
        Node<T> addedObject = new Node<>();
        Node<T> currentNode = head;
        addedObject.value = element;
        int count = 0;
        while (currentNode.next != null){
            if(count == index){
                currentNode.next = addedObject;
                currentNode = addedObject;
            }
            currentNode = currentNode.next;
            count++;
        }
    }

    @Override
    public T remove(int index) {
        Node<T> currentNode = head;
        T deleteElement = null;
        int countEmployee = 0;
        while (currentNode.next != null) {
            if (countEmployee == index) {
                if (tail.value.equals(currentNode.next.value)) {
                    tail = currentNode;
                }
                deleteElement = currentNode.value;
                currentNode.next = currentNode.next.next;
                this.size--;
            }
            currentNode = currentNode.next;
            countEmployee++;
        }
        return deleteElement;
    }


    @Override
    public int indexOf(Object o) {
        int indexElement = 0;
        for(T t : this){
            if(Objects.nonNull(t))
                if(t.equals(o))
                    return indexElement;
            indexElement++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int indexElement = size;
        for(T t : this){
            if(Objects.nonNull(t))
                if(t.equals(o))
                    return indexElement;
            indexElement--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            Node<T> currentNode = head;
            int currentIndex = index;
            T lastReturned = null;

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public T next() {
                if(hasNext()) {
                    //todo lastreturned
                    currentNode = currentNode.next;
                    return currentNode.value;
                }
                throw new NoSuchElementException("No element");
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                if (hasNext())
                    return currentIndex + 1;
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                if (hasPrevious())
                    return currentIndex - 1;
                return currentIndex;
            }

            @Override
            public void remove() {
                if (lastReturned == null)
                    throw new IllegalStateException("You can't remove item");
                lastReturned = null;
                AbstractListNode.this.remove(currentIndex);
            }

            @Override
            public void set(T element) {
                if (lastReturned == null)
                    throw new IllegalStateException("You can't set the value for item");
                AbstractListNode.this.set(currentIndex, element);
            }

            @Override
            public void add(T element) {
                lastReturned = null;
                AbstractListNode.this.add(currentIndex, element);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new AbstractListNode<>();
        Node<T> currentNode = head;
        for (int i = 0; i < fromIndex; i++) {
            currentNode = currentNode.next;
        }
        while (fromIndex <= toIndex){
            subList.add(currentNode.value);
            currentNode = currentNode.next;
            fromIndex++;
        }
        return subList;
    }
}

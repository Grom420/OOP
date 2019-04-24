package humanresources;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class AbstractListArray<T> implements List<T> {

    private T[] abstractArray;
    private int size;

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
        return Arrays.stream(abstractArray).filter(Objects::nonNull).anyMatch(order -> order.equals(o));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if(hasNext()) {
                    return abstractArray[currentIndex++];
                }
                throw new NoSuchElementException("No element");
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] newArray = (T[]) new Object[size];
        int j = 0;
        for (T element : this.abstractArray) {
            if (element != null)
                newArray[j++] = element;
        }
        return newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <t> t[] toArray(t[] a) {
        if (a.length < abstractArray.length)
            return (t[]) Arrays.copyOf(abstractArray, abstractArray.length - 1, a.getClass());
        System.arraycopy(abstractArray, 0, a, 0, abstractArray.length);
        if (a.length > abstractArray.length)
            a[abstractArray.length - 1] = null;
        return a;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(T t) {
        checkArray(t);
        this.abstractArray[this.size] = t;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < abstractArray.length; i++) {
            if (Objects.nonNull(abstractArray[i]) && abstractArray[i].equals(o)) {
                abstractArray[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @SuppressWarnings("unchecked")
    private void expendSize(Collection<? extends T> c){
        if(c.size() + this.size > abstractArray.length){
            T[] newEmployees = (T[]) new Object[abstractArray.length];
            System.arraycopy(abstractArray, 0, newEmployees, 0, size);
            this.abstractArray = newEmployees;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        expendSize(c);
        return addAll(0, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        expendSize(c);
        for(T element : c){
            if(c.contains(element))
                try {
                    throw new AlreadyAddedException("Error");
                } catch (AlreadyAddedException e1) {
                    e1.printStackTrace();
                }
            abstractArray[index++] = element;
        }
        return true;
    }

    private <t> int removeAll(BiPredicate<t, T> biPredicate, t obj) {
        int removedElementCount = 0;
        for (int i = 0; i < abstractArray.length; i++) {
            if (biPredicate.test(obj, abstractArray[i])) {
                remove(i);
                removedElementCount++;
            }
        }
        if (removedElementCount > 0) return removedElementCount;
        return -1;
    }

    private BiPredicate<Collection<?>, T> containsInCollection = Collection::contains;
    private BiPredicate<Collection<?>, T> notContainsInCollection = (c, o) -> !c.contains(o);

    @Override
    public boolean removeAll(Collection<?> c) {
        return removeAll(containsInCollection, c) > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return removeAll(notContainsInCollection, c) > 0;
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
        for (int i = 0; i < size; i++) {
            if(i == index) {
                abstractArray[i] = element;
                return abstractArray[i];
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void checkArray(T element){
        for(T employee : this){
            if(employee.equals(element))
                try {
                    throw new AlreadyAddedException("This employee is already exists.");
                } catch (AlreadyAddedException e) {
                    e.printStackTrace();
                }
        }
        if (size == abstractArray.length) {
            T[] newArray;
            newArray = (T[]) new Object[this.abstractArray.length * 2];
            System.arraycopy(this.abstractArray, 0, newArray, 0, this.abstractArray.length);
            this.abstractArray = newArray;
        }
    }

    @Override
    public void add(int index, T element) {
        checkArray(element);
        shift(index);
        this.abstractArray[index] = element;
        this.size++;
    }

    @Override
    public T remove(int index) {
        for (int i = 0; i < size; i++) {
            if(i == index) {
                T removedEmployee = abstractArray[i];
                abstractArray[i] = null;
                this.size--;
                return removedEmployee;
            }
        }
        return null;
    }

    private void shift(int i) {

        System.arraycopy(this.abstractArray, i + 1, this.abstractArray, i, size - i);
    }

    @Override
    public int indexOf(Object o) {
        return IntStream.range(0, abstractArray.length)
                .filter(i -> Objects.nonNull(abstractArray[i]))
                .filter(i -> abstractArray[i].equals(o))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = abstractArray.length; i >= 0; i--) {
            if (Objects.nonNull(abstractArray[i]))
                if (abstractArray[i].equals(o))
                    return i;
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
            int currentIndex = index;
            T lastReturned = null;

            @Override
            public boolean hasNext() {
                return currentIndex < abstractArray.length;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    lastReturned = abstractArray[currentIndex++];
                    return lastReturned;
                }
                throw new NoSuchElementException("There's no such element");
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (hasPrevious()) {
                    lastReturned = abstractArray[currentIndex--];
                    return lastReturned;
                }
                throw new NoSuchElementException("There's no such element");
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
                AbstractListArray.this.remove(currentIndex);
            }

            @Override
            public void set(T element) {
                if (lastReturned == null)
                    throw new IllegalStateException("You can't set the value for item");
                AbstractListArray.this.set(currentIndex, element);
            }

            @Override
            public void add(T element) {
                lastReturned = null;
                AbstractListArray.this.add(currentIndex, element);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new AbstractListArray<>();
        for (int i = fromIndex; i < toIndex; i++) {
            if (Objects.nonNull(abstractArray[i]))
                subList.add(abstractArray[i]);
        }
        return subList;
    }
}

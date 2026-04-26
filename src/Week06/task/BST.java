package Week06.task;

import java.util.Collection;
import java.util.Iterator;


public class BST<E> implements Comparable<E> {



    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean contains(Object o) {
        return false;
    }


    public Iterator<E> iterator() {
        return null;
    }


    public boolean add(E e) {
        return false;
    }


    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }


    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    public void clear() {

    }


    @Override
    public int compareTo(E o) {
      if(o instanceof Comparable<?>){
//          ((Comparable<?>) o).compareTo();
      }
        return 0;
    }
}

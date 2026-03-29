package Week02;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import Structures.Node;


public class MyDoublyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    //O(1)
    @Override
    public int size() {
        return size;
    }
    //O(1)
    @Override
    public boolean isEmpty() {
        return size == 0 || head == null;
    }

    //O(n)
    @Override
    public boolean contains(Object o) {

        Node<E> chain = head;
        while (chain != null) {
            if (o.equals(chain.getVal()))
                return true;
            chain = chain.getNext();
        }

        return false;
    }

    //O(1)
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null)
            head = tail = newNode;
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        return true;
    }

    //O(n)
    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;
        if (o.equals(head.getVal())) {
            head = head.getNext();
            if (head == null)
                tail = null;
            else
                head.setPrev(null);
            size--;
            return true;
        }
        Node<E> current = head;
        while (current != null && !o.equals(current.getVal())) {
            current = current.getNext();
        }
        if (current == null)
            return false;
        Node<E> next = current.getNext();
        Node<E> prev = current.getPrev();
        prev.setNext(next);

        if (tail == current) {
            tail = prev;
        }
        else {
            next.setPrev(prev);
        }

        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int count = 0;
        Iterator<E> iter = (Iterator<E>) c.iterator();
        while (iter.hasNext()) {
            E item = iter.next();
            count += add(item) ? 1 : 0;
        }
        return count != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        Iterator<E> iter = (Iterator<E>) c.iterator();
        int count = 0;
        while (iter.hasNext()) {
            E item = iter.next();
            count += remove(item) ? 1 : 0;
        }
        return count != 0;
    }

    @Override
    public void clear() {
        tail = head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (isEmpty() || index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Node<E> temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.getNext();
        }
        return temp.getVal();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == size) {
            add(element);
            return element;
        }
        if (index == size - 1) {
            E prevE = tail.getVal();
            tail.setVal(element);
            return prevE;
        }


        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();
        if (head == null)
            add(element);
        else if (size == index)
            add(element);
        else {
            Node<E> newNode = new Node<>(element);
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            Node<E> next = temp.getNext();
            newNode.setNext(next);
            temp.setNext(newNode);
            next.setPrev(newNode);
            newNode.setPrev(temp);
            size++;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    //----------------------------------------------------------------------------
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
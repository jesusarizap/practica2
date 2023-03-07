package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque(DequeNode<T> first, DequeNode<T> last) {
        // TODO
        this.first = first;
        this.last = last;
    }

    @Override
    public void prepend(T value) {
        // TODO
        // Creo un nuevo nodo como primer elemento
        DequeNode<T> newFirstNode = new DequeNode<>(value,null, this.first);
        // Referencio al nuevo nodo como el anterior del actual primer nodo
        this.first.setPrevious(newFirstNode);
        // Sustituyo el rimer elemento
        this.first = newFirstNode;
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}

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
        if (this.first==null){  // Si la lista esta vacia
            // Creo un nuevo nodo
            DequeNode<T> newNode = new DequeNode<>(value,null, null);
            // Asigno este nodo como primer y ultimo nodo de la lista
            this.first = newNode;
            this.last = newNode;

        } else {   //Si la lista contiene al menos un nodo
            // Creo un nuevo nodo como primer elemento
            DequeNode<T> newFirstNode = new DequeNode<>(value,null, this.first);
            // Referencio al nuevo nodo como el anterior del actual primer nodo
            this.first.setPrevious(newFirstNode);
            // Sustituyo el primer elemento
            this.first = newFirstNode;
        }
    }

    @Override
    public void append(T value) {
        // TODO
        if (this.first==null){  // Si la lista esta vacia
            // Creo un nuevo nodo
            DequeNode<T> newNode = new DequeNode<>(value,null, null);
            // Asigno este nodo como primer y ultimo nodo de la lista
            this.first = newNode;
            this.last = newNode;

        } else {   //Si la lista contiene al menos un nodo
            // Creo un nuevo nodo como ultimo elemento
            DequeNode<T> newLastNode = new DequeNode<>(value,this.last, null);
            // Referencio al nuevo nodo como el posterior del actual ultimo nodo
            this.last.setNext(newLastNode);
            // Sustituyo el ultimo elemento
            this.last = newLastNode;
        }
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (this.first==null){
            throw new DoubleEndedQueueException("Can not delete first element form an empty list");
        } else {
            this.first = this.first.getNext();
            this.first.setNext(null);
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if (this.last==null){
            throw new DoubleEndedQueueException("Can not delete last element form an empty list");
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
        }
    }

    @Override
    public T first() {
        // TODO
        if (this.first==null){
            throw new DoubleEndedQueueException("The list is empty");
        } else {
            return this.first.getItem();
        }
    }

    @Override
    public T last() {
        // TODO
        if (this.last==null){
            throw new DoubleEndedQueueException("The list is empty");
        } else {
            return this.last.getItem();
        }
    }

    @Override
    public int size() {
        // TODO
        if (this.first==null){
            return 0;
        } else {
            DequeNode<T> movingNode = this.first;
            int contador=1;
            while (movingNode.getNext()!=null){
                movingNode = movingNode.getNext();
                contador++;
            }
            return contador;
        }
    }
}

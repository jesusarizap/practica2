package org.mps.deque;

/**
 *
 * @author Nicolás Lerible
 * @author Jesús Ariza
 *
 */

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque(DequeNode<T> first, DequeNode<T> last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public void prepend(T value) {
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
        if (this.first==null){ // Si la lista esta vacia
            // Devuelve excepcion
            throw new DoubleEndedQueueException("Can not delete first element form an empty list");
        } else { // Si la lista contiene al menos un nodo
            // Asigna el siguiente nodo como primero
            this.first = this.first.getNext();
            // Asigno que este nodo ya no tiene antecesor
            this.first.setPrevious(null);
        }
    }

    @Override
    public void deleteLast() {
        if (this.last==null){ // Si la lista esta vacia
            // Devuelve excepcion
            throw new DoubleEndedQueueException("Can not delete last element form an empty list");
        } else { // Si contiene al menos un nodo
            // Asigno el anterior nodo como ultimo
            this.last = this.last.getPrevious();
            // Asigno que este nodo no tiene sucesor
            this.last.setNext(null);
        }
    }

    @Override
    public T first() {
        if (this.first==null){
            throw new DoubleEndedQueueException("The list is empty");
        } else {
            return this.first.getItem();
        }
    }

    @Override
    public T last() {
        if (this.last==null){
            throw new DoubleEndedQueueException("The list is empty");
        } else {
            return this.last.getItem();
        }
    }

    @Override
    public int size() {
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

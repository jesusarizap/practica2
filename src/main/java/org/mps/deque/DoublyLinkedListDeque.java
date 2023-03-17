package org.mps.deque;

import java.util.Comparator;

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
            int contador = 1;
            while (movingNode.getNext()!=null){
                movingNode = movingNode.getNext();
                contador++;
            }
            return contador;
        }
    }

    @Override
    public T get(int index) {
        if (this.first == null) { // if list is empty
            throw new DoubleEndedQueueException("The list is empty");
        }

        DequeNode<T> auxNode = this.first;

        if (index < 0 || index > this.size()-1) { // if index is out of bounds
            throw new DoubleEndedQueueException("The inserted index is out of the list");
        } else { // if index is within bounds
            for (int i = 0; i < index; i++) { // goes to the intended node
                auxNode = auxNode.getNext();
            }
        }

        return auxNode.getItem();
    }

    @Override
    public boolean contains(T value) {

        DequeNode<T> auxNode = this.first;

        while(auxNode!=null) { // while actual node is not null
            if (auxNode.getItem().equals(value)){ // if the value is the same
                return true;
            }
            auxNode = auxNode.getNext();

        } // otherwise

        return false;
    }

    @Override
    public void remove(T value) {

        DequeNode<T> auxNode = this.first;

        while(auxNode!=null) { // while actual node is not null
            if (auxNode.getItem().equals(value)){ // if the value is the same
                if (auxNode.isFirstNode() && auxNode.isLastNode()) {
                    this.first = null;
                    this.last = null;
                }else if (auxNode.isFirstNode()) {
                    this.first = this.first.getNext();
                    this.first.setPrevious(null);
                } else if (auxNode.isLastNode()){
                    this.last = this.last.getPrevious();
                    this.last.setNext(null);
                } else {
                    auxNode.getPrevious().setNext(auxNode.getNext());
                    auxNode.getNext().setPrevious(auxNode.getPrevious());
                }
                return;
            }
            auxNode = auxNode.getNext();
        }

    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        comparator.compare(this.first.getItem(),this.last.getItem());

        DequeNode<T> nodeOne = this.first;
        DequeNode<T> nodeTwo;
        T auxValue;

        if (size()<2){
            return;
        }

        while (nodeOne!=null) {
            nodeTwo = nodeOne.getNext();
            while (nodeTwo!=null){
                if (comparator.compare(nodeOne.getItem(),nodeTwo.getItem()) >= 0 ){
                    auxValue = nodeOne.getItem();
                    nodeOne.setItem(nodeTwo.getItem());
                    nodeTwo.setItem(auxValue);
                }
                nodeTwo = nodeTwo.getNext();
            }
            nodeOne = nodeOne.getNext();
        }

    }
}

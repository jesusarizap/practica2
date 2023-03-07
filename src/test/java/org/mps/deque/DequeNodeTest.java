package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

//Hay que hacer tests para los getters aun cuando estos ya quedan probados en tests como lo de item, next node y previous node?

public class DequeNodeTest {

    DequeNode nodo;

    @Nested
    @DisplayName("Test cases for the DequeNode implementation that checks if")
    class TestCasesThatCheckDequeNodeFunctions {

        @BeforeEach
        void setup()
        {
            nodo = new DequeNode(1, null, null);
        }

        @AfterEach
        void shutdown()
        {
            nodo = null;
        }

        @Nested
        @DisplayName("a created node stores properly its")
        class TestCasesThatCheckDequeNodeCreation
        {
            @Test
            @DisplayName("item")
            void checksIfItemIsStoredProperly(){
                int expectedItem = 1;

                DequeNode obtainedNode = new DequeNode(1, null, null);

                assertEquals(expectedItem, obtainedNode.getItem());
            }

            @Test
            @DisplayName("previous node")
            void checkfsIfPreviousNodeIsStoredProperly()
            {
                DequeNode expectedPreviousNode = null;

                DequeNode obtainedNode = new DequeNode(1, null, null);

                assertEquals(expectedPreviousNode, obtainedNode.getPrevious());
            }

            @Test
            @DisplayName("next node")
            void checkfsIfNextNodeIsStoredProperly()
            {
                DequeNode expectedNextNode = null;

                DequeNode obtainedNode = new DequeNode(1, null, null);

                assertEquals(expectedNextNode, obtainedNode.getNext());
            }
        }

        @Nested
        @DisplayName("a node can have properly changed with setters its")
        class TestCasesThatCheckDequeNodeSetters
        {
            @Test
            @DisplayName("item")
            void checksIfItemIsSetProperly()
            {
                nodo.setItem(2);

                int expectedItem = 2;

                assertEquals(expectedItem, nodo.getItem());
            }

            @Test
            @DisplayName("previous node")
            void checksIfPreviousNodeIsSetProperly()
            {
                DequeNode expectedPreviousNode = new DequeNode(1, null, null);

                nodo.setPrevious(expectedPreviousNode);

                assertEquals(expectedPreviousNode, nodo.getPrevious());
            }

            @Test
            @DisplayName("next node")
            void checksIfNextNodeIsSetProperly()
            {
                DequeNode expectedNextNode = new DequeNode(1, null, null);

                nodo.setNext(expectedNextNode);

                assertEquals(expectedNextNode, nodo.getNext());
            }
        }
    }
}

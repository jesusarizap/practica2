package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nicolás Lerible
 * @author Jesús Ariza
 *
 * Casos de prueba para DequeNode
 *
 *   1. Test cases for the DequeNode implementation that checks if
 *       1.1. a created node stores properly its
 *           1.1.1. item
 *           1.1.2. previous node
 *           1.1.3. next node
 *       1.2. the position of a node is checked correctly when
 *           1.2.1. it is the first node
 *           1.2.2. it is the last node
 *           1.2.3. it is a terminal node and its the
 *               1.2.3.1. first node
 *               1.2.3.2. last node
 *           1.2.4. it is not a terminal node
 **/

public class DequeNodeTest {

    DequeNode<Integer> nodo;

    @Nested
    @DisplayName("Test cases for the DequeNode implementation that checks if")
    class testCasesThatCheckDequeNodeFunctions {

        @BeforeEach
        void setup() {
            nodo = new DequeNode<>(1, null, null);
        }

        @AfterEach
        void shutdown() {
            nodo = null;
        }

        @Nested
        @DisplayName("a created node stores properly its")
        class testCasesThatCheckDequeNodeCreation {
            @Test
            @DisplayName("item")
            void checksIfItemIsStoredProperly() {
                int expectedItem = 1;

                DequeNode<Integer> obtainedNode = new DequeNode<>(1, null, null);

                assertEquals(expectedItem, obtainedNode.getItem());
            }

            @Test
            @DisplayName("previous node")
            void checkfsIfPreviousNodeIsStoredProperly() {
                DequeNode<Integer> expectedPreviousNode = null;

                DequeNode<Integer> obtainedNode = new DequeNode<>(1, null, null);

                assertEquals(expectedPreviousNode, obtainedNode.getPrevious());
            }

            @Test
            @DisplayName("next node")
            void checkfsIfNextNodeIsStoredProperly() {
                DequeNode<Integer> expectedNextNode = null;

                DequeNode<Integer> obtainedNode = new DequeNode<>(1, null, null);

                assertEquals(expectedNextNode, obtainedNode.getNext());
            }
        }

        @Nested
        @DisplayName("a node can have properly changed with setters its")
        class testCasesThatCheckDequeNodeSetters {
            @Test
            @DisplayName("item")
            void checksIfItemIsSetProperly() {
                nodo.setItem(2);

                int expectedItem = 2;

                assertEquals(expectedItem, nodo.getItem());
            }

            @Test
            @DisplayName("previous node")
            void checksIfPreviousNodeIsSetProperly() {
                DequeNode<Integer> expectedPreviousNode = new DequeNode<>(1, null, null);

                nodo.setPrevious(expectedPreviousNode);

                assertEquals(expectedPreviousNode, nodo.getPrevious());
            }

            @Test
            @DisplayName("next node")
            void checksIfNextNodeIsSetProperly() {
                DequeNode<Integer> expectedNextNode = new DequeNode<>(1, null, null);

                nodo.setNext(expectedNextNode);

                assertEquals(expectedNextNode, nodo.getNext());
            }
        }

        @Nested
        @DisplayName("the position of a node is checked correctly when")
        class testCasesThatCheckForNodesPosition {
            @Test
            @DisplayName("it is the first node")
            void checkIfTheSupposedlyFirstNodeIsActuallyTheFirstNode() {
                assertTrue(nodo.isFirstNode());
            }

            @Test
            @DisplayName("it is the last node")
            void checkIfTheSupposedlyLastNodeIsActuallyTheLastNode() {
                DequeNode<Integer> lastNode = new DequeNode<>(1, null, null);

                nodo.setNext(lastNode);
                lastNode.setPrevious(nodo);
                assertTrue(lastNode.isLastNode());
            }

            @Nested
            @DisplayName("it is a terminal node and its the")
            class testCasesThatCheckIfTheNodeIsTerminal
            {
                @Test
                @DisplayName("first node")
                void checkIfTheFirstNodeIsATerminalNode()
                {
                    assertFalse(nodo.isNotATerminalNode());
                }

                @Test
                @DisplayName("last node")
                void checkIfTheLastNodeIsATerminalNode()
                {
                    DequeNode<Integer> notTerminalNode = new DequeNode<>(1, null, null);
                    DequeNode<Integer> lastNode = new DequeNode<>(1, null, null);

                    lastNode.setPrevious(notTerminalNode);

                    assertFalse(lastNode.isNotATerminalNode());
                }
            }

            @Test
            @DisplayName("it is not a terminal node")
            void checkIfTheSupposedlyNotTerminalNodeIsActuallyANotTerminalNode() {
                DequeNode<Integer> notTerminalNode = new DequeNode<>(1, null, null);
                DequeNode<Integer> lastNode = new DequeNode<>(1, null, null);

                notTerminalNode.setPrevious(nodo);
                notTerminalNode.setNext(lastNode);
                nodo.setNext(notTerminalNode);
                lastNode.setPrevious(notTerminalNode);

                assertTrue(notTerminalNode.isNotATerminalNode());
            }
        }
    }
}

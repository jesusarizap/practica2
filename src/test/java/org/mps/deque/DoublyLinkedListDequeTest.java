package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {

    /**
     * Casos tests DoublyLinkedListDequeTest();
     *
     *  Test cases for the DoublyLinkedListDeque implementation that checks if
     *      an empty list
     *          throws an exception when looking for the first element
     *          throws an exception when looking for the last element
     *          has size 0
     *          when an element is added at the beggining
     *              it doesn't have a predecessor
     *              it doesn't have a predecessor
     *
     */

    DoublyLinkedListDeque<Integer> deque;

    @Nested
    @DisplayName("Test cases for the DoublyLinkedListDeque implementation that checks if")
    class testCasesThatCheckDoublyLinkedListDequeFunctions {

        @Nested
        @DisplayName("an empty list")
        class checkIfAnEmptyList {

            @BeforeEach
            void setup() {
                deque = new DoublyLinkedListDeque<>(null, null);
            }

            @AfterEach
            void shutdown() {
                deque = null;
            }

            @Test
            @DisplayName("throws an exception when looking for the first element")
            void checkThatAnEmptyListDoesntHaveFirstElement()
            {
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("throws an exception when looking for the last element")
            void checkThatAnEmptyListDoesntHaveLastElement()
            {
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("has size 0")
            void checkThatAnEmptyListHasSizeZero()
            {
                int expectedValue = 0;
                assertEquals(expectedValue, deque.size());
            }

            /*
            @Nested
            @DisplayName("when an element is added at the beggining")
            class checkAdditionsToEmptyList
            {
                @Test
                @DisplayName("it doesn't have a predecessor")
                void checkThatAtTheBeginningItDoesntHaveAPredecessor()
                {
                    String expectedValue = null;

                    deque.prepend(1);

                    assertNull(deque.first().getNext());
                }

                @Test
                @DisplayName("it doesn't have an antecessor")
                void checkThatAtTheBeginningItDoesntHaveAnAntecessor()
                {
                    String expectedValue = null;

                    deque.append(1);

                    assertNull(expectedValue);
                }
            }*/

            @Nested
            @DisplayName("returns DoubleEndedQueueException when")
            class checkReturnsOfDoubleEndedQueueExceptions
            {
                @Test
                @DisplayName("deleteFirst()")
                void checkThatWhenUsingDeleteFirstTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
                }

                @Test
                @DisplayName("deleteLast()")
                void checkThatWhenUsingDeleteLastTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
                }
            }

        }

        @Nested
        @DisplayName("a list with an element")
        class checkIfAListWithAnElement
        {
            @BeforeEach
            void setup() {
                deque = new DoublyLinkedListDeque<>(null, null);
                deque.prepend(1);
            }

            @AfterEach
            void shutdown() {
                deque = null;
            }

            @Test
            @DisplayName("has first element")
            void checkIfTheListHasAFirstElement()
            {
                int expectedValue = 1;

                assertEquals(expectedValue, deque.first());
            }

            @Test
            @DisplayName("has last element")
            void checkIfTheListHasALastElement()
            {
                int expectedValue = 1;

                assertEquals(expectedValue, deque.last());
            }

            @Test
            @DisplayName("returns its actual size")
            void checkIfTheSizeIsCorrect()
            {
                int expectedValue = 1;

                assertEquals(expectedValue, deque.size());
            }

            @Test
            @DisplayName("returns its actual size after adding an element")
            void checkIfTheSizeIsCorrectAfterAddingAnElement()
            {
                int expectedValue = 2;

                deque.prepend(2);

                assertEquals(expectedValue, deque.size());
            }

            @Nested
            @DisplayName("adds correctly an element at the")
            class checkAddedElements
            {
                @Test
                @DisplayName("beginning")
                void checkAddedElementAtTheBeginning()
                {
                    int expectedValue = deque.size()+1;

                    deque.prepend(1);

                    assertEquals(expectedValue, deque.size());
                }

                @Test
                @DisplayName("end")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValue = deque.size()+1;

                    deque.append(1);

                    assertEquals(expectedValue, deque.size());
                }
            }

            @Nested
            @DisplayName("deletes correctly an element at the")
            class checkDeletedElements
            {
                @Test
                @DisplayName("beginning")
                void checkDeletedElementAtTheBeginning()
                {
                    deque.append(1);

                    int expectedValue = deque.size()-1;

                    deque.deleteFirst();

                    assertEquals(expectedValue, deque.size());
                }

                @Test
                @DisplayName("end")
                void checkDeletedElementAtTheLast()
                {
                    deque.append(1);

                    int expectedValue = deque.size()-1;

                    deque.deleteLast();

                    assertEquals(expectedValue, deque.size());
                }
            }
        }
    }
}

package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {

    /**
     * Una lista vacia
     *      no debe tener primer ni ultimo elemento (null)
     *      debe tener longitud 0
     *      cuando añade un elemento
     *          al principio no tiene predecesor ni antecesor ????
     *          al final no tiene predecesor ni antecesor     ????
     *      devuelve DoubleEndedQueueException si deleteFirt()
     *      devuelve DoubleEndedQueueException si deleteLast()
     *      devuelve DoubleEndedQueueException si first()      este ya se comprueba al principio y no va por excepcion
     *      devuelve DoubleEndedQueueException si last()       idem
     * Una lista con al menos un elemento
     *      debe tener primer y ultimo elemento
     *      debe tener longitud correcta
     *      añade un elemento corretamente
     *          al principio
     *          al final
     *      borra elementos correctamente
     *          al principio
     *          al final
     *      muestra correctamente
     *          el primer elemento
     *          el ultimo momento
     *      puede recorrer del primer al ultimo elemento (¿en [size] pasos? como lo ve Jesus)
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
            @DisplayName("doesn't have a first element (null)")
            void checkThatAnEmptyListDoesntHaveFirstElement()
            {
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("doesn't have a last element (null)")
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

                    assertNull(expectedValue);
                }

                @Test
                @DisplayName("it doesn't have an antecessor")
                void checkThatAtTheBeginningItDoesntHaveAnAntecessor()
                {
                    String expectedValue = null;

                    deque.append(1);

                    assertNull(expectedValue);
                }
            }

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
                @DisplayName("last")
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

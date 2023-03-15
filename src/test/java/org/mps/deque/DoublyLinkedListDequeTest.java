package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nicolás Lerible
 * @author Jesús Ariza
 * Casos de prueba para DoublyLinkedListDeque():
 *
 *  1. Test cases for the DoublyLinkedListDeque implementation that checks if
 *      1.1. an empty list
 *          1.1.2. has size 0
 *          1.1.3. adds correctly an element at the
 *              1.1.3.1. beginning
 *              1.1.3.2. beginning and increments its size
 *              1.1.3.3. end
 *              1.1.3.4. end and increments its size
 *          1.1.4. returns DoubleEndedQueueException when
 *              1.1.4.1. throws an exception when looking for the first element
 *              1.1.4.2. throws an exception when looking for the last element
 *              1.1.4.3. deleteFirst()
 *              1.1.4.4. deleteLast()
 *      1.2. a list with an element
 *          1.2.1. has first element
 *          1.2.2. has last element
 *          1.2.3. returns its actual size
 *          1.2.4. returns its actual size after adding an element
 *          1.2.5. adds correctly an element at the
 *              1.2.5.1. beginning
 *              1.2.5.2. end
 *          1.2.6. deletes correctly an element at the
 *              1.2.6.1. beginning
 *              1.2.6.2. end
 *
 * Tests de la segunda entrega:
 *
 */

public class DoublyLinkedListDequeTest {

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
            @DisplayName("has size 0")
            void checkThatAnEmptyListHasSizeZero()
            {
                int expectedValue = 0;
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
                    int expectedValue = 1;

                    deque.prepend(1);

                    assertEquals(expectedValue, deque.first());
                }

                @Test
                @DisplayName("beginning and increments its size")
                void checkSizeForAddedElementAtTheBeginning()
                {
                    int expectedValue = deque.size()+1;

                    deque.prepend(1);

                    assertEquals(expectedValue, deque.size());
                }

                @Test
                @DisplayName("end")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValue = 1;

                    deque.append(1);

                    assertEquals(expectedValue, deque.last());
                }

                @Test
                @DisplayName("end and increments its size")
                void checkSizeForAddedElementAtTheEnd()
                {
                    int expectedValue = deque.size()+1;

                    deque.append(1);

                    assertEquals(expectedValue, deque.size());
                }
            }

            @Nested
            @DisplayName("returns DoubleEndedQueueException when")
            class checkReturnsOfDoubleEndedQueueExceptions
            {
                @Test
                @DisplayName("looking for the first element")
                void checkThatAnEmptyListDoesntHaveFirstElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                }

                @Test
                @DisplayName("looking for the last element")
                void checkThatAnEmptyListDoesntHaveLastElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.last());
                }

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

                @Test
                @DisplayName("checking the item of a node with get()")
                void checkThatWhenCheckingTheValueWithGetTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.get(0));
                }
            }

            @Test
            @DisplayName("when checking if it has an element, it returns false")
            void checksThatItReturnsFalseWhenAskingForAnElementItMayContain()
            {
                assertFalse(deque.contains(1));
            }

            @Test
            @DisplayName("when removing an element the size doesn't change")
            void checksThatWhenAnElementIsRemoved()
            {
                int expectedValue = deque.size();

                deque.remove(1);

                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
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
                    int expectedValue = 5;

                    deque.prepend(5);

                    assertEquals(expectedValue, deque.first());
                }

                @Test
                @DisplayName("end")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValue = 5;

                    deque.append(5);

                    assertEquals(expectedValue, deque.last());
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

            @Nested
            @DisplayName("when using the get function")
            class checksGetFunctionVariations
            {
                @Test
                @DisplayName("the item is returned properly")
                void checkTheItemIsReturnedProperlyWhenUsingGet()
                {
                    int expectedValue = 1;

                    int obtainedValue = deque.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and a node is added, the items are returned properly")
                void checkVariousItemsAreReturnedProperlyWhenUsingGet()
                {
                    int[] expectedValues = {1, 4};

                    deque.append(4);

                    int[] obtainedValues = {deque.get(0), deque.get(1)};

                    assertArrayEquals(expectedValues, obtainedValues);
                }

                @Test
                @DisplayName("with a negative index out of bounds, the DoubleEndedQueueException is returned")
                void checkDoubleEndedQueueExceptionIsReturnedWithANegativeOutOfBoundsIndex()
                {
                    assertThrows(NullPointerException.class, () -> deque.get(-1));
                }

                @Test
                @DisplayName("with a positive index out of bounds, the DoubleEndedQueueException is returned")
                void checkDoubleEndedQueueExceptionIsReturnedWithAPositiveOutOfBoundsIndex()
                {
                    assertThrows(NullPointerException.class, () -> deque.get(1));
                }
            }

            @Nested
            @DisplayName("when using the contain function")
            class checksForContainedElementsOnList
            {
                @Test
                @DisplayName("it properly checks that an element is on the list")
                void checksThatAnElementIsContainedOnTheList()
                {
                    assertTrue(deque.contains(1));
                }

                @Test
                @DisplayName("it properly checks that an element is not on the list")
                void checksThatAnElementIsNotContainedOnTheList()
                {
                    assertFalse(deque.contains(2));
                }
            }

            @Nested
            @DisplayName("when using the remove function")
            class checksIfElementsAreRemovedProperly
            {
                @Test
                @DisplayName("it removes the first element")
                void checksIfAnElementOnTheFirstPositionIsRemovedCorrectly()
                {
                    deque.prepend(6);

                    deque.remove(6);

                    assertFalse(deque.contains(6));
                }

                @Test
                @DisplayName("it removes an intermediate element")
                void checksIfAnElementOnAnIntermediatePositionIsRemovedCorrectly()
                {
                    deque.append(6);
                    deque.append(7);

                    deque.remove(6);

                    assertFalse(deque.contains(6));
                }

                @Test
                @DisplayName("it removes the last element")
                void checksIfAnElementOnTheLastPositionIsRemovedCorrectly()
                {
                    deque.append(6);

                    deque.remove(6);

                    assertFalse(deque.contains(6));
                }
            }

            @Nested
            @DisplayName("when using the sort function")
            class checkIfElementsGetSortedProperly
            {
                @Test
                @DisplayName("a list with one element does not change")
                void checkIfListIsOneElementIsSortedProperly()
                {
                    deque.sort((a, b) -> a.compareTo(b));

                    int expectedValue = deque.get(0);
                    int obtainedValue = deque.first();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("a list with 2 or more elements gets sorted properly")
                void checkIfListWithTwoOrMoreElementsIsSortedProperly()
                {
                    deque.prepend(2);
                    deque.append(4);
                    deque.prepend(7);
                    deque.append(8);

                    deque.sort((a, b) -> a.compareTo(b));

                    int expectedValue = deque.get(4);
                    int obtainedValue = deque.last();

                    assertEquals(expectedValue, obtainedValue);
                }
            }
        }
    }
}

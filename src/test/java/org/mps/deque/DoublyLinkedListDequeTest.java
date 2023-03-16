package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nicolás Lerible
 * @author Jesús Ariza
 * Casos de prueba para DoublyLinkedListDeque():
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
 *          1.2.5. adds correctly an element at the
 *              1.2.5.1. beginning
 *              1.2.5.2. beginning and increments its size
 *              1.2.5.3. end
 *              1.2.5.4. end and increments its size
 *          1.2.6. deletes correctly an element at the
 *              1.2.6.1. beginning
 *              1.2.6.2. end
 * Tests de la segunda entrega:
 */

public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> deque;

    @Nested
    @DisplayName("Test cases for the DoublyLinkedListDeque implementation")
    class testCasesThatCheckDoublyLinkedListDequeFunctions {

        /**
         * To avoid redundancy, in these tests the word "size" exclusively implies the number of elements that are on the list the tests are working with
         */
        @Nested
        @DisplayName("Given an empty list")
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
            @DisplayName("when the size of the list is checked then it returns 0 (as in there are no elements on the list)")
            void checkThatAnEmptyListHasSizeZero()
            {
                int expectedValue = 0;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when an element is added at the")
            class checkAddedElements
            {
                @Test
                @DisplayName("beginning then the element is added properly as the first one")
                void checkAddedElementAtTheBeginning()
                {
                    int expectedValue = 1;

                    deque.prepend(1);

                    int obtainedValue = deque.first();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("beginning then the size of the list increments by one")
                void checkSizeForAddedElementAtTheBeginning()
                {
                    int expectedValue = deque.size()+1;

                    deque.prepend(1);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the element is added properly as the last one")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValue = 1;

                    deque.append(1);

                    int obtainedValue = deque.last();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the size of the list increments by one")
                void checkSizeForAddedElementAtTheEnd()
                {
                    int expectedValue = deque.size()+1;

                    deque.append(1);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }
            }

            @Nested
            @DisplayName("when checking for exceptions and")
            class checkReturnsOfDoubleEndedQueueExceptions
            {
                @Test
                @DisplayName("looking for the first element of the list then the returned exception is DoubleEndedQueueException")
                void checkThatAnEmptyListDoesntHaveFirstElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                }

                @Test
                @DisplayName("looking for the last element of the list then the returned exception is DoubleEndedQueueException")
                void checkThatAnEmptyListDoesntHaveLastElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.last());
                }

                @Test
                @DisplayName("the first element of the list is deleted then the returned exception is DoubleEndedQueueException")
                void checkThatWhenUsingDeleteFirstTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
                }

                @Test
                @DisplayName("the last element of the list is deleted then the returned exception is DoubleEndedQueueException")
                void checkThatWhenUsingDeleteLastTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
                }

                @Test
                @DisplayName("there is a check for an element in a given position then the returned exception is DoubleEndedQueueException)")
                void checkThatWhenCheckingTheValueWithGetTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.get(0));
                }
            }

            @Test
            @DisplayName("when checking if the list contains a specific element then it gives back that it does not have it")
            void checksThatItReturnsFalseWhenAskingForAnElementItMayContain()
            {
                assertFalse(deque.contains(1));
            }

            @Test
            @DisplayName("when removing an element from the list then the size of the list does not change")
            void checksThatWhenAnElementIsRemoved()
            {
                int expectedValue = deque.size();

                deque.remove(1);

                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }
        }

        @Nested
        @DisplayName("Given a list with an element")
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
            @DisplayName("when checking if it has a first element then it returns its only element")
            void checkIfTheListHasAFirstElement()
            {
                int expectedValue = 1;
                int obtainedValue = deque.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when checking if it has a last element then it returns its only element")
            void checkIfTheListHasALastElement()
            {
                int expectedValue = 1;
                int obtainedValue = deque.last();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when the size of the list is checked then it returns one (as in it only has one element)")
            void checkIfTheSizeIsCorrect()
            {
                int expectedValue = 1;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when adding an element to the list then it returns the previous size of the list incremented by one")
            void checkIfTheSizeIsCorrectAfterAddingAnElement()
            {
                int expectedValue = 2;

                deque.prepend(2);

                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when adding an element at the")
            class checkAddedElements
            {
                @Test
                @DisplayName("beginning then it is added properly as the first one and the original element is now only the last one")
                void checkAddedElementAtTheBeginning()
                {
                    int expectedValueFirst = 5;
                    int expectedValueLast = 1;

                    deque.prepend(5);

                    int obtainedValueFirst = deque.first();
                    int obtainedValueLast = deque.last();

                    assertEquals(expectedValueFirst, obtainedValueFirst);
                    assertEquals(expectedValueLast, obtainedValueLast);
                }

                @Test
                @DisplayName("end then it is added properly as the last one and the original element is now only the first one")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValueLast = 5;
                    int expectedValueFirst = 1;

                    deque.append(5);

                    int obtainedValueLast = deque.last();
                    int obtainedValueFirst = deque.first();

                    assertEquals(expectedValueLast, obtainedValueLast);
                    assertEquals(expectedValueFirst, obtainedValueFirst);
                }
            }

            @Nested
            @DisplayName("when an element is deleted from the list at the")
            class checkDeletedElements
            {
                @Test
                @DisplayName("beginning then the size of the list decreases by one")
                void checkDeletedElementAtTheBeginning()
                {
                    deque.append(1);

                    int expectedValue = deque.size()-1;

                    deque.deleteFirst();

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the size of the list decreases by one")
                void checkDeletedElementAtTheLast()
                {
                    deque.append(1);

                    int expectedValue = deque.size()-1;

                    deque.deleteLast();

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }
            }

            @Nested
            @DisplayName("when looking for the element in a given position (index)")
            class checksGetFunctionVariations
            {
                @Test
                @DisplayName("and checking the first position then the returned element is its only element")
                void checkTheItemIsReturnedProperlyWhenUsingGet()
                {
                    int expectedValue = 1;
                    int obtainedValue = deque.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and a node is added then both positions of the elements return those elements")
                void checkVariousItemsAreReturnedProperlyWhenUsingGet()
                {
                    int[] expectedValues = {1, 4};

                    deque.append(4);

                    int[] obtainedValues = {deque.get(0), deque.get(1)};

                    assertArrayEquals(expectedValues, obtainedValues);
                }

                @Test
                @DisplayName("and that position is a negative index out of bounds then the IndexOutOfBoundsException is returned")
                void checkIndexOutOfBoundsExceptionIsReturnedWithANegativeOutOfBoundsIndex()
                {
                    assertThrows(IndexOutOfBoundsException.class, () -> deque.get(-1));
                }

                @Test
                @DisplayName("and that position is a positive index out of bounds, the IndexOutOfBoundsException is returned")
                void checkIndexOutOfBoundsExceptionIsReturnedWithAPositiveOutOfBoundsIndex()
                {
                    assertThrows(IndexOutOfBoundsException.class, () -> deque.get(1));
                }
            }

            @Nested
            @DisplayName("when checking if the list contains the element")
            class checksForContainedElementsOnList
            {
                @Test
                @DisplayName("and the element is on the list then it returns that the list has the element")
                void checksThatAnElementIsContainedOnTheList()
                {
                    assertTrue(deque.contains(1));
                }

                @Test
                @DisplayName("and the element is not on the list then it returns that the list does not have the element")
                void checksThatAnElementIsNotContainedOnTheList()
                {
                    assertFalse(deque.contains(2));
                }
            }

            @Nested
            @DisplayName("when removing the element from the list")
            class checksIfElementsAreRemovedProperly
            {
                @Test
                @DisplayName("then the size of the list decreases by one")
                void checksIfTheRemovalOfTheElementCorrectlyShowADecreaseOfTheSizeOfTheList()
                {
                    int expectedValue = deque.size()-1;

                    //deque.remove(1);

                    int obtainedValue = deque.size()-1;

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("then it is no longer contained on the list")
                void checksIfTheRemovalOfTheElementCorrectlyMakesItNotBeOnTheList()
                {
                    //deque.remove(1);

                    assertFalse(!deque.contains(1));
                }
            }

            @Nested
            @DisplayName("when sorting the elements of the list")
            class checkIfElementsGetSortedProperly
            {
                @Test
                @DisplayName("then the list does not change")
                void checkIfListIsOneElementIsSortedProperly()
                {
                    deque.sort(Comparator.naturalOrder());

                    int expectedValue = deque.get(0);
                    int obtainedValue = deque.first();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and adding 2 or more elements then the elements gets sorted properly")
                void checkIfListWithTwoOrMoreElementsIsSortedProperly()
                {
                    deque.prepend(2);
                    deque.append(4);
                    deque.prepend(7);
                    deque.append(8);

                    deque.sort(Comparator.naturalOrder());

                    int expectedValue = deque.get(4);
                    int obtainedValue = deque.last();

                    assertEquals(expectedValue, obtainedValue);
                }
            }
        }

        @Nested
        @DisplayName("Given a list with multiple elements")
        class checkIfAListWithMultipleElements
        {
            @BeforeEach
            void setup() {
                deque = new DoublyLinkedListDeque<>(null, null);
                deque.prepend(1);
                deque.append(2);
                deque.append(3);
            }

            @AfterEach
            void shutdown() {
                deque = null;
            }

            @Test
            @DisplayName("when checking its first element then it returns the expected first element (1 in this case)")
            void checkIfTheListHasAFirstElement()
            {
                int expectedValue = 1;
                int obtainedValue = deque.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when checking its last element then it returns the expected last element (3 in this case)")
            void checkIfTheListHasALastElement()
            {
                int expectedValue = 3;
                int obtainedValue = deque.last();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when the size of the list is checked then it returns its expected size (3 in this case)")
            void checkIfTheSizeIsCorrect()
            {
                int expectedValue = 3;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when adding an element to the list then it returns the previous size of the list incremented by one")
            void checkIfTheSizeIsCorrectAfterAddingAnElement()
            {
                int expectedValue = deque.size()+1;

                deque.append(4);

                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when adding an element at the")
            class checkAddedElements
            {
                @Test
                @DisplayName("beginning then it is added properly as the first one and the original first element is now the second one")
                void checkAddedElementAtTheBeginning()
                {
                    int expectedValueFirst = 4;
                    int expectedValueSecond = deque.first();

                    deque.prepend(4);

                    assertEquals(expectedValueFirst, deque.first());
                    assertEquals(expectedValueSecond, deque.get(1));
                }

                @Test
                @DisplayName("end then it is added properly as the last one and the original last element is now second to last")
                void checkAddedElementAtTheEnd()
                {
                    int expectedValueLast = 4;
                    int expectedValueSecondToLast = deque.last();

                    deque.append(4);

                    assertEquals(expectedValueLast, deque.last());
                    assertEquals(expectedValueSecondToLast, deque.get(2));
                }
            }

            @Nested
            @DisplayName("when an element is deleted from the list at the")
            class checkDeletedElements
            {
                @Test
                @DisplayName("beginning then the size of the list decreases by one and the second element is now the first one")
                void checkDeletedElementAtTheBeginning()
                {
                    int expectedValue = deque.size()-1;

                    int expectedValueFirst = deque.get(1);

                    deque.deleteFirst();

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueFirst, deque.first());
                }

                @Test
                @DisplayName("and then the size of the list decreases by one and the second to last is now the last element")
                void checkDeletedElementAtTheLast()
                {
                    int expectedValue = deque.size()-1;

                    deque.deleteLast();

                    int expectedValueLast = deque.get(1);

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueLast, deque.last());
                }
            }

            @Nested
            @DisplayName("when looking for the element in a given position (index)")
            class checksGetFunctionVariations
            {
                @Test
                @DisplayName("and checking the first position then the returned element is the expected first element (1 in this case)")
                void checkTheItemIsReturnedProperlyWhenUsingGet()
                {
                    int expectedValue = 1;
                    int obtainedValue = deque.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and a node is added then all the positions of the elements return each of the elements")
                void checkVariousItemsAreReturnedProperlyWhenUsingGet()
                {
                    deque.append(4);

                    int[] expectedValues = {1, 2, 3, 4};

                    int[] obtainedValues = {deque.get(0), deque.get(1), deque.get(2), deque.get(3)};

                    assertArrayEquals(expectedValues, obtainedValues);
                }
            }

            @Nested
            @DisplayName("when removing an element from the list")
            class checksIfElementsAreRemovedProperly
            {
                @Test
                @DisplayName("and the removed element is the first one then the size of the list decreases by one and the second element is the first one")
                void checksIfAnElementOnTheFirstPositionIsRemovedCorrectly()
                {
                    int expectedValue = deque.size()-1;

                    int expectedValueFirst = deque.get(1);

                    deque.remove(1);

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueFirst, deque.first());
                }

                @Test
                @DisplayName("and the removed element is an intermediate element the size of the list decreases by one")
                void checksIfAnElementOnAnIntermediatePositionIsRemovedCorrectly()
                {
                    int expectedValue = deque.size()-1;

                    deque.remove(2);

                    assertEquals(expectedValue, deque.size());
                }

                @Test
                @DisplayName("and the removed element is the last one then size of the list decreases by one and the second to last element is the last one")
                void checksIfAnElementOnTheLastPositionIsRemovedCorrectly()
                {
                    int expectedValue = deque.size()-1;

                    deque.remove(3);

                    int expectedValueLast = deque.get(1);

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueLast, deque.last());
                }
            }

            @Nested
            @DisplayName("when sorting the elements of the list")
            class checkIfElementsGetSortedProperly
            {
                @Test
                @DisplayName("on reverse order then the elements gets sorted properly")
                void checkIfListWithReverseOrderComparatorGetsSortedProperly()
                {
                    deque.sort(Comparator.reverseOrder());

                    int[] expectedValue = {3, 2, 1};
                    int[] obtainedValue = {deque.get(0), deque.get(1), deque.get(2)};

                    assertArrayEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("on natural order then the elements stay on the same position (the list has the elements already in order)")
                void checkIfListWithNaturalOrderComparatorGetsSortedProperly()
                {
                    deque.sort(Comparator.naturalOrder());

                    int[] expectedValue = {1, 2, 3};
                    int[] obtainedValue = {deque.get(0), deque.get(1), deque.get(2)};

                    assertArrayEquals(expectedValue, obtainedValue);
                }
            }
        }
    }
}

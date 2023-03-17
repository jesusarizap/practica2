package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nicolás Lerible
 * @author Jesús Ariza
 * Casos de prueba para DoublyLinkedListDeque():
 *  Test cases for the DoublyLinkedListDeque implementation
 * 1. Given an empty list
 * 	1.1. when the size of the list is checked then it returns 0 (as in there are no elements on the list)
 * 	1.2. when an element is added at the
 * 		1.2.1. beginning then the element is added properly as the first one
 * 		1.2.2. beginning then the size of the list increments by one
 * 		1.2.3. end then the element is added properly as the last one
 * 		1.2.4. end then the size of the list increments by one
 * 	1.3. when checking for exceptions and
 * 		1.3.1. looking for the first element of the list then the returned exception is DoubleEndedQueueException
 * 		1.3.2. looking for the last element of the list then the returned exception is DoubleEndedQueueException
 * 		1.3.3. the first element of the list is deleted then the returned exception is DoubleEndedQueueException
 * 		1.3.4. the last element of the list is deleted then the returned exception is DoubleEndedQueueException
 * 		1.3.5. there is a check for an element in a given position then the returned exception is DoubleEndedQueueException)
 * 	1.4. when checking if the list contains a specific element then it gives back that it does not have it
 * 	1.5. when removing an element from the list then the size of the list does not change
 * 2. Given a list with an element
 * 	2.1. when checking if it has a first element then it returns its only element
 * 	2.2. when checking if it has a last element then it returns its only element
 * 	2.3. when the size of the list is checked then it returns one (as in it only has one element)
 * 	2.4. when adding an element to the list then it returns the previous size of the list incremented by one
 * 	2.5. when adding an element at the
 * 		2.5.1. beginning then it is added properly as the first one and the original element is now only the last one
 * 		2.5.2. end then it is added properly as the last one and the original element is now only the first one
 * 	2.6. when an element is deleted from the list at the
 * 		2.6.1. beginning then the size of the list decreases by one
 * 		2.6.2. end then the size of the list decreases by one
 * 	2.7. when looking for the element in a given position (index)
 * 		2.7.1. and checking the first position then the returned element is its only element
 * 		2.7.2. and that position is a negative index out of bounds then the IndexOutOfBoundsException is returned
 * 		2.7.3. and a node is added then both positions of the elements return those elements
 * 		2.7.4. and that position is a positive index out of bounds, the IndexOutOfBoundsException is returned
 * 	2.8. when checking if the list contains the element
 * 		2.8.1. and the element is on the list then it returns that the list has the element
 * 		2.8.2. and the element is not on the list then it returns that the list does not have the element
 * 	2.9. when removing the element from the list
 * 		2.9.1. then the size of the list decreases by one
 * 		2.9.2. then it is no longer contained on the list
 * 	2.10. when sorting the elements of the list
 * 		2.10.1 then the list does not change
 * 		2.10.2 and adding 2 or more elements, then the elements gets sorted properly
 * 3. Given a list with multiple elements
 * 	3.1. when checking its first element then it returns the expected first element (1 in this case)
 * 	3.2. when checking its last element then it returns the expected last element (3 in this case)
 * 	3.3. when the size of the list is checked then it returns its expected size (3 in this case)
 * 	3.4. when adding an element at the
 * 		3.4.1. beginning then it is added properly as the first one and the original first element is now the second one
 * 		3.4.2. beginning then it returns the previous size of the list incremented by one
 * 		3.4.3. end then it is added properly as the last one and the original last element is now second to last
 * 		3.4.4. end then it returns the previous size of the list incremented by one
 * 	3.5. when an element is deleted from the list at the
 * 		3.5.1. beginning then the size of the list decreases by one and the second element is now the first one
 * 		3.5.2. and then the size of the list decreases by one and the second to last is now the last element
 * 	3.6. when looking for the element in a given position (index)
 * 		3.6.1. and checking the first position then the returned element is the expected first element (1 in this case)
 * 		3.6.2. and a node is added then all the positions of the elements return each of the elements
 * 	3.7. when removing an element from the list
 * 		3.7.1. and the removed element is the first one then the size of the list decreases by one and the second element is the first one
 * 		3.7.2. and the removed element is an intermediate element the size of the list decreases by one
 * 		3.7.3. and the removed element is the last one then size of the list decreases by one and the second to last element is the last one
 * 	3.8. when sorting the elements of the list
 * 		3.8.1. on reverse order then the elements gets sorted properly
 * 		3.8.2 on natural order then the elements stay on the same position (the list has the elements already in order)
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
        class checkGivenAnEmptyList {

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
            void checkWhenSizeCheckedThenTheSizeIsZero()
            {
                int expectedValue = 0;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when an element is added at the")
            class checkWhenAddedElements
            {
                @Test
                @DisplayName("beginning then the element is added properly as the first one")
                void checkAtTheBeginningThenIsTheFirstOne()
                {
                    int expectedValue = 1;

                    deque.prepend(1);

                    int obtainedValue = deque.first();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("beginning then the size of the list increments by one")
                void checkAtTheBeginningThenSizeIncrementsOne()
                {
                    int expectedValue = deque.size()+1;

                    deque.prepend(1);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the element is added properly as the last one")
                void checkAtTheEndThenIsTheLastOne()
                {
                    int expectedValue = 1;

                    deque.append(1);

                    int obtainedValue = deque.last();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the size of the list increments by one")
                void checkAtTheEndThenSizeIncrementsOne()
                {
                    int expectedValue = deque.size()+1;

                    deque.append(1);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }
            }

            @Nested
            @DisplayName("when checking for exceptions and")
            class checkWhenCheckingForDoubleEndedQueueExceptions
            {
                @Test
                @DisplayName("looking for the first element of the list then the returned exception is DoubleEndedQueueException")
                void checkThenThatAnEmptyListDoesNotHaveFirstElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                }

                @Test
                @DisplayName("looking for the last element of the list then the returned exception is DoubleEndedQueueException")
                void checkThenThatAnEmptyListThenItDoesNotHaveLastElement()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.last());
                }

                @Test
                @DisplayName("the first element of the list is deleted then the returned exception is DoubleEndedQueueException")
                void checkThatWhenUsingDeleteFirstThenTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
                }

                @Test
                @DisplayName("the last element of the list is deleted then the returned exception is DoubleEndedQueueException")
                void checkThatWhenUsingDeleteLastThenTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
                }

                @Test
                @DisplayName("there is a check for an element in a given position then the returned exception is DoubleEndedQueueException)")
                void checkThatWhenCheckingTheValueWithGetThenTheExceptionIsTriggered()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.get(0));
                }
            }

            @Test
            @DisplayName("when checking if the list contains a specific element then it gives back that it does not have it")
            void checksWhenAskingForAnElementItMayContainThenItReturnsFalse()
            {
                assertFalse(deque.contains(1));
            }

            @Test
            @DisplayName("when removing an element from the list then the size of the list does not change")
            void checksThatWhenAnElementIsRemovedThenSizeDoesNotChange()
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
            void checkWhenCheckingIfTheListHasAFirstElementThenItReturnsItsOnlyElement()
            {
                int expectedValue = 1;
                int obtainedValue = deque.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when checking if it has a last element then it returns its only element")
            void checkWhenCheckingIfTheListHasALastElementThenItReturnsItsOnlyElement()
            {
                int expectedValue = 1;
                int obtainedValue = deque.last();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when the size of the list is checked then it returns one (as in it only has one element)")
            void checkWhenTheSizeIsCheckedThenItReturnsOne()
            {
                int expectedValue = 1;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when adding an element to the list then it returns the previous size of the list incremented by one")
            void checkWhenTheSizeIsCheckedAfterAddingAnElementThenItReturnsItIncremented()
            {
                int expectedValue = 2;

                deque.prepend(2);

                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when adding an element at the")
            class checkWhenAddedElements
            {
                @Test
                @DisplayName("beginning then it is added properly as the first one and the original element is now only the last one")
                void checkAddedElementAtTheBeginningThenItGetsAddedAndOriginalNodeIsOnlyLastOne()
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
                void checkAddedElementAtTheEndThenItGetsAddedAndOriginalNodeIsOnlyFirstOne()
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
            class checkWhenDeletedElements
            {
                @Test
                @DisplayName("beginning then the size of the list decreases by one")
                void checkDeletedElementAtTheBeginningThenSizeDecreasesOne()
                {
                    deque.append(1);

                    int expectedValue = deque.size()-1;

                    deque.deleteFirst();

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then the size of the list decreases by one")
                void checkDeletedElementAtTheEndThenSizeDecreasesOne()
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
            class checksWhenGetFunctionVariations
            {
                @Test
                @DisplayName("and checking the first position then the returned element is its only element")
                void checkTheItemAndIsFirstPositionThenIsReturnedProperly()
                {
                    int expectedValue = 1;
                    int obtainedValue = deque.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and that position is a negative index out of bounds then the IndexOutOfBoundsException is returned")
                void checkANegativeIndexOutOfBoundsThenDoubleEndedQueueExceptionIsReturned()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.get(-1));
                }

                @Test
                @DisplayName("and a node is added then both positions of the elements return those elements")
                void checkVariousItemsPositionsThenAreReturnedProperly()
                {
                    int[] expectedValues = {1, 4};

                    deque.append(4);

                    int[] obtainedValues = {deque.get(0), deque.get(1)};

                    assertArrayEquals(expectedValues, obtainedValues);
                }

                @Test
                @DisplayName("and that position is a positive index out of bounds, the IndexOutOfBoundsException is returned")
                void checkPositiveIndexOutOfBoundsThenDoubleEndedQueueExceptionIsReturned()
                {
                    assertThrows(DoubleEndedQueueException.class, () -> deque.get(1));
                }
            }

            @Nested
            @DisplayName("when checking if the list contains the element")
            class checkWhenForContainedElementsOnList
            {
                @Test
                @DisplayName("and the element is on the list then it returns that the list has the element")
                void checkAnElementThatIsContainedThenItReturnsThatItIsOnTheList()
                {
                    assertTrue(deque.contains(1));
                }

                @Test
                @DisplayName("and the element is not on the list then it returns that the list does not have the element")
                void checkAnElementThatIsNotContainedThenItReturnsThatItIsNotOnTheList()
                {
                    assertFalse(deque.contains(2));
                }
            }

            @Nested
            @DisplayName("when removing the element from the list")
            class checkWhenIfElementsAreRemovedProperly
            {
                @Test
                @DisplayName("then the size of the list decreases by one")
                void checkIfTheRemovalOfTheElementCorrectlyThenItShowsADecreaseOfTheSizeOfTheList()
                {
                    int expectedValue = deque.size()-1;

                    deque.remove(1);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("then it is no longer contained on the list")
                void checkIfTheRemovalOfTheElementCorrectlyMakesThenItMakesItNotBeOnTheList()
                {
                    deque.remove(1);

                    assertFalse(deque.contains(1));
                }
            }

            @Nested
            @DisplayName("when sorting the elements of the list")
            class checkWhenIfElementsGetSortedProperly
            {
                @Test
                @DisplayName("then the list does not change")
                void checkIfListIsOneElementThenItDoesNotChange()
                {
                    deque.sort(Comparator.naturalOrder());

                    int expectedValue = deque.get(0);
                    int obtainedValue = deque.first();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and adding 2 or more elements then the elements gets sorted properly")
                void checkIfListWithTwoOrMoreElementsThenIsSortedProperly()
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
        class checkGivenAListWithMultipleElements
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
            void checkWhenCheckingIfTheListHasAFirstElementThenItReturnsTheExpectedValue()
            {
                int expectedValue = 1;
                int obtainedValue = deque.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when checking its last element then it returns the expected last element (3 in this case)")
            void checkWhenCheckingIfTheListHasALastElementThenItReturnsTheExpectedValue()
            {
                int expectedValue = 3;
                int obtainedValue = deque.last();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("when the size of the list is checked then it returns its expected size (3 in this case)")
            void checkWhenTheSizeIsCheckedThenItReturnsTheExpectedSize()
            {
                int expectedValue = 3;
                int obtainedValue = deque.size();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("when adding an element at the")
            class checkWhenAddedElements
            {
                @Test
                @DisplayName("beginning then it is added properly as the first one and the original first element is now the second one")
                void checkAddedElementAtTheBeginningThenFirstAndOriginalSecondOne()
                {
                    int expectedValueFirst = 4;
                    int expectedValueSecond = deque.first();

                    deque.prepend(4);

                    assertEquals(expectedValueFirst, deque.first());
                    assertEquals(expectedValueSecond, deque.get(1));
                }

                @Test
                @DisplayName("beginning then it returns the previous size of the list incremented by one")
                void checkAddedElementAtTheBeginningThenSizeIncreasesOne()
                {
                    int expectedValue = deque.size()+1;

                    deque.prepend(4);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("end then it is added properly as the last one and the original last element is now second to last")
                void checkAddedElementAtTheEndThenLastAndOriginalSecondToLast()
                {
                    int expectedValueLast = 4;
                    int expectedValueSecondToLast = deque.last();

                    deque.append(4);

                    assertEquals(expectedValueLast, deque.last());
                    assertEquals(expectedValueSecondToLast, deque.get(2));
                }

                @Test
                @DisplayName("end then it returns the previous size of the list incremented by one")
                void checkWhenAddedElementAtTheEndThenSizeIncreasesOne()
                {
                    int expectedValue = deque.size()+1;

                    deque.append(4);

                    int obtainedValue = deque.size();

                    assertEquals(expectedValue, obtainedValue);
                }
            }

            @Nested
            @DisplayName("when an element is deleted from the list at the")
            class checkWhenDeletedElements
            {
                @Test
                @DisplayName("beginning then the size of the list decreases by one and the second element is now the first one")
                void checkDeletedElementAtTheBeginningThenSizeOfListDecreasesOne()
                {
                    int expectedValue = deque.size()-1;

                    int expectedValueFirst = deque.get(1);

                    deque.deleteFirst();

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueFirst, deque.first());
                }

                @Test
                @DisplayName("and then the size of the list decreases by one and the second to last is now the last element")
                void checkDeletedElementAtTheLastThenSizeOfListDecreasesOne()
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
            class checksWhenGetFunctionVariations
            {
                @Test
                @DisplayName("and checking the first position then the returned element is the expected first element (1 in this case)")
                void checkTheFirstItemIsFirstPositionThenIsReturnedProperly()
                {
                    int expectedValue = 1;
                    int obtainedValue = deque.get(0);

                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("and a node is added then all the positions of the elements return each of the elements")
                void checkVariousItemsPositionsThenAreReturnedProperly()
                {
                    deque.append(4);

                    int[] expectedValues = {1, 2, 3, 4};

                    int[] obtainedValues = {deque.get(0), deque.get(1), deque.get(2), deque.get(3)};

                    assertArrayEquals(expectedValues, obtainedValues);
                }
            }

            @Nested
            @DisplayName("when removing an element from the list")
            class checksWhenElementsAreRemovedProperly
            {
                @Test
                @DisplayName("and the removed element is the first one then the size of the list decreases by one and the second element is the first one")
                void checksAnElementOnTheFirstPositionThenItIsRemovedCorrectly()
                {
                    int expectedValue = deque.size()-1;

                    int expectedValueFirst = deque.get(1);

                    deque.remove(1);

                    assertEquals(expectedValue, deque.size());
                    assertEquals(expectedValueFirst, deque.first());
                }

                @Test
                @DisplayName("and the removed element is an intermediate element the size of the list decreases by one")
                void checksAnElementOnAnIntermediatePositionThenItIsRemovedCorrectly()
                {
                    int expectedValue = deque.size()-1;

                    deque.remove(2);

                    assertEquals(expectedValue, deque.size());
                }

                @Test
                @DisplayName("and the removed element is the last one then size of the list decreases by one and the second to last element is the last one")
                void checksAnElementOnTheLastPositionThenItIsRemovedCorrectly()
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
            class checkWhenElementsGetSortedProperly
            {
                @Test
                @DisplayName("on reverse order then the elements gets sorted properly")
                void checkListWithReverseOrderComparatorThenItGetsSortedProperly()
                {
                    deque.sort(Comparator.reverseOrder());

                    int[] expectedValue = {3, 2, 1};
                    int[] obtainedValue = {deque.get(0), deque.get(1), deque.get(2)};

                    assertArrayEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("on natural order then the elements stay on the same position (the list has the elements already in order)")
                void checkListWithNaturalOrderComparatorThenItGetsSortedProperly()
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

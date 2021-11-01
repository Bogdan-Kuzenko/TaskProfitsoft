import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraySortAndValidateTest {

  ArraySortAndValidate arraySortAndValidate;

  @BeforeEach
  void setup() {
    arraySortAndValidate = new ArraySortAndValidate();
  }

  @AfterEach
  void clear() {
    arraySortAndValidate = null;
  }

  @Test
  void validateAndSortedArray() {
    Integer[] array = {1, 2, 8, 44, -1, -44, 6, 33};
    Integer[] result = {44, 33, 8, 6, 2, 1};
    Integer[] validated = arraySortAndValidate.validateAndSortedArray(array);
    Assertions.assertArrayEquals(result, validated);
  }

  @Test
  void checkNull() {
    Integer[] integers = arraySortAndValidate.validateAndSortedArray(null);
    Assertions.assertArrayEquals(new Integer[0], integers);
  }

  @Test
  void checkOnZero() {
    Integer[] zero = {0, 0, 0, 0, 0, 0};
    Integer[] result = arraySortAndValidate.validateAndSortedArray(zero);
    Assertions.assertArrayEquals(zero, result);
  }

  @Test
  void allNegativeNumber() {
    Integer[] negative = {-1, -2, -4, -67};
    Integer[] result = arraySortAndValidate.validateAndSortedArray(negative);
    Assertions.assertArrayEquals(new Integer[0], result);
  }

  @Test
  void sameNumber() {
    Integer[] same = {2, 4, 4, 4, 5, 2, -2, -5, -3};
    Integer[] expect = {5, 4, 4, 4, 2, 2};
    Integer[] result = arraySortAndValidate.validateAndSortedArray(same);
    Assertions.assertArrayEquals(expect, result);
  }
}
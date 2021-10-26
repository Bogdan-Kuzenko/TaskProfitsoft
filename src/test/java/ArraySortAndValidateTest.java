import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
    assertArrayEquals(result, validated);
  }
}
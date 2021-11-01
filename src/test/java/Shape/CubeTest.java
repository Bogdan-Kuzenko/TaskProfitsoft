package Shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CubeTest {

  @Test
  void zeroSide() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cube(0.0));
  }

  @Test
  void negativeSide() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cube(-1.0));
  }

  @Test
  void calcVolume() {
    Cube c = new Cube(2.0);
    Double cVolume = c.calcVolume();
    Double expect = 2.0 * 2.0 * 2.0;
    Assertions.assertEquals(expect, cVolume);
  }

}
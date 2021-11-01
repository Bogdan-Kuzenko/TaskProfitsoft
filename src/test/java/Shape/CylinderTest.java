package Shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CylinderTest {

  @Test
  void zeroRadius() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cylinder(0.0, 2.0));
  }

  @Test
  void negativeRadius() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cylinder(-1.0, 2.0));
  }

  @Test
  void zeroHeight() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cylinder(2.0, 0.0));
  }

  @Test
  void negativeHeight() {
    Assertions.assertThrows(RuntimeException.class, () -> new Cylinder(2.0, -1.0));
  }

  @Test
  void calcVolume() {
    Cylinder c = new Cylinder(2.0, 3.0);
    Double cVolume = c.calcVolume();
    Double expect = (22 * 2.0 * 2.0 * 3.0) / 7;
    Assertions.assertEquals(expect, cVolume);
  }
}
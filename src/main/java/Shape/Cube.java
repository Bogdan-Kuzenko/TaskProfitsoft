package Shape;

public class Cube extends Shape {
  private Double side;

  public Cube(Double side) {
    this.side = side;
  }

  @Override
  public String toString() {
    return "Cube{" +
        "side=" + side +
        ", volume= " + calcVolume() +
        '}';
  }

  @Override
  public Double calcVolume() {
    return  side * side * side;
  }
}

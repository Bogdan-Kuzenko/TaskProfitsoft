package trafficViolation;

import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Violation {
  private Instant date;
  private String firstName;
  private String lastnameName;
  private Type type;
  private Double fineAmount;

  public enum Type {
    SPEEDING,
    RED_LIGHT,
    DRUNK_DRIVER,
    EXPIRED_DRIVER_LICENSE

  }
}

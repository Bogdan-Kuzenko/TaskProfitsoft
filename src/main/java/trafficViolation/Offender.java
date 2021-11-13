package trafficViolation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Offender {
  private String firstName;
  private String lastName;
  private Long countFines;
  private Double amountFines;
  private Double averageAmount;
}

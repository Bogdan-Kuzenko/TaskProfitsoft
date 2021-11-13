package trafficViolation;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ViolatorsService {

  private static final FileWriter FILE_WRITER = new FileWriter();

  public void getFileWithAmountFinesByType(List<Violation> list) {
    Map<Violation.Type, Double> countedViolence = list.stream()
        .collect(Collectors
            .groupingBy(Violation::getType, Collectors.summingDouble(Violation::getFineAmount)));
    LinkedHashMap<Violation.Type, Double> result = countedViolence.entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(
            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    String fileName = "src\\reports\\"
        .concat("violations")
        .concat("_")
        .concat(LocalDate.now().toString())
        .concat(".json");

    FILE_WRITER.setFullFileName(fileName);
    FILE_WRITER.setDataForWriting(result);
    FILE_WRITER.writeData();
  }

  public void getOffendersStatistic(List<Violation> list) {
    Set<Offender> offenders = new HashSet<>();
    for (Violation v : list) {
      Offender offender = new Offender();

      offender.setFirstName(v.getFirstName());
      offender.setLastName(v.getLastnameName());
      offender.setCountFines(list.stream()
          .filter(e -> ((e.getLastnameName().equals(offender.getLastName())
              && (e.getFirstName().equals(offender.getFirstName())))))
          .count());
      offender.setAmountFines(list.stream()
          .filter(e -> ((e.getLastnameName().equals(offender.getLastName())
              && (e.getFirstName().equals(offender.getFirstName())))))
          .mapToDouble(Violation::getFineAmount)
          .sum());
      offender.setAverageAmount(list.stream()
          .filter(e -> ((e.getLastnameName().equals(offender.getLastName())
              && (e.getFirstName().equals(offender.getFirstName())))))
          .collect(Collectors.averagingDouble(Violation::getFineAmount)));

      offenders.add(offender);
    }

    String fileName = "src\\reports\\"
        .concat("offenders")
        .concat("_")
        .concat(LocalDate.now().toString())
        .concat(".json");

    FILE_WRITER.setFullFileName(fileName);
    FILE_WRITER.setDataForWriting(offenders);
    FILE_WRITER.writeData();
  }

}

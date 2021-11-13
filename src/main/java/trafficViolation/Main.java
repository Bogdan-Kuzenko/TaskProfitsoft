package trafficViolation;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    ViolatorsService violatorsService = new ViolatorsService();
    String folderPath = "src\\files";
    List<Violation> list = MultithreadedFilesReader.readDataFromFiles(folderPath);
    violatorsService.getFileWithAmountFinesByType(list);
    violatorsService.getOffendersStatistic(list);

  }
}

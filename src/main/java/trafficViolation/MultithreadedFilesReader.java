package trafficViolation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedFilesReader {

  public static List<Violation> readDataFromFiles(String folderPath) {

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<FileReader> list = new ArrayList<>();
    List<Violation> result = new ArrayList<>();

    File file = new File(folderPath);
    File[] listOfFiles = {};
    if (file.isDirectory()) {
      listOfFiles = file.listFiles();
    }
    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        list.add(new FileReader(listOfFile.getAbsolutePath()));
      }

      for (FileReader fileReader : list) {
        try {
          result.addAll(executorService.submit(fileReader).get());
        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      }
    }
    executorService.shutdown();

    return result;
  }
}


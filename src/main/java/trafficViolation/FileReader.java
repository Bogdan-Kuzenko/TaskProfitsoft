package trafficViolation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileReader implements Callable<List<Violation>> {

  private String fileName;

  @Override
  public List<Violation> call() {
    List<Violation> result = new ArrayList<>();
    ObjectMapper mapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();
    File file = new File(this.fileName);
    try {
      result = mapper.readValue(file, new TypeReference<List<Violation>>() {
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;

  }
}


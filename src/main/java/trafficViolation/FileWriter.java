package trafficViolation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileWriter {

  private String fullFileName;
  private Object dataForWriting;
  private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm");


  public void writeData() {
    ObjectMapper mapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();
    mapper.setDateFormat(DATE_FORMAT);
    File file = new File(this.fullFileName);
    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, this.dataForWriting);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

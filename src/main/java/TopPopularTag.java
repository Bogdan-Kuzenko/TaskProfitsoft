import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TopPopularTag {
  private final static Integer LIMIT_FOR_TOP = 5;

  public LinkedHashMap<String, Integer> findTopPopularHashtag(List<String> texts) {
    Map<String, Integer> map = new LinkedHashMap<>();

    String regex = "(\\#\\w+\\b)(?!.*\\1\\b)";
    Pattern p = Pattern.compile(regex);

    for (String s : texts) {
      Matcher m = p.matcher(s);
      while (m.find()) {
        if (map.containsKey(m.group())) {
          Integer integer = map.get(m.group());
          map.put(m.group(), ++integer);
        } else if (!map.containsKey(m.group())) {
          map.put(m.group(), 1);
        }
      }
    }

    return map.entrySet()
        .stream()
        .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
        .limit(LIMIT_FOR_TOP)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1, LinkedHashMap::new));


  }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

class TopPopularTagTest {
  TopPopularTag topPopularTag;
  List<String> texts;
  LinkedHashMap<String, Integer> resultTrue;

  @BeforeEach
  void setup() {
    topPopularTag = new TopPopularTag();

    texts = Arrays.asList(
        "dog #cat #cat",
        "#giraffe #giraffe #giraffe #giraffe #giraffe #giraffe",
        "#dog cat #cat #frog",
        "dog #cat #cat #frog #frog #frog #frog #frog #frog #frog #frog #frog",
        "#dog cat cat frog #giraffe",
        "#dog, #dog",
        "dog #cat #cat",
        "#monkey monkey",
        "#crocodaile giraffe",
        "#mouse mouse");

    resultTrue = new LinkedHashMap<>();
    resultTrue.put("#cat", 4);
    resultTrue.put("#dog", 3);
    resultTrue.put("#giraffe", 2);
    resultTrue.put("#frog", 2);
    resultTrue.put("#monkey", 1);
  }

  @AfterEach
  void clean() {
    topPopularTag = null;
    texts = null;
    resultTrue = null;
  }

  @Test
  void findTopPopularHashtag() {
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(texts);
    Assertions.assertNotEquals(texts, topPopularHashtag);
  }

  @Test
  void findTop3PopularHashtag() {
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(texts);
    Assertions.assertEquals(resultTrue, topPopularHashtag);
  }
}
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopPopularTagTest {
  TopPopularTag topPopularTag;
  List<String> texts;
  List<String> textsWithDefects;
  LinkedHashMap<String, Integer> resultTrue;
  LinkedHashMap<String, Integer> resultFalse;

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
    textsWithDefects = Arrays.asList(
        "dog #cat #cat",
        "#giraffe #giraffe #giraffe #giraffe #giraffe #giraffe",
        "#dog cat #cat #frog",
        "dog #cat #cat #frog #frog #frog #frog #frog #frog #frog #frog #frog",
        "#dog cat ca#t frog #giraffe",
        "#dog, #dog",
        "",
        null,
        "dog ca#t ca#t frog gira#ffe",
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

    resultFalse = new LinkedHashMap<>();
    resultFalse.put("#cat", 2);
    resultFalse.put("#dog", 3);
    resultFalse.put("#frog", 1);
    resultFalse.put("#giraffe", 2);
    resultFalse.put("#frog", 5);

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
    Assertions.assertEquals(resultTrue, topPopularHashtag);
  }

  @Test
  void findTopPopularHashtagNotEquals() {
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(texts);
    Assertions.assertNotEquals(resultFalse, topPopularHashtag);
  }

  @Test
  void emptyList() {
    LinkedHashMap<String, Integer> text = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(Collections.emptyList());
    Assertions.assertEquals(text, topPopularHashtag);
  }

  @Test
  void setTextsWithEmptyString() {
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(textsWithDefects);
    Assertions.assertEquals(resultTrue, topPopularHashtag);
  }

  @Test
  void nullCheck(){
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(null);
    Assertions.assertEquals(new LinkedHashMap<String, Integer>(), topPopularHashtag);
  }

  @Test
  void oneStringNull(){
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(textsWithDefects);
    Assertions.assertEquals(resultTrue, topPopularHashtag);
  }

  @Test
  void hashtagSymbolInsideWord(){
    LinkedHashMap<String, Integer> topPopularHashtag = topPopularTag.findTopPopularHashtag(textsWithDefects);
    Assertions.assertEquals(resultTrue, topPopularHashtag);
  }


}
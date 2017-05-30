package info.sliceoflife.powermock;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class UtilityClass {

  static int staticMethod(final long value) {
    // Some complex logic is done here...
    throw new RuntimeException(
        "I dont want to be executed. I will anyway be mocked out.");
  }
}

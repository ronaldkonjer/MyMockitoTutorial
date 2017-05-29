/*
 *
 */
package info.sliceoflife.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

  StringHelper helper = new StringHelper();

  private final String input;
  private final String expected;

  /**
   * @param input
   * @param expected
   */
  public StringHelperParameterizedTest(final String input, final String expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameters
  public static Collection<String[]> testConditions() {
    final String expectedOutputs[][] = {{"AACD", "CD"},
        {"ACD", "CD"}};
    return Arrays.asList(expectedOutputs);
  }

  // parameterized test
  @Test
  public void testTruncateAInFirst2Positions_AInFirst2Positions() {
    assertEquals(expected, helper.truncateAInFirst2Positions(input));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSameWhereStringABCD() {
    assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSameWhereStringABAB() {
    assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSameWhereStringAB() {
    assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSameWhereStringA() {
    assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
  }

}

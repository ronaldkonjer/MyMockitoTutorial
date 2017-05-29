/*
 *
 */
package info.sliceoflife.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class StringHelperTest {

  StringHelper helper;

  @Before
  public void setup() {
    helper = new StringHelper();
  }

  @Test
  public void testTruncateAInFirst2Positions_AInFirst2Positions() {
    assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
  }

  @Test
  public void testTruncateAInFirst2Positions_AInFirstPosition() {
    assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
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

  @After
  public void teardown() {

  }

}

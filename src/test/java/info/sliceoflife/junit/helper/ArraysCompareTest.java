/*
 *
 */
package info.sliceoflife.junit.helper;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class ArraysCompareTest {

  @Test
  public void testArraySort_RandomArray() {
    final int[] numbers = {12, 3, 4, 1};
    final int[] expected = {1, 3, 4, 12};
    Arrays.sort(numbers);
    assertArrayEquals(expected, numbers);

  }

  @Test(expected = NullPointerException.class)
  public void testArraySort_NullArray() {
    final int[] numbers = null;
    Arrays.sort(numbers);
  }

  @Test(timeout = 100)
  public void testSort_Performance() {
    final int array[] = {12, 23, 4};
    for (int i = 1; i <= 1000000; i++) {
      array[0] = i;
      Arrays.sort(array);
    }

  }

}

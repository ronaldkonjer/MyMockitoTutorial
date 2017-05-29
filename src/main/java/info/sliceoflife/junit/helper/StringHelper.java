/*
 *
 */
package info.sliceoflife.junit.helper;

/**
 * A helper class for String Methods
 *
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class StringHelper {

  public String truncateAInFirst2Positions(final String str) {
    if (str.length() <= 2)
      return str.replaceAll("A", "");

    final String first2Chars = str.substring(0, 2);
    final String stringMinusFirst2Char = str.substring(2);

    return first2Chars.replaceAll("A", "") + stringMinusFirst2Char;
  }

  public boolean areFirstAndLastTwoCharactersTheSame(final String str) {
    if (str.length() <= 1)
      return false;
    if (str.length() == 2)
      return true;

    final String first2Chars = str.substring(0, 2);

    final String last2Chars = str.substring(str.length() - 2);

    return first2Chars.equals(last2Chars);
  }

}

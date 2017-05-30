/*
 *
 */
package info.sliceoflife.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class SpyTest {

  @Test
  public void testMock() {
    final List arrayListMock = mock(ArrayList.class);
    // mocks return default value
    when(arrayListMock.size()).thenReturn(5);
    // value is not added to the arrayListMock so test still passes
    arrayListMock.add("Dummy");
    assertEquals(5, arrayListMock.size());
  }

  @Test
  public void testSpy() {
    final List arrayListSpy = spy(ArrayList.class);
    assertEquals(0, arrayListSpy.size());
    arrayListSpy.add("Dummy");
    assertEquals(1, arrayListSpy.size());
    arrayListSpy.remove("Dummy");
    assertEquals(0, arrayListSpy.size());
  }

  @Test
  public void testSpyOverride() {
    final List arrayListSpy = spy(ArrayList.class);
    // Override only the size() method
    when(arrayListSpy.size()).thenReturn(5);
    assertEquals(5, arrayListSpy.size());
  }

  @Test
  public void testSpyAssertMethodIsCalled() {
    final List arrayListSpy = spy(ArrayList.class);
    arrayListSpy.add("Dummy");
    verify(arrayListSpy).add("Dummy");
    then(arrayListSpy).should(never())
        .clear();
  }

}

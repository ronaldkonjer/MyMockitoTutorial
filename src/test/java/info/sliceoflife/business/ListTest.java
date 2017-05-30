/*
 *
 */
package info.sliceoflife.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class ListTest {

  @Test
  public void testMockListSizeMethod() {
    // Given
    final List listMock = mock(List.class);

    when(listMock.size()).thenReturn(2);
    // When

    // Then
    assertEquals(2, listMock.size());
    assertEquals(2, listMock.size());
    assertEquals(2, listMock.size());
  }

  @Test
  public void testMockListSizeMethod_ReturnMultipleValues() {
    final List listMock = mock(List.class);
    when(listMock.size()).thenReturn(2)
        .thenReturn(3);
    assertEquals(2, listMock.size());
    assertEquals(3, listMock.size());

  }

  @Test
  public void testMockListGetMethod() {
    final List listMock = mock(List.class);
    when(listMock.get(anyInt())).thenReturn("Slice of Life");
    assertEquals("Slice of Life", listMock.get(0));
    assertEquals("Slice of Life", listMock.get(1));

  }

  @Test
  public void testMockListGetMethodBDD() {
    // Given
    final List<String> listMock = mock(List.class);
    given(listMock.get(anyInt())).willReturn("Slice of Life");

    // When
    final String firstElement = listMock.get(0);

    // Then
    assertThat(firstElement, is("Slice of Life"));
  }

  @Test(expected = RuntimeException.class)
  public void testMockList_throwAnException() {
    final List listMock = mock(List.class);
    when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
    listMock.get(0);

  }

}

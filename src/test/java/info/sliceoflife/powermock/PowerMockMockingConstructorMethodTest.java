/*
 *
 */
package info.sliceoflife.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test using PowerMock to mock a static method
 *
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
// Specific runner
@RunWith(PowerMockRunner.class)
// Initialize
@PrepareForTest(SystemUnderTest.class)
public class PowerMockMockingConstructorMethodTest {

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Mock
  ArrayList mockList;

  @Test
  public void testRetrieveAllStats_usingPowerMockConstructor() throws Exception {
    final List<Integer> stats = Arrays.asList(1, 2, 3);

    when(mockList.size()).thenReturn(10);

    PowerMockito.whenNew(ArrayList.class)
        .withAnyArguments()
        .thenReturn(mockList);

    final int size = systemUnderTest.methodUsingAnArrayListConstructor();

    assertEquals(10, size);

  }

}

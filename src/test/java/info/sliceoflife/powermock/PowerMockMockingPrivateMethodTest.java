/*
 *
 */
package info.sliceoflife.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Test using PowerMock to mock a static method
 *
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
// Specific runner
@RunWith(PowerMockRunner.class)
// Initialize
/* @PrepareForTest(UtilityClass.class) */
public class PowerMockMockingPrivateMethodTest {

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void testRetrieveAllStats_usingPowerMockPrivate() throws Exception {
    final List<Integer> stats = Arrays.asList(1, 2, 3);

    when(dependency.retrieveAllStats()).thenReturn(stats);

    // call private method
    final long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");

    assertEquals(6, result);

  }

}

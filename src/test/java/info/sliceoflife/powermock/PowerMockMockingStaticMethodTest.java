/*
 *
 */
package info.sliceoflife.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
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
@PrepareForTest(UtilityClass.class)
public class PowerMockMockingStaticMethodTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  Dependency dependency;

  @InjectMocks
  SystemUnderTest systemUnderTest;

  @Test
  public void testRetrieveAllStats_usingPowerMockStatic() {
    final List<Integer> stats = Arrays.asList(1, 2, 3);

    when(dependency.retrieveAllStats()).thenReturn(stats);

    // Mock
    PowerMockito.mockStatic(UtilityClass.class);

    when(UtilityClass.staticMethod(6)).thenReturn(150);

    final int result = systemUnderTest.methodCallingAStaticMethod();

    assertEquals(150, result);

    // Verify that static method is called with PowerMock
    PowerMockito.verifyStatic();
    UtilityClass.staticMethod(6);

  }

}

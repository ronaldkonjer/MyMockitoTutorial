package info.sliceoflife.powermock;

import java.util.ArrayList;
import java.util.List;

interface Dependency {

  List<Integer> retrieveAllStats();
}


/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */

public class SystemUnderTest {

  private Dependency dependency;

  public int methodUsingAnArrayListConstructor() {
    final ArrayList list = new ArrayList();
    return list.size();
  }

  public int methodCallingAStaticMethod() {
    // privateMethodUnderTest calls static method SomeClass.staticMethod
    final List<Integer> stats = dependency.retrieveAllStats();
    long sum = 0;
    for (final int stat : stats)
      sum += stat;
    return UtilityClass.staticMethod(sum);
  }

  private long privateMethodUnderTest() {
    final List<Integer> stats = dependency.retrieveAllStats();
    long sum = 0;
    for (final int stat : stats)
      sum += stat;
    return sum;
  }
}

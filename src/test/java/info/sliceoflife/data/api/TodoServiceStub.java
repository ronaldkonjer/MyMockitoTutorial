/*
 *
 */
package info.sliceoflife.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class TodoServiceStub implements TodoService {

  @Override
  public List<String> retrieveTodos(final String user) {
    return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
  }

  /*
   * (non-Javadoc)
   * 
   * @see info.sliceoflife.data.api.TodoService#deleteTodo(java.lang.String)
   */
  @Override
  public void deleteTodo(final String todo) {
    // TODO Auto-generated method stub

  }

}

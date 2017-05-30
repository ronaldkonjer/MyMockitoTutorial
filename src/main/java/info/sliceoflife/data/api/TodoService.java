/*
 *
 */
package info.sliceoflife.data.api;

import java.util.List;

/**
 * Todo service
 *
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public interface TodoService {

  List<String> retrieveTodos(String user);

  void deleteTodo(String todo);

}

/*
 *
 */
package info.sliceoflife.business;

import info.sliceoflife.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ToDoService
 *
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class TodoBusinessImpl {

  private final TodoService todoService;

  /**
   * @param todoService
   */
  public TodoBusinessImpl(final TodoService todoService) {
    this.todoService = todoService;
  }

  public List<String> retrieveTodoRelatedToSpring(final String user) {
    final List<String> filteredTodos = new ArrayList<String>();
    final List<String> todos = todoService.retrieveTodos(user);

    for (final String todo : todos) {
      if (todo.contains("Spring")) {
        filteredTodos.add(todo);
      }
    }
    return filteredTodos;
  }

  public void deleteTodoNotRelatedToSpring(final String user) {
    final List<String> filteredTodos = new ArrayList<String>();
    final List<String> todos = todoService.retrieveTodos(user);

    for (final String todo : todos) {
      if (!todo.contains("Spring")) {
        todoService.deleteTodo(todo);
        ;
      }
    }
  }

}

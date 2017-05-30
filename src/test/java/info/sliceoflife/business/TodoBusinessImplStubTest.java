/*
 *
 */
package info.sliceoflife.business;

import static org.junit.Assert.assertEquals;

import info.sliceoflife.data.api.TodoService;
import info.sliceoflife.data.api.TodoServiceStub;

import java.util.List;

import org.junit.Test;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class TodoBusinessImplStubTest {

  @Test
  public void testRetrieveTodosRelatedToSpring_usingAStub() {
    final TodoService todoServiceStub = new TodoServiceStub();
    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
    final List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
    assertEquals(2, filteredTodos.size());
  }
}

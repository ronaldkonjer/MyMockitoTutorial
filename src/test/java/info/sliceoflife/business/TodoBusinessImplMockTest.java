/*
 *
 */
package info.sliceoflife.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import info.sliceoflife.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */
public class TodoBusinessImplMockTest {

  @Test
  public void testRetrieveTodosRelatedToSpring_usingAMock() {
    final TodoService todoServiceMock = mock(TodoService.class);
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    final List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
    assertEquals(2, filteredTodos.size());
  }

  @Test
  public void testRetrieveTodosRelatedToSpring_usingBDD() {

    // Given
    final TodoService todoServiceMock = mock(TodoService.class);
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    // When
    final List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

    // Then
    assertThat(filteredTodos.size(), is(2));
  }

  @Test
  public void testDeleteTodosNotRelatedToSpring_usingBDD() {

    // Given
    final TodoService todoServiceMock = mock(TodoService.class);
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    // When
    todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

    // Then
    verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
    then(todoServiceMock).should()
        .deleteTodo("Learn to Dance");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    then(todoServiceMock).should(never())
        .deleteTodo("Learn Spring MVC");
    verify(todoServiceMock, never()).deleteTodo("Learn Spring");

  }

  public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

    // Declare Argument Captor
    final ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    // Define Argument Captor on specific method call

    // Captor the argument

    // Given
    final TodoService todoServiceMock = mock(TodoService.class);
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    // When
    todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

    // Then
    then(todoServiceMock).should()
        .deleteTodo(argumentCaptor.capture());
    assertThat(argumentCaptor.getValue(), is("Learn to Dance"));

  }

  @Test
  public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {

    // Declare Argument Captor
    final ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
    // Define Argument Captor on specific method call

    // Captor the argument

    // Given
    final TodoService todoServiceMock = mock(TodoService.class);
    final List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");

    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    final TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    // When
    todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

    // Then
    then(todoServiceMock).should(times(2))
        .deleteTodo(argumentCaptor.capture());
    assertThat(argumentCaptor.getAllValues()
        .size(), is(2));

  }

}

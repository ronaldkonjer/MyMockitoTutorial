/*
 *
 */
package info.sliceoflife.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import info.sliceoflife.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author ronaldkonjer (ronaldkonjer@gmail.com)
 */

public class TodoBusinessImplMockitoInjectMockTest {

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  TodoService todoServiceMock;

  @InjectMocks
  TodoBusinessImpl todoBusinessImpl;

  @Captor
  ArgumentCaptor<String> argumentCaptor;

  @Test
  public void testRetrieveTodosRelatedToSpring_usingAMock() {
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

    final List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
    assertEquals(2, filteredTodos.size());
  }

  @Test
  public void testRetrieveTodosRelatedToSpring_usingBDD() {

    // Given
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    // When
    final List<String> filteredTodos = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");

    // Then
    assertThat(filteredTodos.size(), is(2));
  }

  @Test
  public void testDeleteTodosNotRelatedToSpring_usingBDD() {

    // Given
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

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

    // Given
    final List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    // When
    todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

    // Then
    then(todoServiceMock).should()
        .deleteTodo(argumentCaptor.capture());
    assertThat(argumentCaptor.getValue(), is("Learn to Dance"));

  }

  @Test
  public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {

    // Given
    final List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
    given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

    // When
    todoBusinessImpl.deleteTodoNotRelatedToSpring("Dummy");

    // Then
    then(todoServiceMock).should(times(2))
        .deleteTodo(argumentCaptor.capture());
    assertThat(argumentCaptor.getAllValues()
        .size(), is(2));

  }

}

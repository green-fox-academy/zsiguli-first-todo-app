import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToDoListTest {

  @Test
  public void testToDoListConstructor_withoutArgs() {
    List<String> thingsToDo = new ArrayList<>();
    ToDoList toDoList = new ToDoList();
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testToDoListConstructor_withOneGivenString() {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("[ ] Buy milk");
    ToDoList toDoList = new ToDoList("Buy milk");
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testToDoListConstructor_withStringList() {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("Buy milk");
    thingsToDo.add("Do homework");
    ToDoList toDoList = new ToDoList(thingsToDo);
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testReadFromFile() {
    ToDoList toDoList = new ToDoList();
    List<String> thingsToDo = ToDoList.getListFromFile();
    Path path = Paths.get("assets/store.csv");
    List<String> listFromFile;
    try {
      listFromFile = Files.readAllLines(path);
    } catch (IOException e) {
      listFromFile = new ArrayList<>();
      e.printStackTrace();
    }
    assertEquals(thingsToDo, listFromFile);
  }

  @Test
  public void testAddTask() throws Exception {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("[ ] Buy milk");
    ToDoList toDoList = new ToDoList("Buy milk");
    thingsToDo.add("[ ] Do homework");
    toDoList.addTask("Do homework");
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testCheckTask() throws Exception {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("[ ] Buy milk");
    thingsToDo.add("[x] Do homework");
    ToDoList toDoList = new ToDoList("Buy milk");
    toDoList.addTask("Do homework");
    toDoList.checkTask(2);
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testCheckTask_onReadyTask() throws Exception {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("[ ] Buy milk");
    thingsToDo.add("[x] Do homework");
    ToDoList toDoList = new ToDoList("Buy milk");
    toDoList.addTask("Do homework");
    toDoList.checkTask(2);
    toDoList.checkTask(2);
    assertEquals(toDoList.getList(), thingsToDo);
  }

  @Test
  public void testRemoveTask() throws Exception {
    List<String> thingsToDo = new ArrayList<>();
    thingsToDo.add("[ ] Buy milk");
    ToDoList toDoList = new ToDoList("Buy milk");
    toDoList.addTask("Do homework");
    toDoList.removeTask(2);
    assertEquals(toDoList.getList(), thingsToDo);
  }
}

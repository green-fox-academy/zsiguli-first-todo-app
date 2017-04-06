import java.util.List;

public class ToDoList {
  private List<String> thingsToDo;

  public ToDoList(List<String> thingsToDo) {
    this.thingsToDo = thingsToDo;
  }

  public void addTask(String newTask) {
    thingsToDo.add(newTask + ";[ ]");
  }

  public void checkTask(int numberOfTask) {
    thingsToDo.get(numberOfTask - 1).replace("[ ]", "[x]");
  }

  public void removeTask(int numberOfTask) {
    thingsToDo.remove(numberOfTask - 1);
  }
}
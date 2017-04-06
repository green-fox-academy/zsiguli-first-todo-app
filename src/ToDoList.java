import java.util.ArrayList;
import java.util.List;

public class ToDoList {

  private List<String> thingsToDo;

  public ToDoList() {
    thingsToDo = new ArrayList<>();
  }

  public ToDoList(String thingToDo) {
    thingsToDo = new ArrayList<>();
    thingsToDo.add(thingToDo);
  }

  public ToDoList(List<String> thingsToDo) {
    this.thingsToDo = thingsToDo;
  }

  public List<String> getList() {
    return thingsToDo;
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

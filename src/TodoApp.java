import java.util.List;

public class TodoApp {
  public static void main(String[] args) {
    List<String> listFromFile = ToDoList.getListFromFile();
    ToDoList thingsToDo = new ToDoList(listFromFile);
    thingsToDo.addTask("try it again");
    thingsToDo.printTasks();
    ToDoList.writeListToFile(thingsToDo.getList());
  }
}

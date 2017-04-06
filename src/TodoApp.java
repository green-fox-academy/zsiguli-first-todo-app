import java.util.List;

public class TodoApp {
  public static void main(String[] args) {
    List<String> listFromFile = ToDoList.getListFromFile();
    ToDoList toDoList = new ToDoList(listFromFile);
    toDoList.addTask("try it again");
    ToDoList.writeListToFile(toDoList.getList());
  }
}

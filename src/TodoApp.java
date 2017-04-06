import java.util.List;

public class TodoApp {
  public static void main(String[] args) {
    List<String> listFromFile = ToDoList.getListFromFile();
    ToDoList thingsToDo = new ToDoList(listFromFile);

    if (args.length == 0) {
      System.out.println("Try it again");
    } else {
      switch (args[0]) {
        case "-l":
          thingsToDo.printTasks();
          break;
        case "-a":
          thingsToDo.addTask(args[1]);
          thingsToDo.printTasks();
          break;
        case "-r":
          thingsToDo.removeTask(Integer.parseInt(args[1]));
          thingsToDo.printTasks();
          break;
        case "-c":
          thingsToDo.checkTask(Integer.parseInt(args[1]));
          thingsToDo.printTasks();
          break;
      }
    }
    ToDoList.writeListToFile(thingsToDo.getList());
  }
}

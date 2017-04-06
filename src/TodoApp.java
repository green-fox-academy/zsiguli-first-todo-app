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
          System.out.println("these are the things");
          break;
        case "-a":
          System.out.println("a");
          thingsToDo.addTask(args[1]);
          break;
        case "-r":
          System.out.println("r");
          thingsToDo.removeTask(Integer.parseInt(args[1]));
          break;
        case "-c":
          System.out.println("c");
          thingsToDo.checkTask(Integer.parseInt(args[1]));
          break;
      }
    }
    thingsToDo.printTasks();
    ToDoList.writeListToFile(thingsToDo.getList());
  }
}

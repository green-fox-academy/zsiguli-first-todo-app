import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {
  public static void main(String[] args) {
    Path path = Paths.get("assets/test.csv");
    List<String> lines;
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      lines = new ArrayList<>();
      System.out.println("Oops");
    }
    ToDoList toDoList = new ToDoList(lines);
    toDoList.addTask("new task");
    try {
      Files.write(path, toDoList.getList());
    } catch (IOException e) {
      System.out.println("Oops again");
    }
  }
}

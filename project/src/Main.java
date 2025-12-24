import repository.TaskRepository;
import service.TaskService;
import ui.ConsoleMenu;


public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);
        ConsoleMenu menu = new ConsoleMenu(service);


    }
}
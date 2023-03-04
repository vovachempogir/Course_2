package Task;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap();
    private final Set<Task> removedTasks = new HashSet();

    public TaskService() {
    }

    public void add(Repeatability taskPeriodicity) throws DescriptionField {
        Task tp = taskPeriodicity.createTask();
        tp.askData();
        this.taskMap.putIfAbsent(tp.getId(), tp);
        System.out.println("Задача создана: " + tp);
    }

    public void remove(int id) {
        Task task = (Task)this.taskMap.get(id);
        this.removedTasks.add(task);
        this.taskMap.values().removeIf((t) -> {
            return t.getId() == id;
        });
        System.out.printf("Задача '%s' удалена  \n", task);
    }

    public void listTaskMap() {
        System.out.println("Актуальный список задач: ");
        Iterator var1 = this.taskMap.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<Integer, Task> taskMap = (Map.Entry)var1.next();
            PrintStream var10000 = System.out;
            Object var10001 = taskMap.getKey();
            var10000.println("" + var10001 + " " + taskMap.getValue());
        }

    }

    public void findTask(String substr) {
        String tmp = substr.toLowerCase();
        Stream var10000 = this.taskMap.values().stream().filter((task) -> {
            return task.contains(tmp);
        });
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }
}

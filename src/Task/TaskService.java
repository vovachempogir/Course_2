package Task;

import java.io.PrintStream;
import java.time.LocalDate;
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

    public void add(Repeatability taskPeriodicity) throws IncorrectArgumentException {
        Task tp = taskPeriodicity.createTask();
        tp.askData();
        this.taskMap.putIfAbsent(tp.getId(), tp);
        System.out.println("Задача создана: " + tp);
    }

    public void getAllByDate(LocalDate localDate) throws TaskNotFoundException {
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            LocalDate taskDate = taskMap.getValue().getDateTime().toLocalDate();
            if (((LocalDate) taskDate).equals(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            }
            else if (localDate.isAfter(taskDate) && taskMap.getValue().appearsIn(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            } else throw new TaskNotFoundException("На эту дату нет ни одной задачи ");
        }
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

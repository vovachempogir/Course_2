package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private Type type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;

    public Task() {
        ++idGenerator;
        this.id = idGenerator;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Task task = (Task)o;
            return this.id == task.id && Objects.equals(this.title, task.title) && this.type == task.type && Objects.equals(this.dateTime, task.dateTime) && Objects.equals(this.description, task.description);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.title, this.type, this.id, this.dateTime, this.description});
    }

    public String toString() {
        return String.format("id: %d, тип: %s, заголовок: %s, описание: %s, Дата и время: %s", this.id, this.type, this.title, this.description, InputUtils.dateTimeToString(this.dateTime));
    }

    public void askData() throws DescriptionField {
        System.out.println("выберите тип задачи:");
        Type[] var1 = Type.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Type taskType = var1[var3];
            System.out.println(taskType);
        }

        this.type = Type.valueOf(InputUtils.askString("Ваш выбор").toUpperCase());
        this.title = InputUtils.askString("название");
        if (this.title != null && !this.title.isBlank() && !this.title.isEmpty()) {
            this.description = InputUtils.askString("Введите описание");
            if (this.description != null && !this.description.isBlank() && !this.description.isEmpty()) {
                this.dateTime = InputUtils.askDateTime();
            } else {
                throw new DescriptionField("Введите правильное описание");
            }
        } else {
            throw new DescriptionField("Введите правильный заголовок");
        }
    }

    public boolean contains(String substr) {
        String strId = String.valueOf(this.id);
        String strType = String.valueOf(this.type);
        return strId.contains(substr) || this.title.toLowerCase().contains(substr) || strType.toLowerCase().contains(substr) || InputUtils.dateTimeToString(this.dateTime).toLowerCase().contains(substr) || this.description.toLowerCase().contains(substr);
    }

    public abstract boolean appearsIn(LocalDate var1);
}

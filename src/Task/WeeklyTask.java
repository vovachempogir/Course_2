package Task;

import java.time.LocalDate;

public class WeeklyTask extends Task {
    public WeeklyTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(this.getDateTime().toLocalDate().getDayOfWeek());
    }
}

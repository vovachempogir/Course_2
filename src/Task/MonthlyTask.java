package Task;

import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == this.getDateTime().toLocalDate().getDayOfMonth();
    }
}
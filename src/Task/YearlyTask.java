package Task;

import java.time.LocalDate;

public class YearlyTask extends Task {
    public YearlyTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfYear() == this.getDateTime().toLocalDate().getDayOfYear();
    }
}

package Task;

import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return true;
    }
}

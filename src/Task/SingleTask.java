package Task;

import java.time.LocalDate;

public class SingleTask extends Task {
    public SingleTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate());
    }
}

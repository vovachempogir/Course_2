package Task;

import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask() {
    }

    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getDateTime().toLocalDate());
    }
}

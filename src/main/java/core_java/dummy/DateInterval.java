package core_java.dummy;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {
    @Override
    public void setSecond(LocalDate second) {
        if (getFirst().compareTo(second) <= 0) {
            super.setSecond(second);
        }
    }

    public DateInterval() {
        setFirst(LocalDate.now());
        setSecond(LocalDate.now());
    }
}

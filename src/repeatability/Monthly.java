package repeatability;

import TypeTask.TypesTask;
import task.Task;

import java.time.LocalDateTime;
import java.util.Objects;

public class Monthly extends Task implements Time {
    private LocalDateTime time;

    private final static String exception = "Не правильно выбрано время";

    private final static String monthly = "ежемесячная";

    public Monthly(String title, String description, TypesTask typesTasks,LocalDateTime time) {
        super(title, description, typesTasks);
        setTime(time);
    }

    @Override
    public LocalDateTime getNextTime() {
        return time.plusMonths(1);
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return monthly + getTitle() + " " + getDescription() + " " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monthly)) return false;
        if (!super.equals(o)) return false;
        Monthly monthly = (Monthly) o;
        return Objects.equals(time, monthly.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}

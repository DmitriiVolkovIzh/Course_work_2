package repeatability;

import TypeTask.TypesTask;
import task.Task;

import java.time.LocalDateTime;
import java.util.Objects;

public class Yearly extends Task implements Time {
    private LocalDateTime time;

    private final static String exception = "Не правильно выбрано время";

    private final static String yearly = "ежегодная";

    public Yearly(String title, String description, TypesTask typesTasks,LocalDateTime time) {
        super(title, description, typesTasks);
        setTime(time);
    }
    public void setTime(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now()))
            throw new RuntimeException(exception);
        else this.time = time;
    }
    @Override
    public LocalDateTime getNextTime() {
        return time.plusYears(1);
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return  yearly + getTitle() + " " + getDescription() + " " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Yearly)) return false;
        if (!super.equals(o)) return false;
        Yearly yearly = (Yearly) o;
        return Objects.equals(time, yearly.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}

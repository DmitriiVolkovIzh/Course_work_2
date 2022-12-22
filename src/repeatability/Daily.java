package repeatability;

import TypeTask.TypesTask;
import task.Task;

import java.time.LocalDateTime;
import java.util.Objects;

public class Daily extends Task implements Time {

    private LocalDateTime time;

    private final static String exception = "Не правильно выбрано время";

    private final static String daily = "ежедневная";

    public Daily(String title, String description, TypesTask typesTask, LocalDateTime time) {
        super(title, description, typesTask);
        setTime(time);
    }
    public void setTime(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now()))
            throw new RuntimeException(exception);
        else this.time = time;
    }
    @Override
    public LocalDateTime getNextTime() {
        return time.plusDays(1);
    }
    @Override
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return daily + getTitle() + " " + getDescription() + " " + time;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Daily daily = (Daily) o;
        return Objects.equals(time, daily.time);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}


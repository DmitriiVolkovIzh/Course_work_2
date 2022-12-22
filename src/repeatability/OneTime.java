package repeatability;

import TypeTask.TypesTask;
import task.Task;

import java.time.LocalDateTime;
import java.util.Objects;

public class OneTime extends Task {

    private LocalDateTime time;

    private final static String exception = "Не правильно выбрано время";

    private final static String oneTime = "разовая";

    public OneTime(String title, String description, TypesTask typesTasks,LocalDateTime time) {
        super(title, description, typesTasks);
        setTime(time);
    }
    public void setTime(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now()))
            throw new RuntimeException(exception);
        else this.time = time;
    }
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return oneTime + getTitle() + " " + getDescription() + " " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneTime)) return false;
        if (!super.equals(o)) return false;
        OneTime oneTime = (OneTime) o;
        return Objects.equals(time, oneTime.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTime());
    }
}

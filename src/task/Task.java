package task;

import TypeTask.TypesTask;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public abstract class Task {
    private String title;

    private String description;

    private final int id;

    private static int count = 1;

    private LocalDateTime time;

    private TypesTask personalWorking;

    private boolean deleted;

    private static final String personal = "личная";

    private static final String working = "рабочая";

    public Task(String title, String description, TypesTask typesTasks){
        setTitle(title);
        setDescription(description);
        this.id = count++;
        personalWorking = typesTasks;
        setDeleted(false);
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public String getInfo(){
        return getTitle() + " " + getDescription();
    }
    public long getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getTime(){
        return time;
    }
    public TypesTask getPersonalOrWorking(){
        return personalWorking;
    }
    public void setPersonalOrWorking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите задачу: 1." + personal
                + "; 2 " + working);
        int type = scanner.nextInt();
        if(type != 1) personalWorking = TypesTask.WORKING;
        else personalWorking = TypesTask.PERSONAL;
    }
    public void setTime(LocalDateTime time){
        this.time = time;
    }
    public void setDescription(String description) {
        if(description == null || description.isEmpty()) this.description = "Описание"; else this.description = description;
    }
    public void setTitle(String title) {
        if(title == null || title.isEmpty()) this.title = "Заголовок"; else this.title = title;
    }
    @Override
    public String toString() {
        return title + " " + description + " " + personalWorking;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) && Objects.equals(deleted, task.deleted);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, description, id, deleted);
    }
}



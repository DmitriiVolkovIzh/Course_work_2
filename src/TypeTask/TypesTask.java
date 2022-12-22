package TypeTask;

public enum TypesTask {
    PERSONAL("личная"), WORKING("рабочая");
    private String type;
    TypesTask(String type){
        setType(type);
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return  type;
    }
}



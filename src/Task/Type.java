package Task;

public enum Type {
    WORK("Work"),
    PERSONAL("Personal");

    private final String type;

    private Type(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type;
    }
}

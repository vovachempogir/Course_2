package Task;

public class DescriptionField extends Exception {
    private final String argument;

    public DescriptionField(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return this.argument;
    }

    public String toString() {
        return this.argument;
    }
}

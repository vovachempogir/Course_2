package Task;

public class IncorrectArgumentException extends Exception {
    private final String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return this.argument;
    }

    public String toString() {
        return this.argument;
    }
}

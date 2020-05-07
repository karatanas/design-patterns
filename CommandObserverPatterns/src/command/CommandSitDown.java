package command;

public class CommandSitDown implements Command {
    private Exercise exercise;

    public CommandSitDown(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public String execute() {
        return this.exercise.sitDown();
    }
}

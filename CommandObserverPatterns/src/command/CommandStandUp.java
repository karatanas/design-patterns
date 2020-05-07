package command;

public class CommandStandUp implements Command {
    private Exercise exercise;

    public CommandStandUp(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public String execute() {
        return this.exercise.standUp();
    }
}

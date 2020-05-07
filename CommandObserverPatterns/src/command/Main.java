
package command;
import observer.Sportsman;
import observer.Spectator;

public class Main {
    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        Exercise exercise = new Exercise();
        Command standUpCommand = new CommandStandUp(exercise);
        Command sitDownCommand = new CommandSitDown(exercise);

        Sportsman sportsman = new Sportsman();
        Spectator spectator1 = new Spectator("Spectator 1");
        Spectator spectator2 = new Spectator("Spectator 2");
        Spectator spectator3 = new Spectator("Spectator 3");

        sportsman.subscribe(spectator1);
        sportsman.subscribe(spectator2);
        sportsman.subscribe(spectator3);

        trainer.setCommand(standUpCommand);
        sportsman.doExercise(trainer.sayExercise());

        trainer.setCommand(sitDownCommand);
        sportsman.doExercise(trainer.sayExercise());
    }
}

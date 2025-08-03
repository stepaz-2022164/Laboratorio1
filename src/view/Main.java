package view;

import controller.BattleController;
import controller.TrainerController;
import model.Trainer;
import view.BattleView;
import view.TrainerView;

public class Main {
    public static void main(String[] args) {
        BattleView battleView = new BattleView();
        TrainerView trainerView = new TrainerView();
            System.out.println("=== BATALLA POKÉMON ===");
            System.out.println("\n=== ENTRENADOR 1 ===");
            TrainerController trainerController1 = new TrainerController(trainerView);
            Trainer trainer1 = trainerController1.createTrainer(trainerView.getTrainerName());
            System.out.println("\n=== ENTRENADOR 2 ===");
            TrainerController trainerController2 = new TrainerController(trainerView);
            Trainer trainer2 = trainerController2.createTrainer(trainerView.getTrainerName());
            System.out.println("\n=== EQUIPOS ===");
            trainerController1.showTrainerDetails(trainer1);
            trainerController2.showTrainerDetails(trainer2);
            BattleController battleController = new BattleController(battleView);
            battleController.startBattle(trainer1, trainer2);

    }
}
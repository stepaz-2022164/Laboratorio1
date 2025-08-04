package view;

import controller.BattleController;
import controller.TrainerController;
import model.Trainer;
import view.BattleView;
import view.TrainerView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("---- BIENVENIDO AL JUEGO -----");

        while (playAgain) {
            BattleView battleView = new BattleView();
            TrainerView trainerView = new TrainerView();
            TrainerController trainerController = new TrainerController(trainerView);

            System.out.println("\n=== NUEVA BATALLA POKEMON ===");

            System.out.println("\n=== ENTRENADOR 1 ===");
            Trainer trainer1 = trainerController.createTrainer(trainerView.getTrainerName());

            System.out.println("\n=== ENTRENADOR 2 ===");
            Trainer trainer2 = trainerController.createTrainer(trainerView.getTrainerName());

            System.out.println("\n=== EQUIPOS ===");
            trainerController.showTrainerDetails(trainer1);
            trainerController.showTrainerDetails(trainer2);

            BattleController battleController = new BattleController(battleView);
            battleController.startBattle(trainer1, trainer2);

            System.out.println("\n" + "=".repeat(50));
            playAgain = askForNewGame(scanner);
        }

        System.out.println("Hasta la próxima :D");
        scanner.close();
    }

    private static boolean askForNewGame(Scanner scanner) {
        while (true) {
            System.out.print("Desea jugar una nueva partida? (s/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("s") || response.equals("si") || response.equals("sí")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("Ingrese 's' para si o 'n' para no.");
            }
        }
    }
}
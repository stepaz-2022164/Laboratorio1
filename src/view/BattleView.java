package view;

import java.util.Scanner;

public class BattleView {
    private final Scanner scanner;

    public BattleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showRoundStart(int round) {
        System.out.println("\n=== Ronda " + round + " ===");
    }

    public void showPokemonSelected(String trainerName, String pokemonName) {
        System.out.println(trainerName + " envía a " + pokemonName);
    }

    public void showPokemonHp(int currentHp, int maxHp) {
        System.out.println("HP: " + currentHp + "/" + maxHp);
    }

    public boolean askToUseAbility(String pokemonName, String abilityName) {
        System.out.print("¿Usar habilidad especial " + abilityName + " de " + pokemonName + "? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public void showDamage(String attacker, String defender, int damage) {
        System.out.println(attacker + " causa " + damage + " de daño a " + defender);
    }

    public void showPokemonFainted(String pokemonName) {
        System.out.println(pokemonName + " se ha debilitado!");
    }

    public void showRoundWinner(String winner) {
        System.out.println(winner + " gana la ronda!");
    }

    public void showBattleResults(String trainer1, int wins1, String trainer2, int wins2) {
        System.out.println("\n=== Resultado Final ===");
        System.out.println(trainer1 + ": " + wins1 + " victorias");
        System.out.println(trainer2 + ": " + wins2 + " victorias");

        if (wins1 > wins2) {
            System.out.println(trainer1 + " es el ganador del combate!");
        } else if (wins2 > wins1) {
            System.out.println(trainer2 + " es el ganador del combate!");
        } else {
            System.out.println("El combate termina en empate!");
        }
    }
}
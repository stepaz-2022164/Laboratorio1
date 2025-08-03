package view;

import model.Pokemon;
import model.SpecialAbility;

import java.util.List;
import java.util.Scanner;

public class TrainerView {
    private final Scanner scanner;

    public TrainerView() {
        this.scanner = new Scanner(System.in);
    }

    public String getTrainerName() {
        System.out.print("Ingrese nombre del Entrenador: ");
        return scanner.nextLine();
    }

    public void showPokemonList(List<Pokemon> pokemons) {
        System.out.println("\n=== Pokémon Disponibles ===");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            System.out.println((i+1) + ". " + p.getName() +
                    " (" + p.getType() + ") - Ataque: " + p.getCurrentAttack() +
                    ", Defensa: " + p.getCurrentDefense() +
                    ", HP: " + p.getMaxHp());
        }
    }

    public int selectPokemon(int pokemonNumber, int max) {
        while (true) {
            try {
                System.out.print("\nSeleccione Pokémon " + pokemonNumber + " (1-" + max + "): ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
                System.out.println("Selección inválida. Intente nuevamente.");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public void showPokemonSelected(String name) {
        System.out.println("Seleccionado: " + name);
    }

    public void showTrainerHeader(String trainerName) {
        System.out.println("\n=== Entrenador: " + trainerName + " ===");
        System.out.println("Pokémon en el equipo:");
    }

    public void showPokemonDetails(int number, String name, String type,
                                   int attack, int defense, int hp, int maxHp) {
        System.out.println(number + ". " + name + " (" + type + ") - " +
                "Ataque: " + attack + ", Defensa: " + defense +
                ", HP: " + hp + "/" + maxHp);
    }

    public void showAbilityDetails(SpecialAbility ability) {
        System.out.println("   Habilidad: " + ability.getName() +
                " (" + ability.getEffectType() + " +" +
                ability.getEffectValue() + ", " +
                ability.getActivationChance() + "% de activación)");
    }
}
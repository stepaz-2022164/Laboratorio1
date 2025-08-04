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

    public void showPokemonList(List<Pokemon> pokemons, boolean[] selectedPokemons) {
        System.out.println("\n=== Pokemones Disponibles ===");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            String status = selectedPokemons[i] ? " [SELECCIONADO]" : " [DISPONIBLE]";
            System.out.println((i+1) + ". " + p.getName() +
                    " (" + p.getType() + ") - Ataque: " + p.getCurrentAttack() +
                    ", Defensa: " + p.getCurrentDefense() +
                    ", HP: " + p.getMaxHp() + status);
        }
    }

    public int selectPokemon(int pokemonNumber, int max) {
        while (true) {
            try {
                System.out.print("\nSeleccione pokemon " + pokemonNumber + " (1-" + max + "): ");
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

    public void showPokemonAlreadySelected(String name) {
        System.out.println("ERROR: El pokemon " + name + " ya ha sido seleccionado, elija otro pokemon");
    }

    public void showTrainerHeader(String trainerName) {
        System.out.println("\n=== Entrenador: " + trainerName + " ===");
        System.out.println("pokemon en el equipo:");
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
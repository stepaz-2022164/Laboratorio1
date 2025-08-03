package controller;

import model.Pokemon;
import model.SpecialAbility;
import model.Trainer;
import view.TrainerView;

import java.util.ArrayList;
import java.util.List;

public class TrainerController {
    private final TrainerView view;
    private final List<Pokemon> availablePokemons;

    public TrainerController(TrainerView view) {
        this.view = view;
        this.availablePokemons = createPokemonPool();
    }

    private List<Pokemon> createPokemonPool() {
        List<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon("Charizard", "Fuego", 84, 78, 78,
                new SpecialAbility("Llamarada", "ATTACK", 15, 30)));
        pokemons.add(new Pokemon("Blastoise", "Agua", 83, 100, 79,
                new SpecialAbility("Hidrobomba", "ATTACK", 20, 25)));
        pokemons.add(new Pokemon("Venusaur", "Planta", 82, 83, 80,
                new SpecialAbility("Espesura", "DEFENSE", 20, 30)));
        pokemons.add(new Pokemon("Pikachu", "Eléctrico", 90, 55, 70,
                new SpecialAbility("Impacto Trueno", "ATTACK", 25, 20)));
        pokemons.add(new Pokemon("Gyarados", "Agua", 95, 79, 95,
                new SpecialAbility("Enfado", "ATTACK", 30, 25)));
        pokemons.add(new Pokemon("Arcanine", "Fuego", 90, 80, 90,
                new SpecialAbility("Furia", "ATTACK", 20, 30)));
        pokemons.add(new Pokemon("Exeggutor", "Planta", 95, 85, 95,
                new SpecialAbility("Semillas", "DEFENSE", 25, 35)));
        pokemons.add(new Pokemon("Magneton", "Eléctrico", 85, 95, 70,
                new SpecialAbility("Campo Magnético", "DEFENSE", 30, 20)));

        return pokemons;
    }

    public Trainer createTrainer(String name) {
        Trainer trainer = new Trainer(name);
        List<Pokemon> selectedPokemons = new ArrayList<>();

        view.showPokemonList(availablePokemons);

        for (int i = 0; i < 4; i++) {
            int choice = view.selectPokemon(i+1, availablePokemons.size()) - 1;
            Pokemon selected = availablePokemons.get(choice);
            selectedPokemons.add(selected);
            availablePokemons.remove(choice);

            view.showPokemonSelected(selected.getName());
        }

        for (int i = 0; i < selectedPokemons.size(); i++) {
            trainer.addPokemon(selectedPokemons.get(i), i);
        }

        return trainer;
    }

    public void showTrainerDetails(Trainer trainer) {
        view.showTrainerHeader(trainer.getName());

        Pokemon[] team = trainer.getTeam();
        for (int i = 0; i < team.length; i++) {
            Pokemon p = team[i];
            if (p != null) {
                view.showPokemonDetails(i+1, p.getName(), p.getType(),
                        p.getCurrentAttack(), p.getCurrentDefense(),
                        p.getCurrentHp(), p.getMaxHp());
                view.showAbilityDetails(p.getAbility());
            }
        }
    }
}
package controller;

import model.Pokemon;
import model.Trainer;
import model.TypeEffectiveness;
import view.BattleView;

public class BattleController {
    private final BattleView view;

    public BattleController(BattleView view) {
        this.view = view;
    }

    public void startBattle(Trainer trainer1, Trainer trainer2) {
        trainer1.resetTeam();
        trainer2.resetTeam();

        for (int round = 1; round <= 4; round++) {
            playRound(trainer1, trainer2, round);
        }

        announceWinner(trainer1, trainer2);
    }

    private void playRound(Trainer trainer1, Trainer trainer2, int round) {
        view.showRoundStart(round);

        Pokemon pokemon1 = trainer1.selectPokemon(round);
        Pokemon pokemon2 = trainer2.selectPokemon(round);

        pokemon1.restoreHp();
        pokemon2.restoreHp();

        view.showPokemonSelected(trainer1.getName(), pokemon1.getName());
        view.showPokemonHp(pokemon1.getCurrentHp(), pokemon1.getMaxHp());
        view.showPokemonSelected(trainer2.getName(), pokemon2.getName());
        view.showPokemonHp(pokemon2.getCurrentHp(), pokemon2.getMaxHp());

        boolean useAbility1 = view.askToUseAbility(pokemon1.getName(), pokemon1.getAbility().getName());
        boolean useAbility2 = view.askToUseAbility(pokemon2.getName(), pokemon2.getAbility().getName());

        if (!pokemon2.isFainted()) {
            int damage1 = calculateDamage(pokemon1, pokemon2, useAbility1);
            pokemon2.takeDamage(damage1);
            view.showDamage(pokemon1.getName(), pokemon2.getName(), damage1);
            view.showPokemonHp(pokemon2.getCurrentHp(), pokemon2.getMaxHp());

            if (pokemon2.isFainted()) {
                view.showPokemonFainted(pokemon2.getName());
                trainer1.addRoundWin();
                view.showRoundWinner(trainer1.getName());
                return; // Terminar ronda si un Pokémon se debilita
            }
        }

        if (!pokemon1.isFainted()) {
            int damage2 = calculateDamage(pokemon2, pokemon1, useAbility2);
            pokemon1.takeDamage(damage2);
            view.showDamage(pokemon2.getName(), pokemon1.getName(), damage2);
            view.showPokemonHp(pokemon1.getCurrentHp(), pokemon1.getMaxHp());

            if (pokemon1.isFainted()) {
                view.showPokemonFainted(pokemon1.getName());
                trainer2.addRoundWin();
                view.showRoundWinner(trainer2.getName());
                return; // Terminar ronda si un Pokémon se debilita
            }
        }

        if (pokemon1.getCurrentHp() > pokemon2.getCurrentHp()) {
            trainer1.addRoundWin();
            view.showRoundWinner(trainer1.getName());
        } else if (pokemon2.getCurrentHp() > pokemon1.getCurrentHp()) {
            trainer2.addRoundWin();
            view.showRoundWinner(trainer2.getName());
        } else {
            view.showRoundWinner("Empate");
        }

        pokemon1.updateModifiers();
        pokemon2.updateModifiers();
    }

    private int calculateDamage(Pokemon attacker, Pokemon defender, boolean useAbility) {
        if (useAbility) {
            attacker.applyAbilityEffect();
            if (attacker.getAbility().getEffectType().equals("DAMAGE") &&
                    attacker.getAbility().tryToActivate()) {
                return attacker.getAbility().getEffectValue();
            }
        }

        int typeBonus = TypeEffectiveness.getEffectMultiplier(attacker.getType(), defender.getType());
        return Math.max(1, attacker.getCurrentAttack() - defender.getCurrentDefense() + typeBonus);
    }

    private void announceWinner(Trainer trainer1, Trainer trainer2) {
        int wins1 = trainer1.getRoundsWon();
        int wins2 = trainer2.getRoundsWon();

        view.showBattleResults(trainer1.getName(), wins1, trainer2.getName(), wins2);
    }
}
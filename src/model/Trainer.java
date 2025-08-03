package model;

public class Trainer {
    private final String name;
    private final Pokemon[] team;
    private final boolean[] usedPokemon;
    private int roundsWon;

    public Trainer(String name) {
        this.name = name;
        this.team = new Pokemon[4];
        this.usedPokemon = new boolean[4];
        this.roundsWon = 0;
    }

    public String getName() {
        return name;
    }

    public Pokemon[] getTeam() {
        return team;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void addPokemon(Pokemon pokemon, int position) {
        if (position >= 0 && position < 4) {
            team[position] = pokemon;
        }
    }

    public Pokemon selectPokemon(int round) {
        for (int i = 0; i < 4; i++) {
            if (!usedPokemon[i] && team[i] != null) {
                usedPokemon[i] = true;
                return team[i];
            }
        }
        return null;
    }

    public void resetTeam() {
        for (int i = 0; i < 4; i++) {
            usedPokemon[i] = false;
        }
    }

    public void addRoundWin() {
        roundsWon++;
    }
}
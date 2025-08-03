package model;

import java.util.Random;

public class SpecialAbility {
    private final String name;
    private final String effectType;
    private final int effectValue;
    private final int activationChance;
    private final Random random;

    public SpecialAbility(String name, String effectType, int effectValue, int activationChance) {
        this.name = name;
        this.effectType = effectType;
        this.effectValue = effectValue;
        this.activationChance = activationChance;
        this.random = new Random();
    }

    public boolean tryToActivate() {
        return random.nextInt(100) < activationChance;
    }

    public String getName() {
        return name;
    }

    public String getEffectType() {
        return effectType;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public int getActivationChance() {
        return activationChance;
    }
}
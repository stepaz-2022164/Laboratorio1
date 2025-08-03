package model;

public class Pokemon {
    private final String name;
    private final String type;
    private final int baseAttack;
    private final int baseDefense;
    private final int maxHp;
    private int currentHp;
    private final SpecialAbility ability;
    private int attackModifier;
    private int defenseModifier;
    private int modifierDuration;

    public Pokemon(String name, String type, int attack, int defense, int hp, SpecialAbility ability) {
        this.name = name;
        this.type = type;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.maxHp = hp;
        this.currentHp = hp;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCurrentAttack() {
        return baseAttack + attackModifier;
    }

    public int getCurrentDefense() {
        return baseDefense + defenseModifier;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public SpecialAbility getAbility() {
        return ability;
    }

    public boolean isFainted() {
        return currentHp <= 0;
    }

    public void takeDamage(int damage) {
        currentHp = Math.max(0, currentHp - damage);
    }

    public void applyAbilityEffect() {
        if (ability.tryToActivate()) {
            switch (ability.getEffectType()) {
                case "ATTACK":
                    attackModifier = ability.getEffectValue();
                    break;
                case "DEFENSE":
                    defenseModifier = ability.getEffectValue();
                    break;
                case "DAMAGE": // Habilidad que causa daño directo
                    break;
            }
            modifierDuration = 2;
        }
    }

    public void updateModifiers() {
        if (modifierDuration > 0) {
            modifierDuration--;
            if (modifierDuration == 0) {
                attackModifier = 0;
                defenseModifier = 0;
            }
        }
    }

    public void restoreHp() {
        currentHp = maxHp;
    }
}
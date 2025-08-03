package model;

public class TypeEffectiveness {
    public static int getEffectMultiplier(String attackerType, String defenderType) {
        if (attackerType.equals("Fuego") && defenderType.equals("Planta")) return 20;
        if (attackerType.equals("Planta") && defenderType.equals("Agua")) return 20;
        if (attackerType.equals("Agua") && defenderType.equals("Fuego")) return 20;
        if (attackerType.equals("Eléctrico") && defenderType.equals("Agua")) return 20;

        if (attackerType.equals("Fuego") && defenderType.equals("Agua")) return -10;
        if (attackerType.equals("Agua") && defenderType.equals("Planta")) return -10;
        if (attackerType.equals("Planta") && defenderType.equals("Fuego")) return -10;
        if (attackerType.equals("Eléctrico") && defenderType.equals("Planta")) return -10;

        return 0;
    }
}
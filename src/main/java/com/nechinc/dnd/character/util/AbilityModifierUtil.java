package com.nechinc.dnd.character.util;

public class AbilityModifierUtil {
    public static int getModifier(int abilityScore) {
        return (abilityScore - 10) / 2;
    }
}

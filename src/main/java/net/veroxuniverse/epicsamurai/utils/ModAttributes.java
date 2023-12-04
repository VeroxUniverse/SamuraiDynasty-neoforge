package net.veroxuniverse.epicsamurai.utils;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

import java.util.UUID;

public class ModAttributes{

    protected static final UUID BASE_RANGED_DAMAGE_UUID = UUID.fromString("e8994e2d-71f4-4ef4-a6d1-edf967264a04");

    public static final Attribute RANGED_DAMAGE = register("generic.ranged_damage", new RangedAttribute("attribute.name.generic.ranged_damage", 2.0D, 0.0D, 2048.0D));

    private static Attribute register(String pId, Attribute pAttribute) {
        return Registry.register(BuiltInRegistries.ATTRIBUTE, pId, pAttribute);
    }

}

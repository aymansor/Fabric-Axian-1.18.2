package net.axian.axianmod.util;

import net.axian.axianmod.AxianMod;
import net.axian.axianmod.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }


    private static void registerFuels() {
        AxianMod.LOGGER.info("Registering Fuels for " + AxianMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        // register a new fuel item (Lilac flower bulb) that will burn for 200 ticks (10 seconds)
        registry.add(ModItems.LILAC_FLOWER_BULB, 200);
    }
}

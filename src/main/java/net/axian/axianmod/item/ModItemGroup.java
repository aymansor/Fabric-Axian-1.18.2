package net.axian.axianmod.item;

import net.axian.axianmod.AxianMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    // [Mythril Group]
    // This creates an item group that show up in the creative menu. The arguments that are passed
    // to FabricItemGroupBuilder.build are the identifier constructor with the mod ID, the
    // translation key for the item group, and a supplier of new ItemStack.
    public static final ItemGroup MYTHRIL = FabricItemGroupBuilder.build(new Identifier(AxianMod.MOD_ID, "mythril"),
            () -> new ItemStack(ModItems.MYTHRIL_INGOT));

}

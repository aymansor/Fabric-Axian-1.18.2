package net.axian.axianmod.block.custom;

import net.minecraft.block.PressurePlateBlock;

public class ModPressurePlateBlock extends PressurePlateBlock {
    // Inheritance from PressurePlateBlock and make the constructor public instead of protected.
    public ModPressurePlateBlock(ActivationRule type, Settings settings) {
        super(type, settings);
    }
}

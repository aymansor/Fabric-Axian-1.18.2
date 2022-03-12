package net.axian.axianmod.block.custom;

import net.minecraft.block.StoneButtonBlock;

public class ModStoneButtonBlock extends StoneButtonBlock {
    // Inheritance from StoneButtonBlock and make the constructor public instead of protected.
    public ModStoneButtonBlock(Settings settings) {
        super(settings);
    }
}

package net.axian.axianmod.util;

import net.axian.axianmod.AxianMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DOWSING_ROD_DETECTABLE_BLOCKS =
                createTag("dowsing_rod_detectable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(AxianMod.MOD_ID, name));
        }

        // Common tags that will be shared between different mods
        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }

    }


    public static class Items {
        public static final TagKey<Item> MYTHRIL_INGOTS = createCommonTag("mythril_ingots");
        public static final TagKey<Item> MYTHRIL_NUGGETS = createCommonTag("mythril_nuggets");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(AxianMod.MOD_ID, name));
        }

        // Common tags that will be shared between different mods
        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }

    }
}

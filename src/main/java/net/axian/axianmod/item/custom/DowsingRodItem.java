package net.axian.axianmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings) {
        super(settings);
    }


    // Override the ActionResult method inherited from Item class.
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        // Checks if we are on the client.
        if (context.getWorld().isClient()) {
            // Gets the block position the player right-clicked.
            BlockPos positionClicked = context.getBlockPos();
            // Gets the player.
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            // TODO - Display only the latest message to the chat box after a player right-clicks a block without clearing the chat history.
            // Output a new line to the chat hud before displaying any message.
            assert player != null;
            player.sendMessage(new LiteralText(""), false);

            // Will iterate until the last block at the end of the world is reached.
            // A negative 64 is added to positionClicked.getY() since the world ends at -64 instead of 0.
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                // Gets the block beneath the one clicked by the player.
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                // Each iteration a new block is passed to the isValuableBlock method to check if the block
                // is valuable. If a valuable block is discovered, a message will be displayed to the player.
                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.down(i), player, blockBelow);
                    foundBlock = true;
                    // Uncomment the break statement below if you only want to output the first found valuable.
                    //break;
                }
            }

            // If no block was found after the for loops ends a message will be displayed to the user
            // using the key below.
            if (!foundBlock) {
                player.sendMessage(new TranslatableText("item.axianmod.dowsing_rod.no_valuables"), false);
            }
        }

        // Damage the item by 1 after the player uses it.
        context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()),
                (player -> player.sendToolBreakStatus(player.getActiveHand())));

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        // If the player has shift pressed down, the translatable key text inside en_us.json will display
        // the appropriate message. Else the other translatable key will be displayed.
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.axianmod.dowsing_rod.tooltip.shift"));
        }
        else {
            tooltip.add(new TranslatableText("item.axianmod.dowsing_rod.tooltip"));
        }
    }

    // Outputs the name and coordinates of the valuable block to the player. Takes three arguments, the block
    // coordinates, the player entity to be notified, and the valuable block.
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        String valuableBlock = blockBelow.asItem().getName().getString();
        String ColoredMessage = "";

        // Format the valuable block name. §l for bold and §r resets the formatting.
        if ( blockBelow == Blocks.COAL_ORE){
            ColoredMessage += "§7§l" + valuableBlock + "§r";    // §7: Gray
        }
        else if (blockBelow == Blocks.COPPER_ORE) {
            ColoredMessage += "§6§l" + valuableBlock + "§r";    // §6: Gold
        }
        else if (blockBelow == Blocks.DIAMOND_ORE) {
            ColoredMessage += "§b§l" + valuableBlock + "§r";    // §b: Aqua
        }
        else if (blockBelow == Blocks.IRON_ORE) {
            ColoredMessage += "§g§l" + valuableBlock + "§r";    // §g: Minecoin Gold
        }

        player.sendMessage(new LiteralText("§a[+]§r Found " + ColoredMessage + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }


    // Returns true if the passed block is one of the valuable blocks defined below.
    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }
}

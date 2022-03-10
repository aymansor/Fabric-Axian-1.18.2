package net.axian.axianmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeedyBlock extends Block {
    public SpeedyBlock (Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        // Check if called on the client
        // Called 4 times on right click:
        // 2 times on the server (for each hand)
        // 2 times on the client (for each hand)
        if (world.isClient()) {

            // TODO - remove the output messes
            if (hand == Hand.MAIN_HAND) {
                player.sendMessage(new LiteralText("CLIENT: MAIN HAND!"), false);
            }
            else {
                player.sendMessage(new LiteralText("CLIENT: OFF HAND!"), false);
            }
        }

        // TODO - [remove comment before commit] Play with the Success part maybe change to consume or smth
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        // Check if called on the server
        if (!world.isClient()) {

            if (entity instanceof LivingEntity) {
                // Cast the entity
                LivingEntity livingEntity = ((LivingEntity) entity);
                // Add a potion effect to the entity. The duration is on ticks. 20 ticks on a second.
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 5));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}

package net.nancy.plutonium.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) { // what happens when the item is being used on a block
        if(!context.getWorld().isClient) { // making sure we are on the server
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            boolean foundCave = false;
            int currentHeight = positionClicked.getY();
            int caveY = 999;

            for(int i = 0; i <= currentHeight + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    
                    //break;
                } else if (state.isOf(Blocks.AIR)) {
                    foundCave = true;
                    caveY = positionClicked.down(i).getY();
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("Nothing found. Keep looking!"));
            }
            if(foundCave) {
                player.sendMessage(Text.literal("Found a Cave around  y: " + caveY));
            }
        }

        context.getStack().damage(1,context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS; // if we swing the item and connect with another block
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {

        player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), SoundCategory.NEUTRAL,1f,2f);

        player.sendMessage(Text.literal(
                "Ding! " + block.getName().getString() + " found at " + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + "!"
        ), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.plutonium.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

package net.nancy.plutonium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class AssaultRifleItem extends Item {
    public static int interval;
    public AssaultRifleItem(Settings settings, int interval) {
        super(settings);
        this.interval = interval;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 20 * interval;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            float f = (float) getMaxUseTime(stack) - remainingUseTicks;

            if (f < 0.1f) {

            }
        }

        super.usageTick(world, user, stack, remainingUseTicks);
    }
}

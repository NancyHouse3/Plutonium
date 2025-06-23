package net.nancy.plutonium.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class AssaultRifleItem extends Item {
    public static int interval;
    public static float ammoVelocity;
    public static float spread;
    public AssaultRifleItem(Settings settings, int interval, float ammoVelocity, float spread) {
        super(settings);
        this.interval = interval;
        this.ammoVelocity = ammoVelocity;
        this.spread = spread;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.55F, 4.0F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            ArrowEntity arrowEntity = new ArrowEntity(world, user);
            arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, (3 * this.ammoVelocity), this.spread);
            world.spawnEntity(arrowEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {

            itemStack.damage(1, user, (p) -> {
                p.sendToolBreakStatus(user.getActiveHand());
            });
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}

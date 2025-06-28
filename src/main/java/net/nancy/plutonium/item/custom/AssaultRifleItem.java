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
    public static Item ammo;
    public static ItemStack currentAmmoPool = null;
    public AssaultRifleItem(Settings settings, Item ammo, int interval, float ammoVelocity, float spread) {
        super(settings);
        this.interval = interval;
        this.ammoVelocity = ammoVelocity;
        this.spread = spread;
        this.ammo = ammo;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        for (ItemStack playerAmmo : user.getInventory().main) {
            if (playerAmmo.isOf(ammo))  {
                currentAmmoPool = playerAmmo;
                break;
            }else {
                currentAmmoPool = null;
            }
        }

        if (currentAmmoPool != null || user.getAbilities().creativeMode) {
            shoot(world,user,hand);
            boolean hasAmmo = currentAmmoPool.isOf(ammo);
            if (!hasAmmo && !user.getAbilities().creativeMode) {
                currentAmmoPool.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public void shoot(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.55F, 4.0F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            ArrowEntity arrowEntity = new ArrowEntity(world, player);
            arrowEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, (3 * this.ammoVelocity), this.spread);
            world.spawnEntity(arrowEntity);
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!player.getAbilities().creativeMode) {

            itemStack.damage(1, player, (p) -> {
                p.sendToolBreakStatus(player.getActiveHand());
            });
        }
    }
}
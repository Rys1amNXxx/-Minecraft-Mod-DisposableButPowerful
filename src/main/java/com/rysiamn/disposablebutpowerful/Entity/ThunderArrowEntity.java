package com.rysiamn.disposablebutpowerful.Entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import static com.rysiamn.disposablebutpowerful.Main.THUNDER_ARROW;
import static com.rysiamn.disposablebutpowerful.Main.THUNDER_ARROW_ITEM;

public class ThunderArrowEntity extends Arrow {
    public ThunderArrowEntity(EntityType<? extends ThunderArrowEntity> type, Level world) {
        super(type, world);
    }

    public ThunderArrowEntity(Level world, LivingEntity shooter) {
        this(THUNDER_ARROW.get(), world);
        this.setOwner(shooter);
        this.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
        System.out.println("LightningArrowEntity 实例已创建，射手：" + shooter.getName().getString());
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        summonLightning();
    }

    @Override
    protected void onHitBlock(net.minecraft.world.phys.BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        summonLightning();
    }

    private void summonLightning() {
        Level world = this.level();
        if (!world.isClientSide && world instanceof ServerLevel serverLevel) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(world);
            if (lightning != null) {
                lightning.moveTo(this.getX(), this.getY(), this.getZ());
                serverLevel.addFreshEntity(lightning);
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(THUNDER_ARROW_ITEM.get());
    }

}

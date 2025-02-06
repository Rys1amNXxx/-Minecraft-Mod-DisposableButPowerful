package com.rysiamn.disposablebutpowerful.Items;

import com.rysiamn.disposablebutpowerful.Entity.ThunderArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThunderArrowItem extends ArrowItem {
    public ThunderArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        System.out.println("ThunderArrowItem.createArrow");
        return new ThunderArrowEntity(level, shooter);
    }

}

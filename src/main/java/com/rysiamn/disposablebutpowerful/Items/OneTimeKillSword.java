package com.rysiamn.disposablebutpowerful.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class OneTimeKillSword extends SwordItem {

    public OneTimeKillSword(Item.Properties properties) {
        super(Tiers.NETHERITE, 999, -2.4F, properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

}

package com.rysiamn.disposablebutpowerful.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;

public class OneTimeRangedPickaxe extends PickaxeItem {
    public OneTimeRangedPickaxe(Item.Properties properties) {
        super(Tiers.NETHERITE, 1, -2.8F, properties);
    }

}
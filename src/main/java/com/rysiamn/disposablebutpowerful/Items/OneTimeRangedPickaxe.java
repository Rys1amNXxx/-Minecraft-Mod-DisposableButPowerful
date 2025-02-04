package com.rysiamn.disposablebutpowerful.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class OneTimeRangedPickaxe extends PickaxeItem {
    public OneTimeRangedPickaxe(Item.Properties properties) {
        super(Tiers.NETHERITE, 1, -2.8F, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide) {
            for (int x = -7; x <= 7; x++) {
                for (int y = -7; y <= 7; y++) {
                    for (int z = -7; z <= 7; z++) {
                        BlockPos targetPos = pos.offset(x, y, z);
                        BlockState targetState = level.getBlockState(targetPos);

                        if (targetState.getDestroySpeed(level, targetPos) >= 0) {
                            level.destroyBlock(targetPos, true, entity);
                        }
                    }
                }
            }
            stack.hurtAndBreak(1, entity, (p) -> p.broadcastBreakEvent(p.getUsedItemHand()));
        }
        return true;
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
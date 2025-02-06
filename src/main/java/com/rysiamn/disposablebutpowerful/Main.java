package com.rysiamn.disposablebutpowerful;

import com.mojang.logging.LogUtils;
import com.rysiamn.disposablebutpowerful.Entity.ThunderArrowEntity;
import com.rysiamn.disposablebutpowerful.Items.OneTimeKillSword;
import com.rysiamn.disposablebutpowerful.Items.OneTimeRangedPickaxe;
import com.rysiamn.disposablebutpowerful.Items.ThunderArrowItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;


@Mod(Main.MODID)
public class Main {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "disposablebutpowerful";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<Item> ONE_TIME_KILL_SWORD = ITEMS.register("one_time_kill_sword",
            () -> new OneTimeKillSword(new Item.Properties().durability(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> ONE_TIME_RANGED_PICKAXE = ITEMS.register("one_time_ranged_pickaxe",
            () -> new OneTimeRangedPickaxe(new Item.Properties().durability(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> THUNDER_ARROW_ITEM = ITEMS.register("thunder_arrow",
            () -> new ThunderArrowItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<EntityType<ThunderArrowEntity>> THUNDER_ARROW = ENTITIES.register("thunder_arrow",
            () -> EntityType.Builder.<ThunderArrowEntity>of(ThunderArrowEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build("thunder_arrow"));


    public Main(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        ITEMS.register(bus);
        ENTITIES.register(bus);
//        bus.register(Main.class);
    }
}

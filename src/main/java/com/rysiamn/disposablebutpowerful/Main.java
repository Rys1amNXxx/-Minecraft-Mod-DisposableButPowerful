package com.rysiamn.disposablebutpowerful;

import com.mojang.logging.LogUtils;
import com.rysiamn.disposablebutpowerful.Items.OneTimeKillSword;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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

    public static final RegistryObject<Item> ONE_TIME_KILL_SWORD = ITEMS.register("one_time_kill_sword",
            () -> new OneTimeKillSword(new Item.Properties().durability(1).rarity(Rarity.EPIC)));

    public Main() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
//        bus.register(Main.class);
    }
}

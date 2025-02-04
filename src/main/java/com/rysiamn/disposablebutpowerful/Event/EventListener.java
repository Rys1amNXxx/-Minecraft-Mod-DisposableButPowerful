package com.rysiamn.disposablebutpowerful.Event;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rysiamn.disposablebutpowerful.Main.MODID;
import static com.rysiamn.disposablebutpowerful.Main.ONE_TIME_KILL_SWORD;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
public class EventListener {
    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ONE_TIME_KILL_SWORD);
        }
    }
}

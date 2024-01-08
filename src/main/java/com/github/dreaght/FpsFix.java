package com.github.dreaght;

import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.ShutdownEvent;
import net.weavemc.loader.api.event.StartGameEvent;
import net.weavemc.loader.api.event.SubscribeEvent;

public class FpsFix implements ModInitializer {
    @Override
    public void preInit() {
        EventBus.subscribe(this);
    }

    @SubscribeEvent
    public void onStartGame(StartGameEvent.Post ev) {
        if (SettingsManager.isEnabled()) {
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.gameSettings.enableVsync = true;
        }
    }

    @SubscribeEvent
    public void onShutdown(ShutdownEvent ev) {
        Minecraft minecraft = Minecraft.getMinecraft();
        SettingsManager.saveSettings(minecraft.gameSettings.enableVsync);
    }
}

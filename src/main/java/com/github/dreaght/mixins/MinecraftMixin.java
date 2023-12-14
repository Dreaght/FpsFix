package com.github.dreaght.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Inject(method = "initStream", at = @At("HEAD"))
    public void onInit(CallbackInfo ci) {
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.gameSettings.limitFramerate = 144;
        minecraft.gameSettings.enableVsync = true;
    }
}

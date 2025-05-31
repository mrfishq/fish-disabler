package com.fish.disabler.mixin;

import net.minecraft.client.session.Session;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.fish.disabler.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Mixin(Session.class)
public class NameChanger {
    private static final String MOD_ID = "fish-disabler";
    private final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Shadow @Final @Mutable
    private String username;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        this.username = ConfigManager.CONFIG.username;
        LOGGER.info("Set Name to: " + ConfigManager.CONFIG.username);
    }
}



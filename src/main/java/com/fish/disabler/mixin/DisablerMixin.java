package com.fish.disabler.mixin;

import com.fish.disabler.config.ConfigManager;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Mixin(RunArgs.Game.class)
public class DisablerMixin {
	private static final String MOD_ID = "fish-disabler";
	private static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0)
	private static boolean modifyIsDemo(boolean isDemo) {
		if (ConfigManager.CONFIG.DoisDemo){
			LOGGER.info("Modifying isDemo to: " + ConfigManager.CONFIG.isDemo);
			return ConfigManager.CONFIG.isDemo;
		}
		LOGGER.info("Modifying isDemo to Default Boolean");
		return isDemo;
	}

	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 1)
	private static boolean modifyMultiplayerEnabled(boolean multiplayerEnabled) {
		if (ConfigManager.CONFIG.DomultiplayerEnabled){
			LOGGER.info("Modifying multiplayerEnabled to: " + ConfigManager.CONFIG.multiplayerEnabled);
			return ConfigManager.CONFIG.multiplayerEnabled;
		}
		LOGGER.info("Modifying multiplayerEnabled to Default Boolean");
		return multiplayerEnabled;
	}
	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 2)
	private static boolean modifyChat(boolean onlineChatEnabled) {
		if (ConfigManager.CONFIG.DoonlineChatEnabled){
			LOGGER.info("Modifying OnlineChatEnabled to: " + ConfigManager.CONFIG.onlineChatEnabled);
			return ConfigManager.CONFIG.onlineChatEnabled;
		}
		LOGGER.info("Modifying onlineChatEnabled to Default Boolean");
		return onlineChatEnabled;
	}

}



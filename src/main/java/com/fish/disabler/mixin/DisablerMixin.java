package com.fish.disabler.mixin;

import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RunArgs.Game.class)
public class DisablerMixin {
	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0)
	private static boolean modifyIsDemo(boolean isDemo) {
		return false;
	}

	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 1)
	private static boolean modifyMultiplayerEnabled(boolean multiplayerEnabled) {
		return false;
	}
	@ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 2)
	private static boolean modifyChat(boolean onlineChatEnabled) {
		return false;
	}

}



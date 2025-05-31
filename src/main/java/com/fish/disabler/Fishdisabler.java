package com.fish.disabler;
import net.fabricmc.api.ModInitializer;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fish.disabler.config.ConfigManager;
public class Fishdisabler implements ModInitializer {
	public static final String MOD_ID = "fish-disabler";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Welcome to Fish Disabler!");
	}
}
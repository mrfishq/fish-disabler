package com.fish.disabler.config;

import com.fish.disabler.Fishdisabler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = new File("config/fish-disabler/config.json").toPath();
    public static ModConfig CONFIG = new ModConfig();

    static {
      loadConfig();
    }
    public static void loadConfig() {
        try {
            File configFile = CONFIG_PATH.toFile();
            if (!configFile.exists()) {
                saveConfig();
                Fishdisabler.LOGGER.info("Created default config.");
            } else {
                FileReader reader = new FileReader(configFile);
                CONFIG = GSON.fromJson(reader, ModConfig.class);
                reader.close();
                Fishdisabler.LOGGER.info("Config loaded.");
            }
        } catch (Exception e) {
            Fishdisabler.LOGGER.error("Failed to load config: ", e);
        }
    }

    public static void saveConfig() {
        try {
            File configDir = CONFIG_PATH.getParent().toFile();
            Fishdisabler.LOGGER.info("Config directory: " + configDir.getAbsolutePath());
            if (!configDir.exists()) {
                boolean created = configDir.mkdirs();
                Fishdisabler.LOGGER.info("Attempted to create config directory: " + created);
            } else {
                Fishdisabler.LOGGER.info("Config directory is exists.");
            }

            File configFile = CONFIG_PATH.toFile();
            Fishdisabler.LOGGER.info("Config file path: " + configFile.getAbsolutePath());

            FileWriter writer = new FileWriter(configFile);
            GSON.toJson(CONFIG, writer);
            writer.close();

            Fishdisabler.LOGGER.info("Saved config file.");
        } catch (Exception e) {
            Fishdisabler.LOGGER.error("Failed to save config: ", e);
        }
    }

}


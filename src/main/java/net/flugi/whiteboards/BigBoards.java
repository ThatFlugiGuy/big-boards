package net.flugi.whiteboards;

import net.fabricmc.api.ModInitializer;

import net.flugi.whiteboards.item.ModItems;
import net.flugi.whiteboards.sounds.CustomSounds;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigBoards implements ModInitializer {
	public static final String MOD_ID = "big-boards";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.init();
		CustomSounds.init();


		LOGGER.info("big chat is listening");
	}



	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

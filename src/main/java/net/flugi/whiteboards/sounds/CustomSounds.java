package net.flugi.whiteboards.sounds;

import net.flugi.whiteboards.BigBoards;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class CustomSounds {
    private CustomSounds() {}

    public static final SoundEvent WRITE = registerSound("write");
    public static final SoundEvent ERASE = registerSound("erase");


    private static SoundEvent registerSound(String id) {
        Identifier identifier = BigBoards.id(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init() {
        BigBoards.LOGGER.info("registering sounds or something");
    }
}

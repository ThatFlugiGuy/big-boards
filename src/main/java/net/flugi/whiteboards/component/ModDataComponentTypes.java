package net.flugi.whiteboards.component;

import com.mojang.serialization.Codec;
import net.flugi.whiteboards.BigBoards;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<String> WHITEBOARD_TEXT = register("whiteboard_text", builder -> builder.codec(Codec.STRING));


    private  static  <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(BigBoards.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        BigBoards.LOGGER.info("Writing stuff on the boards");
    }

}

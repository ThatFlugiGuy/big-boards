package net.flugi.whiteboards.item;

import net.flugi.whiteboards.BigBoards;
import net.flugi.whiteboards.component.ModDataComponentTypes;
import net.flugi.whiteboards.item.custom.WhiteboardItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import java.util.function.Function;

public class ModItems {

    public static final Item WHITEBOARD = register("whiteboard", WhiteboardItem::new, new Item.Settings()
            .component(ModDataComponentTypes.WHITEBOARD_TEXT, ""));

    public static <T extends Item> T register(String name, Function<Item.Settings, T> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, BigBoards.id(name));
        T item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }



    public static void init() {}

}

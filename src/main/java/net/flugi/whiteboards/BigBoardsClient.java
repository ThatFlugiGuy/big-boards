package net.flugi.whiteboards;

import net.fabricmc.api.ClientModInitializer;
import net.flugi.whiteboards.client.rendering.item.WhiteboardRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.render.item.model.special.SpecialModelTypes;
import net.minecraft.util.Identifier;

public class BigBoardsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        SpecialModelTypes.ID_MAPPER.put(Identifier.of(BigBoards.MOD_ID, "test"), WhiteboardRenderer.Unbaked.MAP_CODEC);

    }
}

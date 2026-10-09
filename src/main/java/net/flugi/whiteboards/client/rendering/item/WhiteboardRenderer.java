package net.flugi.whiteboards.client.rendering.item;

import com.mojang.serialization.MapCodec;
import net.flugi.whiteboards.BigBoards;
import net.flugi.whiteboards.component.ModDataComponentTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.Font;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.SpriteTexturedVertexConsumer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.AxisTransformation;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class WhiteboardRenderer implements SpecialModelRenderer<String> {
    public static final WhiteboardRenderer INSTANCE = new WhiteboardRenderer();
    private final MinecraftClient client = MinecraftClient.getInstance();

    public record Unbaked(Identifier texture) implements SpecialModelRenderer.Unbaked {

        public static final MapCodec<WhiteboardRenderer.Unbaked> MAP_CODEC = Identifier.CODEC.fieldOf("texture")
                .xmap(WhiteboardRenderer.Unbaked::new, WhiteboardRenderer.Unbaked::texture);


        @Override
        public @Nullable SpecialModelRenderer<?> bake(BakeContext context) {

            return new WhiteboardRenderer();
        }

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> getCodec() {
            return MAP_CODEC;
        }
    }


    @Override
    public void render(@Nullable String data, ItemDisplayContext displayContext, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, boolean glint, int i) {

        matrices.push();

    
        //matrices.scale(-1/10.8f,-1/10.8f,1/16f);
        //matrices.translate(-17/16f*10.8,-14/16f*10.8,7.49);


        float s = 40/27f; //  size for width == 9  aka x1/0.675
        int width = MinecraftClient.getInstance().textRenderer.getWidth(data);
        if (width > 10) {
            s=  9f /(width/2f);
        }
        matrices.scale(-1/16f*s,-1/16f*s,1/16f);
        matrices.translate(-17/s,-8/s-4,7.49f);
        // max width = 18 btw :D


        queue.submitText(
                matrices,
                0,0,
                Text.literal(data).asOrderedText(),
                false,
                TextRenderer.TextLayerType.NORMAL,
                light,
                0xff231e1e,
                0,
                0

        );

        matrices.pop();


    }

    @Nullable
    @Override
    public String getData(ItemStack stack) {
        return stack.getOrDefault(ModDataComponentTypes.WHITEBOARD_TEXT,"");
    }

    @Override
    public void collectVertices(Consumer consumer) {

    }
}

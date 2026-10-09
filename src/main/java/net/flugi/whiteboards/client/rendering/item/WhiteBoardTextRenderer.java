package net.flugi.whiteboards.client.rendering.item;



import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.texture.SpriteHolder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;
import net.minecraft.client.render.item.ItemRenderState;

import java.util.function.Consumer;
/*
@Environment(EnvType.CLIENT)
public record WhiteBoardTextRenderer(SpriteHolder spriteHolder,Model.SinglePartModel model, Identifier texture) implements SpecialModelRenderer<ItemStack> {


    public record Unbaked(Identifier texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<WhiteBoardTextRenderer.Unbaked> MAP_CODEC = Identifier.CODEC.fieldOf("texture")
                .xmap(WhiteBoardTextRenderer.Unbaked::new, WhiteBoardTextRenderer.Unbaked::texture);

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked> getCodec() {
            return MAP_CODEC;
        }

        @Override
        public @Nullable SpecialModelRenderer<?> bake(BakeContext context) {

            Identifier textureLoc = this.texture.withPath(path -> "textures/item/" + path + ".png");
            Model.SinglePartModel singlePartModel = MoreBullshitYay.createWhiteBoardModel(context.entityModelSet());


            return new WhiteBoardTextRenderer(context.spriteHolder(), singlePartModel, textureLoc);
        }
    }



    @Override
    public @Nullable ItemStack getData(ItemStack stack) {
        return null;
    }

    @Override
    public void render(@Nullable ItemStack data, ItemDisplayContext displayContext, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay, boolean glint, int i) {



        matrices.push();

        queue.submitModel(this.model, Unit.INSTANCE,matrices, RenderLayers.cutout(),light,overlay,-1, null);

        queue.submitText(
                matrices,
                0,0,
                Text.literal("Skibidi").asOrderedText(),
                false,
                TextRenderer.TextLayerType.NORMAL,
                light,
                0xffffffff,
                0,
                0

        );



        matrices.pop();
    }





    @Override
    public void collectVertices(Consumer<Vector3fc> consumer) {
        MatrixStack matrixStack = new MatrixStack();
        MoreBullshitYay.setTransformsForItem(matrixStack);
        this.model.getRootPart().collectVertices(matrixStack, consumer);
    }





}*/



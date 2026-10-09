package net.flugi.whiteboards.client.rendering.item;

import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.flugi.whiteboards.BigBoards;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.texture.SpriteHolder;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.util.math.RotationAxis;

import java.util.Set;
/*
@Environment(EnvType.CLIENT)
public class MoreBullshitYay {

    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    private  static final EntityModelLayer WHITEBOARD =  create("whiteboard","main");

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(Identifier.of(BigBoards.MOD_ID, id), layer);
    }


    public static Model.SinglePartModel createWhiteBoardModel(LoadedEntityModels models) {
        return new Model.SinglePartModel(models.getModelPart(WHITEBOARD), RenderLayers::entityCutoutNoCull);
    }

    public static void setTransformsForItem(MatrixStack matrices) {
        setAngles(matrices, 0.0F);
        matrices.scale(0.6666667F, -0.6666667F, -0.6666667F);
    }

    private static void setAngles(MatrixStack matrices, float blockRotationDegrees) {
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockRotationDegrees));
    }

    public static void renderAsItem(
            SpriteHolder spriteHolder,
            MatrixStack matrices,
            OrderedRenderCommandQueue queue,
            int light,
            int overlay,
            Model.SinglePartModel model,
            SpriteIdentifier texture
    ) {
        matrices.push();
        setTransformsForItem(matrices);
        queue.submitModel(model, Unit.INSTANCE, matrices, texture.getRenderLayer(model::getLayer), light, overlay, -1, spriteHolder.getSprite(texture), 0, null);
        matrices.pop();
    }



}*/

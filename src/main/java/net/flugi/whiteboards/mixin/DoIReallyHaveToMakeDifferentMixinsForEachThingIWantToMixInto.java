package net.flugi.whiteboards.mixin;


import net.flugi.whiteboards.item.custom.WhiteboardItem;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin (HeldItemFeatureRenderer.class)
public class DoIReallyHaveToMakeDifferentMixinsForEachThingIWantToMixInto<S extends ArmedEntityRenderState, M extends EntityModel<S> & ModelWithArms> {
    @Inject(
            method =" Lnet/minecraft/client/render/entity/feature/HeldItemFeatureRenderer;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;ILnet/minecraft/client/render/entity/state/ArmedEntityRenderState;FF)V",
            at = @At("HEAD")
    )
    public void render(MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, S armedEntityRenderState, float f, float g, CallbackInfo ci) {
        Arm OFFARM = switch (armedEntityRenderState.mainArm) {
            case LEFT -> Arm.RIGHT;
            case RIGHT -> Arm.LEFT;
        };

        ItemStack heldStack = armedEntityRenderState.getMainHandItemStack();
        ItemStack offStack = armedEntityRenderState.getItemStackForArm(OFFARM);


        if (heldStack.getItem() instanceof WhiteboardItem && armedEntityRenderState.getItemUseTime( armedEntityRenderState.mainArm) > 0 && !armedEntityRenderState.sneaking) {
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(135f));
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(10F));
            matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(17.0f));
            matrixStack.translate(-0.40,0.95,0.5f);
        } else if (offStack.getItem() instanceof WhiteboardItem && !armedEntityRenderState.sneaking) {
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(135f));
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-10f));
            matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(-17.0f));
            matrixStack.translate(0.5,0.95,0.5f);

        }

    }

}

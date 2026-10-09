package net.flugi.whiteboards.mixin;

import net.flugi.whiteboards.item.custom.WhiteboardItem;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class TheMixThatHides {

    @Inject(
            method = "Lnet/minecraft/client/render/entity/PlayerEntityRenderer;renderLabelIfPresent(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V",
            at = @At("HEAD"),
            cancellable = true)
    protected void renderLabelIfPresent(PlayerEntityRenderState playerEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState, CallbackInfo ci) {

        Arm OFFARM = switch (playerEntityRenderState.mainArm) {
            case LEFT -> Arm.RIGHT;
            case RIGHT -> Arm.LEFT;
        };

        ItemStack heldStack = playerEntityRenderState.getMainHandItemStack();
        ItemStack offStack = playerEntityRenderState.getItemStackForArm(OFFARM);

        if (((heldStack.getItem() instanceof WhiteboardItem && playerEntityRenderState.isUsingItem) || offStack.getItem() instanceof WhiteboardItem ) && !playerEntityRenderState.isInSneakingPose ) {
            ci.cancel();
        }
    }

}

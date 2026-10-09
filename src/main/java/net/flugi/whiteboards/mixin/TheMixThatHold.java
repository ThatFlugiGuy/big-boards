package net.flugi.whiteboards.mixin;


import net.flugi.whiteboards.BigBoards;
import net.flugi.whiteboards.item.custom.WhiteboardItem;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class TheMixThatHold<T extends BipedEntityRenderState> {

    @Shadow public ModelPart rightArm;
    @Shadow public ModelPart leftArm;


    @Shadow public abstract ModelPart getArm(Arm arm);

    @Inject(
            method = "Lnet/minecraft/client/render/entity/model/BipedEntityModel;positionRightArm(Lnet/minecraft/client/render/entity/state/BipedEntityRenderState;)V",
            at = @At("TAIL")
    )
    private void beholdMyConfusion(T state, CallbackInfo ci)  {

        Arm OFFARM = switch (state.mainArm) {
            case LEFT -> Arm.RIGHT;
            case RIGHT -> Arm.LEFT;
        };

        ItemStack heldStack = state.getMainHandItemStack();
        ItemStack offStack = state.getItemStackForArm(OFFARM);
        if (heldStack.getItem() instanceof WhiteboardItem) {

            if (state.isUsingItem && !state.isInSneakingPose) {
                this.rightArm.pitch =  (float) Math.PI;
                this.rightArm.yaw =  0f;
                this.rightArm.roll = -(45/360f) * (float) Math.PI;

                this.leftArm.pitch = (float) Math.PI;
                this.leftArm.yaw = 0f;
                this.leftArm.roll = (45/360f) * (float) Math.PI;

                return;
            }
            this.rightArm.pitch = -51f;
            this.rightArm.yaw = 38f;
            this.rightArm.roll = -12f;

            this.leftArm.pitch = -51f;
            this.leftArm.yaw = -38f;
            this.leftArm.roll = 12f;
        } else if (offStack.getItem() instanceof WhiteboardItem && !state.isInSneakingPose) {
            this.getArm(OFFARM).pitch = (float) Math.PI;
            this.getArm(OFFARM).yaw = 0f;
            this.getArm(OFFARM).roll = (OFFARM == Arm.RIGHT ? -1 : 1) * (45/360f) * (float) Math.PI;
        }


    }


    @Inject(
            method = "Lnet/minecraft/client/render/entity/model/BipedEntityModel;animateArms(Lnet/minecraft/client/render/entity/state/BipedEntityRenderState;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    protected void setAngles(T state, CallbackInfo ci) {
        if ( state.getMainHandItemStack().getItem() instanceof WhiteboardItem) {
            ci.cancel();
        }
    }
}

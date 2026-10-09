package net.flugi.whiteboards.mixin;


import net.flugi.whiteboards.component.ModDataComponentTypes;
import net.flugi.whiteboards.item.custom.WhiteboardItem;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SentMessage;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(SentMessage.Chat.class)
public class TheMixThatSteals {
    @Shadow @Final private SignedMessage message;

    @Inject(at = @At("HEAD"), method = "send", cancellable = true)
    public void send(ServerPlayerEntity sender, boolean filterMaskEnabled, MessageType.Parameters params, CallbackInfo ci) {

        boolean WHOAMI = Objects.equals(params.name().getString(), sender.getName().getString());
        // binding the saac
        if (sender.getMainHandStack().getItem() instanceof WhiteboardItem && WHOAMI) {
            sender.getMainHandStack().set(ModDataComponentTypes.WHITEBOARD_TEXT, message.getContent().getLiteralString());
            //ci.cancel();
        }

        for (ServerPlayerEntity plyr : sender.getEntityWorld().getPlayers()) {
            if (Objects.equals(plyr.getName().getString(), params.name().getString()) && plyr.getMainHandStack().getItem() instanceof WhiteboardItem) {
                ci.cancel();
            }
        }


    }





}


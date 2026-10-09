package net.flugi.whiteboards.item.custom;

import net.flugi.whiteboards.BigBoards;
import net.flugi.whiteboards.component.ModDataComponentTypes;
import net.flugi.whiteboards.sounds.CustomSounds;
import net.minecraft.client.render.item.model.SpecialItemModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class WhiteboardItem extends Item {
    public WhiteboardItem(Settings settings) {super(settings);}



    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 1200;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.NONE;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking() && hand != Hand.OFF_HAND
                && !(Objects.equals(user.getStackInHand(hand).get(ModDataComponentTypes.WHITEBOARD_TEXT), ""))) {


            user.getStackInHand(hand).set(ModDataComponentTypes.WHITEBOARD_TEXT,"");

            Random r = new Random();
            user.playSound(CustomSounds.ERASE, 0.5f, (8-r.nextInt(3))/10f);

        }
        return ItemUsage.consumeHeldItem(world, user, hand);
    }



}

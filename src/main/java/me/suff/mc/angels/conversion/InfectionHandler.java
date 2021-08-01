package me.suff.mc.angels.conversion;

import me.suff.mc.angels.WeepingAngels;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = WeepingAngels.MODID)
public class InfectionHandler {

    @SubscribeEvent
    public static void onAttachInfection(AttachCapabilitiesEvent<Entity> capabilitiesEvent) {
        if (capabilitiesEvent.getObject() instanceof Player) {
            capabilitiesEvent.addCapability(new ResourceLocation(WeepingAngels.MODID, "infection"), new ICapabilitySerializable<CompoundTag>() {
                final AngelInfection angelInfection = new AngelInfection((LivingEntity) capabilitiesEvent.getObject());
                final LazyOptional<AngelVirus> infectionInstance = LazyOptional.of(() -> angelInfection);

                @Nonnull
                @Override
                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
                    return cap == AngelInfection.CAPABILITY ? (LazyOptional<T>) infectionInstance : LazyOptional.empty();
                }

                @Override
                public CompoundTag serializeNBT() {
                    return angelInfection.serializeNBT();
                }

                @Override
                public void deserializeNBT(CompoundTag nbt) {
                    angelInfection.deserializeNBT(nbt);
                }
            });
        }
    }

    @SubscribeEvent
    public static void onTickInfection(LivingEvent.LivingUpdateEvent livingEvent) {
        if(livingEvent.getEntityLiving() instanceof Player player){
            AngelInfection.get(player).ifPresent(AngelVirus::tick);
        }
    }

}

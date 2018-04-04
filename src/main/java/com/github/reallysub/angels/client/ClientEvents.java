package com.github.reallysub.angels.client;

import com.github.reallysub.angels.client.particles.ParticleAngelAppearance;
import com.github.reallysub.angels.events.EventTeleport;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void teleportEvent(EventTeleport e) {
		EntityPlayer player = e.getPlayer();
		Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleAngelAppearance(player.world, player.posX, player.posY, player.posZ));
	}
}
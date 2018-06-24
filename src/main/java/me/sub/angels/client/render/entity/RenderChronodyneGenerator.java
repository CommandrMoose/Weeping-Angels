package me.sub.angels.client.render.entity;

import me.sub.angels.client.models.entity.ModelCG;
import me.sub.angels.common.WAObjects.WAItems;
import me.sub.angels.common.entities.EntityChronodyneGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class RenderChronodyneGenerator extends RenderSnowball<EntityChronodyneGenerator> {
	
	public RenderChronodyneGenerator() {
		super(Minecraft.getMinecraft().getRenderManager(), WAItems.CHRONODYNE_GENERATOR, null);
	}
	
	private ModelCG model = new ModelCG();
	
	@Override
	public void doRender(EntityChronodyneGenerator entity, double x, double y, double z, float par8, float par9) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y - 1.3, z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.disableFog();
		GlStateManager.disableLighting();
		model.render(entity, 0, 0, 0, 0, 0, 0.0625F);
		GlStateManager.enableFog();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}
	
}
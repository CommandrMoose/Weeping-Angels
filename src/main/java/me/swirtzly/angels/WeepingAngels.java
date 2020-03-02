package me.swirtzly.angels;

import me.swirtzly.angels.common.WAObjects;
import me.swirtzly.angels.common.misc.FortuneEnchantBonus;
import me.swirtzly.angels.common.world.WorldGen;
import me.swirtzly.angels.config.WAConfig;
import me.swirtzly.angels.network.Network;
import me.swirtzly.angels.utils.ClientUtil;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("weeping_angels")
public class WeepingAngels {
	
	public static final String MODID = "weeping_angels";
	public static final String NAME = "Weeping Angels";

	public static Logger LOGGER = LogManager.getLogger(NAME);

	public WeepingAngels() {
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WAConfig.CONFIG_SPEC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff));
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onNewRegistries(RegistryEvent.NewRegistry e) {
		WAObjects.Sounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.Blocks.BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.EntityEntries.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.Tiles.TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
		WAObjects.WorldGenEntries.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}


	private void setup(final FMLCommonSetupEvent event) {
		WorldGen.applyFeatures();
		LootFunctionManager.registerFunction(new FortuneEnchantBonus.Serializer());
		Network.init();
	}


	private void doClientStuff(final FMLClientSetupEvent event) {
		DistExecutor.runWhenOn(Dist.CLIENT, () -> ClientUtil::doClientStuff);
	}

}

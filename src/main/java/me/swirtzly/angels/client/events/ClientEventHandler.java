package me.swirtzly.angels.client.events;

import me.swirtzly.angels.WeepingAngels;
import me.swirtzly.angels.client.models.item.ModelDetector;
import me.swirtzly.angels.client.renders.items.RenderItemStackBase;
import me.swirtzly.angels.common.WAObjects;
import me.swirtzly.angels.utils.RenderUtil;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = WeepingAngels.MODID)
public class ClientEventHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent ev) {
        WAObjects.ITEMS.forEach(RenderUtil::setItemRender);

        WAObjects.ITEMS = new ArrayList<>();
        RenderUtil.setItemRender(WAObjects.Items.TIMEY_WIMEY_DETECTOR, new RenderItemStackBase(new ModelDetector()));
    }

}
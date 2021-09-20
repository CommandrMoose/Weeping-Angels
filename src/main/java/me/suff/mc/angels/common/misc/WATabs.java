package me.suff.mc.angels.common.misc;

import me.suff.mc.angels.common.WAObjects;
import me.suff.mc.angels.common.entities.AngelEnums;
import me.suff.mc.angels.common.items.AngelSpawnerItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WATabs {

    public static CreativeModeTab MAIN_TAB = new CreativeModeTab("angels") {
        @Override
        public ItemStack makeIcon() {
            return AngelSpawnerItem.setType(new ItemStack(WAObjects.Items.ANGEL_SPAWNER), AngelEnums.AngelType.ANGELA_MC);
        }
    };

}

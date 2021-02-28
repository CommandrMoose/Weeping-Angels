package me.swirtzly.minecraft.angels.data;

import me.swirtzly.minecraft.angels.WeepingAngels;
import me.swirtzly.minecraft.angels.common.WAObjects;
import me.swirtzly.minecraft.angels.utils.AngelUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.material.Material;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class WABlockTags extends BlockTagsProvider {


    public WABlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, WeepingAngels.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        add(BlockTags.STONE_BRICKS, WAObjects.Blocks.SNOW_ANGEL.get(), WAObjects.Blocks.STATUE.get(), WAObjects.Blocks.PLINTH.get());
        add(AngelUtils.BANNED_BLOCKS, Blocks.MAGMA_BLOCK, Blocks.GLOWSTONE, Blocks.SEA_LANTERN);

        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if(block.getRegistryName().getNamespace().contains("tardis")) continue;
            if (block.getDefaultState().getMaterial() == Material.AIR || block instanceof FireBlock) {
                add(AngelUtils.BANNED_BLOCKS, block);
            }

            if (block instanceof FlowerPotBlock) {
                add(AngelUtils.POTTED_PLANTS, block);
            }

            if (!block.getDefaultState().isSolid()) {
                add(AngelUtils.ANGEL_IGNORE, block);
            }
        }
    }

    public void add(ITag.INamedTag< Block > branch, Block block) {
        this.getOrCreateBuilder(branch).add(block);
    }

    public void add(ITag.INamedTag< Block > branch, Block... block) {
        this.getOrCreateBuilder(branch).add(block);
    }
}
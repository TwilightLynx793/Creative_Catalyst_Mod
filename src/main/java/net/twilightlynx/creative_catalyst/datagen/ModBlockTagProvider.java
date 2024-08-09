package net.twilightlynx.creative_catalyst.datagen;

import net.twilightlynx.creative_catalyst.CreativeCatalyst;
import net.twilightlynx.creative_catalyst.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreativeCatalyst.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CITRINE_BLOCK.get())
                .add(ModBlocks.RAW_CITRINE_BLOCK.get())
                .add(ModBlocks.CITRINE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITRINE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CITRINE_BLOCK.get())
                .add(ModBlocks.CITRINE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CITRINE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_CITRINE_BLOCK.get());

        /*tag(BlockTags.FENCES).add(ModBlocks.BLACK_OPAL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLACK_OPAL_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BLACK_OPAL_WALL.get());*/
    }
}
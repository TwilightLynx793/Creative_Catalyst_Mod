package net.twilightlynx.creative_catalyst.datagen;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.twilightlynx.creative_catalyst.block.ModBlocks;
import net.twilightlynx.creative_catalyst.CreativeCatalyst;
import net.twilightlynx.creative_catalyst.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CITRINE_SMELTABLES = List.of(ModItems.RAW_CITRINE, ModBlocks.CITRINE_ORE,
                ModBlocks.DEEPSLATE_CITRINE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CITRINE_BLOCK.get())
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .define('$', ModItems.CITRINE.get())
                .unlockedBy("has_citrine", has(ModItems.CITRINE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CITRINE_BLOCK.get())
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .define('$', ModItems.RAW_CITRINE.get())
                .unlockedBy("has_raw_citrine", has(ModItems.RAW_CITRINE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAMBURGER.get())
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" B ")
                .define('B', Items.BREAD)
                .define('S', Items.COOKED_BEEF)
                .unlockedBy("has_cooked_beef", has(Items.COOKED_BEEF)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FRENCH_FRIES.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" V ")
                .define('P', Items.BAKED_POTATO)
                .define('V', ModItems.FRENCH_FRY_PACKET)
                .unlockedBy("has_baked_potato", has(Items.BAKED_POTATO)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FRENCH_FRY_PACKET.get())
                .pattern("   ")
                .pattern("# #")
                .pattern(" R ")
                .define('#', Items.PAPER)
                .define('R', Items.RED_DYE)
                .unlockedBy("has_paper", has(Items.PAPER)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CITRINE.get(), 9)
                .requires(ModBlocks.CITRINE_BLOCK.get())
                .unlockedBy("has_citrine_block", has(ModBlocks.CITRINE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CITRINE.get(), 9)
                .requires(ModBlocks.RAW_CITRINE_BLOCK.get())
                .unlockedBy("has_raw_citrine_block", has(ModBlocks.CITRINE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CITRINE_POWDER.get(), 4)
                .requires(ModItems.CITRINE.get())
                .unlockedBy("has_citrine", has(ModBlocks.CITRINE_BLOCK.get())).save(pRecipeOutput);


        oreSmelting(pRecipeOutput, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE.get(), 0.25f, 200, "black_opal");
        oreBlasting(pRecipeOutput, CITRINE_SMELTABLES, RecipeCategory.MISC, ModItems.CITRINE.get(), 0.25f, 100, "black_opal");

    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, CreativeCatalyst.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
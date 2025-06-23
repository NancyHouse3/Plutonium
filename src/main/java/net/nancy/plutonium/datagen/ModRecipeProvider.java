package net.nancy.plutonium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.ModItems;
import net.nancy.plutonium.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> NICCIUM_SMELTABLES = List.of(
            ModItems.RAW_NICCIUM,
            ModBlocks.NICCIUM_ORE,
            ModBlocks.DEEPSLATE_NICCIUM_ORE
    );
    private static List<ItemConvertible> URANIUM_SMELTABLES = List.of(
            ModItems.RAW_URANIUM,
            ModBlocks.URANIUM_ORE,
            ModBlocks.URANIUM_DEEPSLATE_ORE
    );
    private static List<ItemConvertible> JUNGLE_TO_POLYMER = List.of(
            Blocks.JUNGLE_LEAVES,
            Items.JUNGLE_SAPLING
    );
    private static List<ItemConvertible> FOSSIL_FUEL_TO_GAS = List.of(
            Items.COAL,
            Items.CHARCOAL,
            Items.ROTTEN_FLESH
    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(
                exporter,
                NICCIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.NICCIUM_INGOT,
                8.0f,
                250,
                "niccium"
        );
        offerBlasting(
                exporter,
                NICCIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.NICCIUM_INGOT,
                1.2f,
                125,
                "niccium"
        );
        offerSmelting(
                exporter,
                URANIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.URANIUM_INGOT,
                0.7f,
                200,
                "uranium"
        );
        offerBlasting(
                exporter,
                URANIUM_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.URANIUM_INGOT,
                0.9f,
                100,
                "uranium"
        );
        offerSmelting(
                exporter,
                JUNGLE_TO_POLYMER,
                RecipeCategory.MISC,
                ModItems.POLYMER,
                0.7f,
                175,
                "polymer"
        );
        offerBlasting(
                exporter,
                FOSSIL_FUEL_TO_GAS,
                RecipeCategory.MISC,
                ModItems.GASOLINE,
                0.7f,
                175,
                "gasoline"
        );

        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.URANIUM_INGOT,
                RecipeCategory.DECORATIONS,
                ModBlocks.URANIUM_BLOCK
        );
        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.NICCIUM_INGOT,
                RecipeCategory.DECORATIONS,
                ModBlocks.NICCIUM_BLOCK
        );

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.METAL_DETECTOR,
                1)
                .pattern("P  ")
                .pattern("AGP")
                .pattern("CRP")
                .input('P',ModItems.POLYMER)
                .input('G',Items.GLASS_PANE)
                .input('C',Items.COPPER_INGOT)
                .input('A',Items.GOLD_INGOT)
                .input('R',Items.REDSTONE)
                .criterion(hasItem(ModItems.POLYMER),conditionsFromItem(ModItems.POLYMER))
                .criterion(hasItem(Items.GLASS_PANE),conditionsFromItem(Items.GLASS_PANE))
                .criterion(hasItem(Items.COPPER_INGOT),conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.GOLD_INGOT),conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.REDSTONE),conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.METAL_DETECTOR)))
        ;

        /*
         */
        ShapedRecipeJsonBuilder.create(
                RecipeCategory.DECORATIONS,
                ModBlocks.SECURITY_DOOR,
                2)
                .pattern("III")
                .pattern("RCR")
                .pattern("IRI")
                .input('I',Items.IRON_INGOT)
                .input('R',Items.REDSTONE)
                .input('C',Items.YELLOW_CONCRETE)
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.GOLD_INGOT),conditionsFromItem(Items.YELLOW_CONCRETE))
                .criterion(hasItem(Items.REDSTONE),conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.SECURITY_DOOR)))
        ;

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModBlocks.GRATE_BLOCK,
                12)
                .pattern("IBI")
                .pattern("BIB")
                .pattern("IBI")
                .input('I',Items.IRON_INGOT)
                .input('B',Items.IRON_BARS)
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_BARS),conditionsFromItem(Items.IRON_BARS))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.GRATE_BLOCK)))
        ;

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.NICCIUM_PICKAXE,
                1)
                .pattern("NNN")
                .pattern(" S ")
                .pattern(" S ")
                .input('N',ModItems.NICCIUM_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.NICCIUM_INGOT),conditionsFromItem(ModItems.NICCIUM_INGOT))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.NICCIUM_PICKAXE)))
        ;
        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.NICCIUM_AXE,
                1)
                .pattern("NN ")
                .pattern("NS ")
                .pattern(" S ")
                .input('N',ModItems.NICCIUM_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.NICCIUM_INGOT),conditionsFromItem(ModItems.NICCIUM_INGOT))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.NICCIUM_AXE)))
        ;
        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.NICCIUM_SHOVEL,
                1)
                .pattern(" N ")
                .pattern(" S ")
                .pattern(" S ")
                .input('N',ModItems.NICCIUM_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.NICCIUM_INGOT),conditionsFromItem(ModItems.NICCIUM_INGOT))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.NICCIUM_SHOVEL)))
        ;
        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.NICCIUM_SWORD,
                1)
                .pattern(" N ")
                .pattern(" N ")
                .pattern(" S ")
                .input('N',ModItems.NICCIUM_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.NICCIUM_INGOT),conditionsFromItem(ModItems.NICCIUM_INGOT))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.NICCIUM_SWORD)))
        ;
        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC,
                ModItems.NICCIUM_HOE,
                1)
                .pattern(" NN")
                .pattern(" S ")
                .pattern(" S ")
                .input('N',ModItems.NICCIUM_INGOT)
                .input('S',Items.STICK)
                .criterion(hasItem(ModItems.NICCIUM_INGOT),conditionsFromItem(ModItems.NICCIUM_INGOT))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.NICCIUM_HOE)))
        ;

        createStairsRecipe(ModBlocks.GRATE_STAIRS, Ingredient.ofItems(ModBlocks.GRATE_BLOCK))
                .criterion(hasItem(ModBlocks.GRATE_BLOCK),conditionsFromItem(ModBlocks.GRATE_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.GRATE_STAIRS)))
        ;

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRATE_SLAB, Ingredient.ofItems(ModBlocks.GRATE_BLOCK))
                .criterion(hasItem(ModBlocks.GRATE_BLOCK),conditionsFromItem(ModBlocks.GRATE_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.GRATE_SLAB)))
        ;
    }
}

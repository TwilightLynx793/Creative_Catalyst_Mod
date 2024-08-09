package net.twilightlynx.creative_catalyst.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.twilightlynx.creative_catalyst.CreativeCatalyst;
import net.twilightlynx.creative_catalyst.item.template.FuelItem;
import net.twilightlynx.creative_catalyst.item.template.ModFoodProperties;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreativeCatalyst.MOD_ID);

    public static final DeferredItem<Item> CITRINE = ITEMS.registerItem("citrine",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_CITRINE = ITEMS.registerItem("raw_citrine",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> CITRINE_POWDER = ITEMS.registerItem("citrine_powder",
            properties -> new FuelItem(properties, 800), new Item.Properties());

    public static final DeferredItem<Item> HAMBURGER =
            ITEMS.registerItem("hamburger", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                        pTooltipComponents.add(Component.translatable("tooltip.creative_catalyst.food.hamburger"));
                        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.HAMBURGER));

    public static final DeferredItem<Item> FRENCH_FRIES =
            ITEMS.registerItem("french_fries", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.creative_catalyst.food.french_fries"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.FRENCH_FIES));

    public static final DeferredItem<Item> FRENCH_FRY_PACKET = ITEMS.registerItem("french_fry_packet",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}

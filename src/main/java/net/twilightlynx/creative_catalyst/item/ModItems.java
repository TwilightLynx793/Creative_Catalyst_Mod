package net.twilightlynx.creative_catalyst.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.twilightlynx.creative_catalyst.CreativeCatalyst;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreativeCatalyst.MOD_ID);

    public static final DeferredItem<Item> CITRINE = ITEMS.registerItem("citrine",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_CITRINE = ITEMS.registerItem("raw_citrine",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}

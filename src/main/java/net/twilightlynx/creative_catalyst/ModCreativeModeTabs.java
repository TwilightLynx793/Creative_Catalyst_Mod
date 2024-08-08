package net.twilightlynx.creative_catalyst;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.twilightlynx.creative_catalyst.block.ModBlocks;
import net.twilightlynx.creative_catalyst.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreativeCatalyst.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("tab.creative_catalyst.modtab"))
                    .icon(() -> new ItemStack(ModItems.CITRINE.get()))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.CITRINE.get());
                        pOutput.accept(ModItems.RAW_CITRINE.get());

                        pOutput.accept(ModBlocks.CITRINE_BLOCK);
                        pOutput.accept(ModBlocks.RAW_CITRINE_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

package net.astro.dlc.event;

import net.astro.dlc.DLC;
import net.astro.dlc.event.loot.IceDiscFromSnowyBiome;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.NewRegistryEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = DLC.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    /*@SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final NewRegistryEvent event){
        event.getRegistry().registerAll(
                new IceDiscFromSnowyBiome.Serializer().setRegistryName(new ResourceLocation(DLC.MOD_ID, "ice_disc_from_snowy_biome"))
                // Aggiungi altri qui
        );
    }*/
}

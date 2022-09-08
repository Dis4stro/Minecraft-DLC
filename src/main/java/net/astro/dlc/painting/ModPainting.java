package net.astro.dlc.painting;

import net.astro.dlc.DLC;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPainting {
    public static final DeferredRegister<PaintingVariant> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DLC.MOD_ID);

    public static final RegistryObject<PaintingVariant> DEEP_PORTAL =
            PAINTING_MOTIVES.register("deep_portal", () -> new PaintingVariant(48,32)); // 3x2

    public static final RegistryObject<PaintingVariant> DISAPPOINTMENT =
            PAINTING_MOTIVES.register("disappointment", () -> new PaintingVariant(32,48)); // 2x3

    public static void register(IEventBus eventbus){
        PAINTING_MOTIVES.register(eventbus);
    }
}

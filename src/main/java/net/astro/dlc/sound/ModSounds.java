package net.astro.dlc.sound;

import net.astro.dlc.DLC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DLC.MOD_ID);

    public static final RegistryObject<SoundEvent> BATTERY_DIED = registerSoundEvent("battery_died");
    public static final RegistryObject<SoundEvent> ICE_DISC = registerSoundEvent("ice_disc");
    public static final RegistryObject<SoundEvent> ENDER_DRAGON_DISC = registerSoundEvent("ender_dragon_disc");
    public static final RegistryObject<SoundEvent> LUSH_DISC = registerSoundEvent("lush_disc");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(DLC.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}

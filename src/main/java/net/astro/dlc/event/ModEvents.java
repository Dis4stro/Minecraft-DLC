package net.astro.dlc.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.astro.dlc.DLC;
import net.astro.dlc.capabilities.PlayerFreezeState;
import net.astro.dlc.capabilities.PlayerFreezeStateProvider;
import net.astro.dlc.client.ClientData;
import net.astro.dlc.effect.ModEffects;
import net.astro.dlc.item.ModItems;
import net.astro.dlc.networking.ModNetworking;
import net.astro.dlc.networking.packet.FreezeDataSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DLC.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.UNRIPE_TOMATO.get(), 12), 10, 6, 0.01f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.HALF_MATURE_TOMATO.get(), 5), 10, 8, 0.02f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.MATURE_TOMATO.get(), 4), 10, 12, 0.02f));
        }
        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 4, 12, 0.09f));
        }
        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.BRONZE_SWORD.get(), 1), 4, 8 , 0.09f));
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilityPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerFreezeStateProvider.PLAYER_FREEZE_STATE).isPresent()) {
                event.addCapability(new ResourceLocation(DLC.MOD_ID, "properties"), new PlayerFreezeStateProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PlayerFreezeStateProvider.PLAYER_FREEZE_STATE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerFreezeStateProvider.PLAYER_FREEZE_STATE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerFreezeState.class);
    }

    @SubscribeEvent
    public static void freezeDigSlowdown(PlayerEvent.BreakSpeed event) {
        if(ClientData.getIsFrozen()) {
            float effetAmplifier = (float) event.getEntity().getActiveEffectsMap().get(ModEffects.FREEZING.get()).getAmplifier();
            event.setNewSpeed(event.getNewSpeed() * Math.max(0.1F, (1f - ((effetAmplifier + 1) * 0.3f))));
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerFreezeStateProvider.PLAYER_FREEZE_STATE).ifPresent(freeze -> {
                if(event.player.getActiveEffectsMap().containsKey(ModEffects.FREEZING.get())) {
                    if (!freeze.getIsFrozen()) {
                        freeze.setIsFrozen(true);
                    }
                } else {
                    if(freeze.getIsFrozen()) {
                        freeze.setIsFrozen(false);
                    }
                }
                ModNetworking.sendToPlayer(new FreezeDataSyncS2CPacket(freeze.getIsFrozen()), (ServerPlayer) event.player);
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()){
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerFreezeStateProvider.PLAYER_FREEZE_STATE).ifPresent(freeze -> {
                    ModNetworking.sendToPlayer(new FreezeDataSyncS2CPacket(freeze.getIsFrozen()), player);
                });
            }
        }
    }
}

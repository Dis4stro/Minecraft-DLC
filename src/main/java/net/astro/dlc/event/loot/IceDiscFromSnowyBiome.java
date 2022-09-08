package net.astro.dlc.event.loot;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IceDiscFromSnowyBiome extends LootModifier {
    private final Item addition;

    protected IceDiscFromSnowyBiome(LootItemCondition[] conditionsIn, Item addition){
        super(conditionsIn);
        this.addition = addition;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // generatedLoot è il loot classico vanilla, per aggiungere loot basta fare generatedLoot.add(new itemStack(item, quantità)))
        if(context.getRandom().nextFloat() > 0.5f) { // 50%
            generatedLoot.add(new ItemStack(addition, 1));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return null;
    }

    /*public static class Serializer extends GlobalLGlobalLootModifierSerializer<IceDiscFromSnowyBiome>{

        @Override
        public IceDiscFromSnowyBiome read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new IceDiscFromSnowyBiome(ailootcondition, addition);
        }

        @Override
        public JsonObject write(IceDiscFromSnowyBiome instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }*/
}

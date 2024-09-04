package org.william.morefoods.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.william.morefoods.MoreFoods;

public class FoodsItem {
    public static final FoodComponent HIGH_COMPONENT = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(0.8f)
            .build();

    public static final FoodComponent MEDIUM_COMPONENT = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(0.6f)
            .build();

    public static final FoodComponent LOW_COMPONENT = new FoodComponent.Builder()
            .nutrition(2)
            .snack()
            .saturationModifier(0.3f)
            .build();

    public static Item registerItem(Item item, String id) {
        Identifier itemID = Identifier.of(MoreFoods.MOD_ID, id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;
    }

    // registerItem() insert item in the game
    public static final Item chips = registerItem(new Item(new Item.Settings().food(MEDIUM_COMPONENT)), "chips");
    public static final Item coconut = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "coconut");
    public static final Item pineapple = registerItem(new Item(new Item.Settings().food(MEDIUM_COMPONENT)), "pineapple");
    public static final Item scooby = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "scooby");
    public static final Item tacos = registerItem(new Item(new Item.Settings().food(HIGH_COMPONENT)), "tacos");
    public static final Item pizza = registerItem(new Item(new Item.Settings().food(HIGH_COMPONENT)), "pizza");
    public static final Item sushi = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "sushi");
    public static final Item tomato = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "tomato");
    public static final Item blueberries = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "blueberries");
    public static final Item cookiecat = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "cookiecat");
    public static final Item grapes = registerItem(new Item(new Item.Settings().food(LOW_COMPONENT)), "grapes");
    public static final Item hamburguer = registerItem(new Item(new Item.Settings().food(HIGH_COMPONENT)), "hamburguer");
    public static final Item popcorn = registerItem(new Item(new Item.Settings().food(HIGH_COMPONENT)), "popcorn");
    public static final Item soda = registerItem(new Item(new Item.Settings().food(MEDIUM_COMPONENT)), "soda");

    public static final RegistryKey<ItemGroup> CUSTOM_FOODS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MoreFoods.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_FOODS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FoodsItem.coconut))
            .displayName(Text.translatable("itemGroup.MoreFoods"))
            .build();

    public static void register() {
        MoreFoods.LOGGER.info("loading... " + MoreFoods.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, CUSTOM_FOODS_KEY, CUSTOM_FOODS);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_FOODS_KEY).register(ItemGroup -> {

            Item[] array = {chips, coconut, pineapple, pizza, scooby, sushi, tomato, blueberries, cookiecat, grapes, hamburguer, popcorn, soda};

            for(Item n:array) {
                ItemGroup.add(n);
            }
        });
    }
}

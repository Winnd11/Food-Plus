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
    //create food(FoodComponent foodComponent) Settings!!
    public static final FoodComponent chips_component = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.6f)
            .build();

    public static final FoodComponent COCONUT_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.7f)
            .build();

    public static final FoodComponent PINEAPPLE_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .build();

    public static final FoodComponent SCOOBY_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.8f)
            .snack()
            .build();

    public static final FoodComponent TACOS_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .snack()
            .build();

    public static final FoodComponent PIZZA_COMPONENT = new FoodComponent.Builder()
            .snack()
            .nutrition(8)
            .saturationModifier(0.3f)
            .build();

    public static final FoodComponent SUSHI_COMPONENT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.8f)
            .build();

    public static final FoodComponent TOMATO_COMPONENT = new FoodComponent.Builder()
            .snack()
            .nutrition(2)
            .saturationModifier(0.3f)
            .build();

    public static Item registerItem(Item item, String id) {
        Identifier itemID = Identifier.of(MoreFoods.MOD_ID, id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;
    }

    // registerItem() insert item in the game
    public static final Item chips = registerItem(new Item(new Item.Settings().food(chips_component)), "chips");
    public static final Item coconut = registerItem(new Item(new Item.Settings().food(COCONUT_COMPONENT)), "coconut");
    public static final Item pineapple = registerItem(new Item(new Item.Settings().food(PINEAPPLE_COMPONENT)), "pineapple");
    public static final Item scooby = registerItem(new Item(new Item.Settings().food(SCOOBY_COMPONENT)), "scooby");
    public static final Item tacos = registerItem(new Item(new Item.Settings().food(TACOS_COMPONENT)), "tacos");
    public static final Item pizza = registerItem(new Item(new Item.Settings().food(PIZZA_COMPONENT)), "pizza");
    public static final Item sushi = registerItem(new Item(new Item.Settings().food(SUSHI_COMPONENT)), "sushi");
    public static final Item tomato = registerItem(new Item(new Item.Settings().food(TOMATO_COMPONENT)), "tomato");

    public static final RegistryKey<ItemGroup> CUSTOM_FOODS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MoreFoods.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_FOODS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FoodsItem.coconut))
            .displayName(Text.translatable("Foods"))
            .build();

    public static void register() {
        MoreFoods.LOGGER.info("loading... " + MoreFoods.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, CUSTOM_FOODS_KEY, CUSTOM_FOODS);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_FOODS_KEY).register(ItemGroup -> {
            ItemGroup.add(FoodsItem.chips);
            ItemGroup.add(FoodsItem.coconut);
            ItemGroup.add(FoodsItem.pineapple);
            ItemGroup.add(FoodsItem.pizza);
            ItemGroup.add(FoodsItem.scooby);
            ItemGroup.add(FoodsItem.sushi);
            ItemGroup.add(FoodsItem.tomato);
        });
    }
}

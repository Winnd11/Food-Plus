package org.william.morefoods;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.william.morefoods.item.FoodsItem;

public class MoreFoods implements ModInitializer {
	public static final String MOD_ID = "morefoods";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FoodsItem.register();
	}
}
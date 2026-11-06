package com.nodeath;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.server.network.ServerPlayerEntity;

public class NoDeath implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof ServerPlayerEntity) {
                // Void tetap diizinkan supaya kamu tidak jatuh selamanya
                return source.isOf(DamageTypes.OUT_OF_WORLD);
            }
            return true;
        });
    }
}

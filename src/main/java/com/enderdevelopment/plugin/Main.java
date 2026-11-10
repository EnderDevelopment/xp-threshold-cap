package com.enderdevelopment.plugin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Main.MOD_ID)
public final class Main {
    public static final String MOD_ID = "singleplayer_xp_cap";
    private static final int XP_THRESHOLD = 128;

    public Main() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onExperienceChange(PlayerXpEvent.XpChange event) {
        if (event.getEntity() instanceof ServerPlayer player && isSingleplayer(player)) {
            if (nextLevelRequirement(player.experienceLevel) > XP_THRESHOLD) {
                event.setAmount(0);
                clamp(player);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof ServerPlayer player && isSingleplayer(player)) {
            clamp(player);
        }
    }

    private boolean isSingleplayer(ServerPlayer player) {
        MinecraftServer server = player.getServer();
        return server != null && server.isSingleplayer();
    }

    private void clamp(ServerPlayer player) {
        if (nextLevelRequirement(player.experienceLevel) > XP_THRESHOLD) {
            player.experienceLevel = 32;
            player.experienceProgress = 0.0f;
            player.totalExperience = totalExperienceAtLevel(32);
        }
    }

    private int totalExperienceAtLevel(int level) {
        if (level >= 32) {
            return 4 * level * level - 40 * level + 360;
        }
        if (level >= 17) {
            return (int) (2.5 * level * level - 40.5 * level + 360);
        }
        return level * level + 6 * level;
    }

    private int nextLevelRequirement(int level) {
        if (level >= 32) {
            return 9 * level - 158;
        }
        if (level >= 16) {
            return 5 * level - 38;
        }
        return 2 * level + 7;
    }
}

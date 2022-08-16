package com.ocawesome;

import com.mojang.blaze3d.audio.Channel;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import com.mojang.blaze3d.audio.Library;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.lwjgl.openal.AL10;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Set;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("moresounds")
public class Moresounds {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Moresounds() {
        // Register the setup method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::sounds);
    }
/*
    @SubscribeEvent
    public void sounds(FMLLoadCompleteEvent event) {
        SoundEngine soundEngine = Minecraft.getInstance().getSoundManager().soundEngine;
        Library library = soundEngine.library;
        ChannelPoolAccessor.class.cast(Object.class.cast(library.staticChannels)).setLimit(1024);
//        Field soundEngineField = SoundManager.class.getDeclaredField("soundEngine");
//        soundEngineField.setAccessible(true);
//        SoundEngine soundEngine = (SoundEngine)(soundEngineField.get(soundManager));
    }

    @Mixin(targets = "com.mojang.blaze3d.audio.Library$1")
    public interface ChannelPoolAccessor {
        void setLimit(int pLimit);
    }


 */

    /*@Mixin(targets = "com.mojang.blaze3d.audio.Library$CountingChannelPool")
    abstract class MixinCountingChannelPool implements Library.ChannelPool {
        @Inject(method = "<init>(I)V;", at = @At("HEAD"))
        private void injected(int pLimit, CallbackInfo ci) {
            ((Library.CountingChannelPool)(Object)this).limit = pLimit;
            LOGGER.info("Set pLimit!");
            ci.cancel();
        }
    }*/
}
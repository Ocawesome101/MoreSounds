package com.ocawesome.mixins;

import com.mojang.blaze3d.audio.Channel;
import com.mojang.blaze3d.audio.Library;
import com.mojang.logging.LogUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Set;

@Mixin(targets = "com.mojang.blaze3d.audio.Library$CountingChannelPool")
abstract class MixinCountingChannelPool implements Library.ChannelPool {
    @Shadow
    private Set<Channel> activeChannels;

    @Inject(at = @At("HEAD"), method = "acquire()Lcom/mojang/blaze3d/audio/Channel;")
    private void acquire(CallbackInfoReturnable<Channel> callback) {
        @Nullable
        Channel channel = Channel.create();
        Library.CountingChannelPool self = (Library.CountingChannelPool) (Object) this;
        if (channel != null) {
            self.activeChannels.add(channel);
        }
        LogUtils.getLogger().info("ALLOCATED CHANNEL");
        callback.setReturnValue(channel);
        callback.cancel();
    }
}
package net.veroxuniverse.samurai_dynasty.worldgen.features.decorators;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import java.util.function.Supplier;

public class ModDecoratorTypes {

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(BuiltInRegistries.TREE_DECORATOR_TYPE, SamuraiDynastyMod.MOD_ID);

    public static final Supplier<TreeDecoratorType<LeavesAwareAttachedToLogsDecorator>> LEAVES_ATTACHED_TO_LOGS = register("leaves_attached_to_logs", LeavesAwareAttachedToLogsDecorator.CODEC);

    private static <P extends TreeDecorator> Supplier<TreeDecoratorType<P>> register(String id, MapCodec<P> codec) {
        return TREE_DECORATORS.register(id, () -> new TreeDecoratorType<>(codec));
    }

    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }

}


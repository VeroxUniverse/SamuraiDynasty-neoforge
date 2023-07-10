package net.veroxuniverse.epicsamurai.item.armor;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.goggles.GoggleConfigScreen;
import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import com.simibubi.create.content.equipment.goggles.GogglesModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.ModList;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.create.BrassSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BrassSamuraiArmorItem extends SamuraiArmorItem {

    private static final List<Predicate<Player>> IS_WEARING_PREDICATES = new ArrayList();

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        if (ModList.get().isLoaded("create")) {
            consumer.accept(new IClientItemExtensions() {
                private BrassSamuraiArmorRenderer renderer;

                @Override
                public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                       EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                    if (this.renderer == null)
                        this.renderer = new BrassSamuraiArmorRenderer();

                    this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                    return this.renderer;
                }
            });
        }
    }

    public BrassSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    public static boolean isWearingGoggles(Player player) {
        Iterator var1 = IS_WEARING_PREDICATES.iterator();

        Predicate predicate;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            predicate = (Predicate)var1.next();
        } while(!predicate.test(player));

        return true;
    }

    public static void addIsWearingPredicate(Predicate<Player> predicate) {
        IS_WEARING_PREDICATES.add(predicate);
    }

    static {
        addIsWearingPredicate((player) -> {
            return player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BrassSamuraiArmorItem;
        });
    }
}
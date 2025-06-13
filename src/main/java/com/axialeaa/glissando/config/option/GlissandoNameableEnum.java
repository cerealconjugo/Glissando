package com.axialeaa.glissando.config.option;

import com.axialeaa.glissando.config.GlissandoConfigScreen;
import dev.isxander.yacl3.api.NameableEnum;
import dev.isxander.yacl3.api.OptionDescription;
import net.minecraft.text.Text;

import java.util.Locale;

public interface GlissandoNameableEnum extends NameableEnum {

    String getOptionName();

    @Override
    default Text getDisplayName() {
        return this.getTranslation(false);
    }

    default OptionDescription getOptionDesc() {
        return OptionDescription.of(this.getTranslation(true));
    }

    default Text getTranslation(boolean desc) {
        String enumName = ((Enum<?>) this).name().toLowerCase(Locale.ROOT);
        return GlissandoConfigScreen.getOptionTranslation(this.getOptionName() + "." + enumName, desc);
    }

}

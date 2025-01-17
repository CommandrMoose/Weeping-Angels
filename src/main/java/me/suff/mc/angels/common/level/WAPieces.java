package me.suff.mc.angels.common.level;

import me.suff.mc.angels.common.level.structures.GraveyardStructure;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

import java.util.Locale;

public class WAPieces {

    public static StructurePieceType setPieceId(StructurePieceType p_67164_, String p_67165_) {
        return Registry.register(Registry.STRUCTURE_PIECE, p_67165_.toLowerCase(Locale.ROOT), p_67164_);
    }

    public static StructurePieceType GRAVEYARD = setPieceId(GraveyardStructure.GraveyardPiece::new, "weeping_angels:graveyard");


}
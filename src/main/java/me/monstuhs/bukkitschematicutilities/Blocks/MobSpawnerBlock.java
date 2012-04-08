package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.ShortTag;
import ch.spacebase.opennbt.tag.StringTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;

/**
 * Represents chests.
 *
 * @author sk89q
 */
public class MobSpawnerBlock extends TileEntityBlock {

    private String _entityId;
    private short _delay;

    public MobSpawnerBlock(CompoundTag tileEntityData, int type, int data) {
        super(tileEntityData, type, data);

        _entityId = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.MobSpawnerTagNames.ENTITY_ID)).getValue();
        _delay = ((ShortTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.MobSpawnerTagNames.DELAY)).getValue();

    }
}

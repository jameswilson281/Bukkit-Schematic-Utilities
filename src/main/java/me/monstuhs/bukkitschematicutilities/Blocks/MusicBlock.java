package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.ByteTag;
import ch.spacebase.opennbt.tag.CompoundTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;


public class MusicBlock extends TileEntityBlock {

    private byte _note;

    public MusicBlock(CompoundTag tileEntityData, int type, int data) {
        super(tileEntityData, type, data);
        
        _note = ((ByteTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.MusicBlockTagNames.NOTE)).getValue();
    }
}
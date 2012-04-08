package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.StringTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;

public class SignBlock extends TileEntityBlock {

    private String[] _text;
    
    public SignBlock(CompoundTag tileEntityData, int type, int data) {
        super(tileEntityData, type, data);
        
        _text[0] = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.SignBlockTagNames.TEXT_1)).getValue();
        _text[1] = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.SignBlockTagNames.TEXT_2)).getValue();
        _text[2] = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.SignBlockTagNames.TEXT_3)).getValue();
        _text[3] = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.SignBlockTagNames.TEXT_4)).getValue();
    }

    public String[] getText() {
        return _text;
    }
    
    public void setText(String[] text) {
        this._text = text;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.IntTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;

/**
 *
 * @author James
 */
public class JukeboxBlock extends TileEntityBlock {
    
    private int _record;
    
    public JukeboxBlock(CompoundTag tileEntityData, int type, int data){
        super(tileEntityData, type, data);
        
        _record = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.JukeboxTagNames.RECORD)).getValue();
    }
}

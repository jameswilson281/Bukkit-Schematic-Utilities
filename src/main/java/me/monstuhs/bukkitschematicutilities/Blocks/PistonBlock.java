/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.ByteTag;
import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.FloatTag;
import ch.spacebase.opennbt.tag.IntTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;

/**
 *
 * @author James
 */
public class PistonBlock extends TileEntityBlock {
    
    private int _blockId;
    private int _blockData;
    private int _facing;
    private float _progress;
    private byte _extending;
    
    public PistonBlock(CompoundTag tileEntityData, int type, int data){
        super(tileEntityData, type, data);
        
        _blockId = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.PistonTagNames.BLOCK_ID)).getValue();
        _blockData = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.PistonTagNames.BLOCK_DATA)).getValue();
        _facing = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.PistonTagNames.FACING)).getValue();
        _progress = ((FloatTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.PistonTagNames.PROGRESS)).getValue();
        _extending = ((ByteTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.PistonTagNames.EXTENDING)).getValue();
    }
}

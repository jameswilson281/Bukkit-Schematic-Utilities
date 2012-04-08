/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.CompoundTag;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;

/**
 *
 * @author James
 */
public class EnchantmentTableBlock extends TileEntityBlock {
    
    public EnchantmentTableBlock(CompoundTag tileEntityData, int type, int data){
        super(tileEntityData, type, data);
    }
}

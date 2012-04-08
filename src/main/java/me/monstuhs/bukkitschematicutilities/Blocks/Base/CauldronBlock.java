/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities.Blocks.Base;

import ch.spacebase.opennbt.tag.*;
import java.util.List;
import me.monstuhs.bukkitschematicutilities.EntityBlockConstants;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author James
 */
public class CauldronBlock extends TileEntityBlock implements ContainerBlock {
    
    private ItemStack[] _items;
    private int _brewTime;
    
    public CauldronBlock(CompoundTag tileEntityData, int type, int data){
        super(tileEntityData, type, data);
        
        _brewTime = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.CauldronTagNames.BREW_TIME)).getValue();
        
        List<CompoundTag> items = ((ListTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.FurnaceBlockTagNames.ITEMS)).getValue();
        ItemStack[] newItems = new ItemStack[3];

        for (CompoundTag tag : items) {

            short id = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.ID)).getValue();
            short damage = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.DAMAGE)).getValue();
            byte count = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.COUNT)).getValue();
            byte slot = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.SLOT)).getValue();

            if (slot >= 0 && slot <= EntityBlockConstants.CAULDRON_MAX_ITEM_SLOTS) {
                newItems[slot] = new ItemStack(id, count, damage);
            }
        }
    }

    public ItemStack[] getItems() {
        return _items;
    }

    public void setItems(ItemStack[] items) {
        _items = items;
    }
}

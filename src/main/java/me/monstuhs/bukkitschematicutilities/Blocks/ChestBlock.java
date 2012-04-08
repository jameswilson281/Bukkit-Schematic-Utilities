/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.*;
import java.util.List;
import java.util.Map;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.ContainerBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.SchematicBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.EntityBlockConstants;
import me.monstuhs.bukkitschematicutilities.MinecraftSchematicTagNames;
import org.bukkit.inventory.ItemStack;

/**
 * Represents chests.
 *
 * @author sk89q
 */
public class ChestBlock extends TileEntityBlock implements ContainerBlock {

    private ItemStack[] _items;
    
    public ChestBlock(CompoundTag tileEntityData, int type, int data) {
        super(tileEntityData, type, data);
        
        List<CompoundTag> items = ((ListTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.FurnaceBlockTagNames.ITEMS)).getValue();
        ItemStack[] newItems = new ItemStack[3];

        for (CompoundTag tag : items) {

            short id = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.ID)).getValue();
            short damage = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.DAMAGE)).getValue();
            byte count = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.COUNT)).getValue();
            byte slot = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.SLOT)).getValue();

            if (slot >= 0 && slot <= EntityBlockConstants.CHEST_MAX_ITEM_SLOTS) {
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

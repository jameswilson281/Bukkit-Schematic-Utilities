package me.monstuhs.bukkitschematicutilities.Blocks;

import ch.spacebase.opennbt.tag.ByteTag;
import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.ListTag;
import ch.spacebase.opennbt.tag.ShortTag;
import java.util.List;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.ContainerBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.Constants.EntityBlockConstants;
import me.monstuhs.bukkitschematicutilities.Constants.MinecraftSchematicTagNames;
import org.bukkit.inventory.ItemStack;

/**
 * Represents dispensers.
 *
 * @author sk89q
 */
public class TrapBlock extends TileEntityBlock implements ContainerBlock {

    private ItemStack[] _items;

    public TrapBlock(CompoundTag tileEntityData, int type, int data) {
        super(tileEntityData, type, data);

        List<CompoundTag> items = ((ListTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.FurnaceBlockTagNames.ITEMS)).getValue();
        ItemStack[] newItems = new ItemStack[3];

        for (CompoundTag tag : items) {

            short id = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.ID)).getValue();
            short damage = ((ShortTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.DAMAGE)).getValue();
            byte count = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.COUNT)).getValue();
            byte slot = ((ByteTag) tag.getValue().get(MinecraftSchematicTagNames.InventoryTagNames.SLOT)).getValue();

            if (slot >= 0 && slot <= EntityBlockConstants.TRAP_MAX_ITEM_SLOTS) {
                newItems[slot] = new ItemStack(id, count, damage);
            }
        }
    }
    
    public ItemStack[] getItems() {
        return _items;
    }

    public void setItems(ItemStack[] items) {
        this._items = items;
    }
}

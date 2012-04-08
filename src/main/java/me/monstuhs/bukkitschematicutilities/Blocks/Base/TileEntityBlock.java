package me.monstuhs.bukkitschematicutilities.Blocks.Base;

import ch.spacebase.opennbt.tag.CompoundTag;
import ch.spacebase.opennbt.tag.IntTag;
import ch.spacebase.opennbt.tag.StringTag;
import me.monstuhs.bukkitschematicutilities.Constants.MinecraftSchematicTagNames;
import org.bukkit.util.Vector;

public abstract class TileEntityBlock extends SchematicBlock {

    private String _id;
    private int _xCoord;
    private int _yCoord;
    private int _zCoord;
    
    public TileEntityBlock(CompoundTag tileEntityData, int type, int data){
        super(type, data);
        
        _id = ((StringTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.ID)).getValue();
        _xCoord = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.X)).getValue();
        _yCoord = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.Y)).getValue();
        _zCoord = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.Z)).getValue();
    }
    
    public Vector getVector(){
        return new Vector(_xCoord, _yCoord, _zCoord);
    }
    
    public static Vector getVectorFromNBT(CompoundTag tileEntityData){
        int x = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.X)).getValue();
        int y = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.Y)).getValue();
        int z = ((IntTag) tileEntityData.getValue().get(MinecraftSchematicTagNames.TileEntityTagNames.Z)).getValue();
        return new Vector(x, y, z);
    }
}

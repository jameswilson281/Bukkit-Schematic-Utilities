/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities;

import ch.spacebase.opennbt.tag.CompoundTag;
import java.util.HashMap;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.CauldronBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.SchematicBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.Base.TileEntityBlock;
import me.monstuhs.bukkitschematicutilities.Blocks.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

/**
 *
 * @author James
 */
public class MinecraftSchematic {

    private SchematicBlock[][][] _schematicCube;
    private Vector _sizeVector;

    public MinecraftSchematic(Schematic schematic) {

        short width = schematic.getWidth().getValue();
        short height = schematic.getHeight().getValue();
        short length = schematic.getLength().getValue();
        byte[] blocks = schematic.getBlocks().getValue();
        byte[] blockData = schematic.getBlockData().getValue();

        _sizeVector = new Vector(width, height, length);
        _schematicCube = new SchematicBlock[_sizeVector.getBlockX()][_sizeVector.getBlockY()][_sizeVector.getBlockZ()];
        HashMap<Vector, CompoundTag> tileEntityLookup = new HashMap<Vector, CompoundTag>();

        for (CompoundTag tileEntityData : schematic.getTileEntities()) {
            tileEntityLookup.put(TileEntityBlock.getVectorFromNBT(tileEntityData), tileEntityData);
        }

        for (int xCoord = 0; xCoord < width; xCoord++) {
            for (int yCoord = 0; yCoord < height; yCoord++) {
                for (int zCoord = 0; zCoord < length; zCoord++) {
                    int blockIndex = yCoord * width * length + zCoord * width + xCoord;
                    byte id = blocks[blockIndex];
                    byte data = blockData[blockIndex];
                    SchematicBlock thisBlock;
                    switch (Material.getMaterial(id)) {
                        case CAULDRON:
                            thisBlock = new CauldronBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case CHEST:
                            thisBlock = new ChestBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case DISPENSER:
                            thisBlock = new TrapBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case ENCHANTMENT_TABLE:
                            thisBlock = new EnchantmentTableBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case ENDER_PORTAL:
                            thisBlock = new EnderPortalBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case FURNACE:
                        case BURNING_FURNACE:
                            thisBlock = new FurnaceBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case MOB_SPAWNER:
                            thisBlock = new MobSpawnerBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case NOTE_BLOCK:
                            thisBlock = new MusicBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case PISTON_BASE:
                        case PISTON_STICKY_BASE:
                        case PISTON_EXTENSION:
                        case PISTON_MOVING_PIECE:
                            thisBlock = new PistonBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case JUKEBOX:
                            thisBlock = new JukeboxBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        case SIGN:
                        case SIGN_POST:
                            thisBlock = new SignBlock(tileEntityLookup.get(new Vector(xCoord, yCoord, zCoord)), id, data);
                            break;
                        default:
                            //regular schematic block
                            thisBlock = new SchematicBlock(id, data);
                            break;
                    }
                    _schematicCube[xCoord][yCoord][zCoord] = thisBlock;
                }
            }
        }
    }

    public SchematicBlock[][][] getSchematicCube() {
        return _schematicCube;
    }

    public void placeInWorld(Location origin) {
        World thisWorld = origin.getWorld();

        for (int x = 0; x < _sizeVector.getBlockX(); ++x) {
            for (int y = 0; y < _sizeVector.getBlockY(); ++y) {
                for (int z = 0; z < _sizeVector.getBlockZ(); ++z) {                    
                    SchematicBlock newBlock = _schematicCube[x][y][z];
                    thisWorld.getBlockAt(x, y, z).setTypeIdAndData(newBlock.getType(), newBlock.getData(), true);
                }
            }
        }
    }
}

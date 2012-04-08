/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities;

import ch.spacebase.opennbt.stream.NBTInputStream;
import ch.spacebase.opennbt.tag.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import me.monstuhs.bukkitschematicutilities.Constants.MinecraftSchematicTagNames;

/**
 *
 * @author James
 */
public class Schematic {

    private CompoundTag _baseTag;
    private ShortTag _width;
    private ShortTag _length;
    private ShortTag _height;
    private StringTag _materials;
    private ByteArrayTag _blocks;
    private ByteArrayTag _blockData;
    private List<CompoundTag> _entities;
    private List<CompoundTag> _tileEntities;

    public Schematic(File schematicFile) {
        _baseTag = getSchematicTagFromNBTFile(schematicFile);

        _width = (ShortTag) _baseTag.get(MinecraftSchematicTagNames.WIDTH);
        _length = (ShortTag) _baseTag.get(MinecraftSchematicTagNames.LENGTH);
        _height = (ShortTag) _baseTag.get(MinecraftSchematicTagNames.HEIGHT);
        _blocks = (ByteArrayTag) _baseTag.get(MinecraftSchematicTagNames.BLOCKS);
        _blockData = (ByteArrayTag) _baseTag.get(MinecraftSchematicTagNames.DATA);
        
        _entities =     ((ListTag) _baseTag.get(MinecraftSchematicTagNames.ENTITIES)).getValue();
        _tileEntities = ((ListTag) _baseTag.get(MinecraftSchematicTagNames.TILE_ENTITIES)).getValue();
        
        

    }

    private static CompoundTag getSchematicTagFromNBTFile(File schematicFile) {
        CompoundTag schematicTag = null;

        try {
            FileInputStream stream = new FileInputStream(schematicFile);
            NBTInputStream nbtStream = new NBTInputStream(stream);

            schematicTag = (CompoundTag) nbtStream.readTag();
            nbtStream.close();
            stream.close();
        } catch (Exception e) {
            //TODO: LOG ERROR
        }
        return schematicTag;
    }

    /**
     * @return the _baseTag
     */
    public CompoundTag getBaseTag() {
        return _baseTag;
    }

    /**
     * @return the _width
     */
    public ShortTag getWidth() {
        return _width;
    }

    /**
     * @return the _length
     */
    public ShortTag getLength() {
        return _length;
    }

    /**
     * @return the _height
     */
    public ShortTag getHeight() {
        return _height;
    }

    /**
     * @return the _materials
     */
    public StringTag getMaterials() {
        return _materials;
    }

    /**
     * @return the _blocks
     */
    public ByteArrayTag getBlocks() {
        return _blocks;
    }

    /**
     * @return the _blockData
     */
    public ByteArrayTag getBlockData() {
        return _blockData;
    }

    /**
     * @return the _entities
     */
    public List<CompoundTag> getEntities() {
        return _entities;
    }

    /**
     * @return the _tileEntities
     */
    public List<CompoundTag> getTileEntities() {
        return _tileEntities;
    }
}

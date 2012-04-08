/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.bukkitschematicutilities;

/**
 *
 * @author James
 */
public class MinecraftSchematicTagNames {
    public static final String WIDTH = "Width";
    public static final String LENGTH = "Length";
    public static final String HEIGHT = "Height";
    public static final String BLOCKS = "Blocks";
    public static final String DATA = "Data";
    public static final String ENTITIES = "Entities";
    public static final String TILE_ENTITIES = "TileEntities";
    
    public class TileEntityTagNames{
        public static final String X = "x";
        public static final String Y = "y";
        public static final String Z = "z";
        public static final String ID = "id";
    }
    
    public class SignBlockTagNames{
        public static final String TEXT_1 = "Text1";
        public static final String TEXT_2 = "Text2";
        public static final String TEXT_3 = "Text3";
        public static final String TEXT_4 = "Text4";
    }
    
    public class MobSpawnerTagNames{
        public static final String ENTITY_ID = "EntityId";
        public static final String DELAY = "Delay";
    }
    
    public class MusicBlockTagNames{
        public static final String NOTE = "note";
    }
    
    public class FurnaceBlockTagNames{
        public static final String BURN_TIME = "BurnTime";
        public static final String COOK_TIME = "CookTime";
        public static final String ITEMS = "Items";
    }
    
    public class InventoryTagNames{
        public static final String ID = "id";
        public static final String COUNT = "Count";
        public static final String DAMAGE = "Damage";
        public static final String SLOT = "Slot";
    }
    
    public class PistonTagNames{
        public static final String BLOCK_ID = "blockId";
        public static final String BLOCK_DATA = "blockData";
        public static final String FACING = "facing";
        public static final String PROGRESS = "progress";
        public static final String EXTENDING = "extending";                
    }
    
    public class JukeboxTagNames {
        public static final String RECORD = "Record";
    }
    
    public class CauldronTagNames {
        public static final String BREW_TIME = "BrewTime";
        public static final String ITEMS = "Items";
    }
}

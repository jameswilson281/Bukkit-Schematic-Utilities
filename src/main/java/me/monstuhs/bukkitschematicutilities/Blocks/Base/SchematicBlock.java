package me.monstuhs.bukkitschematicutilities.Blocks.Base;

public class SchematicBlock {

    private short type = 0;
    private byte data = 0;

    public SchematicBlock(int type) {
        this.type = (short) type;
    }

    public SchematicBlock(int type, int data) {
        this.type = (short) type;
        this.data = (byte) data;
    }

    public int getType() {
        return (int) type;
    }

    public void setType(int type) {
        this.type = (short) type;
    }

    public int getData() {
        return (int) data;
    }

    public void setData(int data) {
        this.data = (byte) data;
    }

    public boolean isAir() {
        return type == 0;
    }

    public void rotate90() {
        data = (byte) rotate90(type, data);
    }

    public void rotate90Reverse() {
        data = (byte) rotate90(type, data);
        data = (byte) rotate90(type, data);
        data = (byte) rotate90(type, data);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SchematicBlock)) {
            return false;
        }
        return (type == ((SchematicBlock) o).type)
                && (data == ((SchematicBlock) o).data);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.type;
        hash = 83 * hash + this.data;
        return hash;
    }

    @Override
    public String toString() {
        return "SchematicBlock id: " + getType() + " with damage: " + getData();
    }

    public boolean inIterable(Iterable<SchematicBlock> iter) {
        for (SchematicBlock block : iter) {
            if (block.equals(this)) {
                return true;
            }
        }
        return false;
    }

    public static int rotate90(int type, int data) {
        switch (type) {
            case 50:
            case 75:
            case 76:
                switch (data) {
                    case 1:
                        return 3;
                    case 2:
                        return 4;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                }
                break;

            case 66:
                switch (data) {
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 9;
                    case 9:
                        return 6;
                }
            /*
             * FALL-THROUGH
             */

            case 27:
            case 28:
                switch (data & 0x7) {
                    case 0:
                        return 1;
                    case 1:
                        return 0;
                    case 2:
                        return 5;
                    case 3:
                        return 4;
                    case 4:
                        return 2;
                    case 5:
                        return 3;
                }
                break;

            case 53:
            case 67:
                switch (data) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 1;
                    case 3:
                        return 0;
                }
                break;

            case 69:
            case 77:
                int thrown = data & 0x8;
                int withoutThrown = data & ~0x8;
                switch (withoutThrown) {
                    case 1:
                        return 3 | thrown;
                    case 2:
                        return 4 | thrown;
                    case 3:
                        return 2 | thrown;
                    case 4:
                        return 1 | thrown;
                }
                break;

            case 71:
            case 64:
                int topHalf = data & 0x8;
                int swung = data & 0x4;
                int withoutFlags = data & ~(0x8 | 0x4);
                switch (withoutFlags) {
                    case 0:
                        return 1 | topHalf | swung;
                    case 1:
                        return 2 | topHalf | swung;
                    case 2:
                        return 3 | topHalf | swung;
                    case 3:
                        return 0 | topHalf | swung;
                }
                break;

            case 63:
                return (data + 4) % 16;

            case 65:
            case 68:
            case 61:
            case 62:
            case 23:
                switch (data) {
                    case 2:
                        return 5;
                    case 3:
                        return 4;
                    case 4:
                        return 2;
                    case 5:
                        return 3;
                }
                break;

            case 91:
            case 86:
                switch (data) {
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 0;
                }
                break;

            case 93:
            case 94:
                int dir = data & 0x03;
                int delay = data - dir;
                switch (dir) {
                    case 0:
                        return 1 | delay;
                    case 1:
                        return 2 | delay;
                    case 2:
                        return 3 | delay;
                    case 3:
                        return 0 | delay;
                }
                break;

            case 96:
                int open = data & 0x4;
                int withoutOpen = data & ~0x4;
                switch (withoutOpen) {
                    case 0:
                        return 3 | open;
                    case 1:
                        return 2 | open;
                    case 2:
                        return 0 | open;
                    case 3:
                        return 1 | open;
                }
            case 33:
            case 34:
            case 29:
                switch (data) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 5;
                    case 3:
                        return 4;
                    case 4:
                        return 2;
                    case 5:
                        return 3;
                }
        }

        return data;
    }
}
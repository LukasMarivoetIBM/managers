/*
 * Copyright (c) 2019 IBM Corporation.
 */
package dev.galasa.zos3270.internal.datastream;

import java.nio.ByteBuffer;

public class AttributeCharacterSet implements IAttribute {

    public static final byte ATTRIBUTE_ID = 0x43;

    private final byte       characterSet;

    public AttributeCharacterSet(ByteBuffer buffer) {
        this.characterSet = buffer.get();
    }
    
    public byte getCharacterSet() {
        return characterSet;
    }

}
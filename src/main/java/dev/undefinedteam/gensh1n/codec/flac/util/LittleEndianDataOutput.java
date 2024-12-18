package dev.undefinedteam.gensh1n.codec.flac.util;

/**
 * libFLAC - Free Lossless Audio Codec library
 * Copyright (C) 2001,2002,2003  Josh Coalson
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 */

import java.io.DataOutput;
import java.io.IOException;

/**
 * This class extends DataOutput for writing little-endian data.
 * @author kc7bfi
 */
public class LittleEndianDataOutput implements DataOutput {

    private final DataOutput out;

    /**
     * The constructor.
     * @param out   The DataOutput to read on
     */
    public LittleEndianDataOutput(DataOutput out) {
        this.out = out;
    }

    /**
     * @see DataOutput#writeDouble(double)
     */
    public void writeDouble(double arg0) throws IOException {
        out.writeDouble(arg0);
    }

    /**
     * @see DataOutput#writeFloat(float)
     */
    public void writeFloat(float arg0) throws IOException {
        out.writeFloat(arg0);
    }

    /**
     * @see DataOutput#write(int)
     */
    public void write(int arg0) throws IOException {
        out.write(arg0);
    }

    /**
     * @see DataOutput#writeByte(int)
     */
    public void writeByte(int arg0) throws IOException {
        out.writeByte(arg0);
    }

    /**
     * @see DataOutput#writeChar(int)
     */
    public void writeChar(int arg0) throws IOException {
        out.writeChar(arg0);
    }

    /**
     * @see DataOutput#writeInt(int)
     */
    public void writeInt(int arg0) throws IOException {
        out.writeByte(arg0 & 0xff);
        out.writeByte((arg0 >> 8) & 0xff);
        out.writeByte((arg0 >> 16) & 0xff);
        out.writeByte((arg0 >> 24) & 0xff);
    }

    /**
     * @see DataOutput#writeShort(int)
     */
    public void writeShort(int arg0) throws IOException {
        out.writeByte(arg0 & 0xff);
        out.writeByte((arg0 >> 8) & 0xff);
    }

    /**
     * @see DataOutput#writeLong(long)
     */
    public void writeLong(long arg0) throws IOException {
        out.writeByte((int) arg0 & 0xff);
        out.writeByte((int) (arg0 >> 8) & 0xff);
        out.writeByte((int) (arg0 >> 16) & 0xff);
        out.writeByte((int) (arg0 >> 24) & 0xff);
        out.writeByte((int) (arg0 >> 32) & 0xff);
        out.writeByte((int) (arg0 >> 40) & 0xff);
        out.writeByte((int) (arg0 >> 48) & 0xff);
        out.writeByte((int) (arg0 >> 56) & 0xff);
    }

    /**
     * @see DataOutput#writeBoolean(boolean)
     */
    public void writeBoolean(boolean arg0) throws IOException {
        out.writeBoolean(arg0);
    }

    /**
     * @see DataOutput#write(byte[])
     */
    public void write(byte[] arg0) throws IOException {
        out.write(arg0);
    }

    /**
     * @see DataOutput#write(byte[], int, int)
     */
    public void write(byte[] arg0, int arg1, int arg2) throws IOException {
        out.write(arg0, arg1, arg2);
    }

    /**
     * @see DataOutput#writeBytes(String)
     */
    public void writeBytes(String arg0) throws IOException {
        out.writeBytes(arg0);
    }

    /**
     * @see DataOutput#writeChars(String)
     */
    public void writeChars(String arg0) throws IOException {
        out.writeChars(arg0);
    }

    /**
     * @see DataOutput#writeUTF(String)
     */
    public void writeUTF(String arg0) throws IOException {
        out.writeUTF(arg0);
    }
}

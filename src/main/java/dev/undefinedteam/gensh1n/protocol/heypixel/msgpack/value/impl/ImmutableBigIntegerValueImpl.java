//
// MessagePack for Java
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.impl;

import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.core.MessageFormat;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.core.MessageIntegerOverflowException;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.core.MessagePacker;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.ImmutableIntegerValue;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.ImmutableNumberValue;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.IntegerValue;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.Value;
import dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.value.ValueType;

import java.io.IOException;
import java.math.BigInteger;

/**
 * {@code ImmutableBigIntegerValueImpl} Implements {@code ImmutableBigIntegerValue} using a {@code BigInteger} field.
 *
 * @see IntegerValue
 */
public class ImmutableBigIntegerValueImpl
        extends AbstractImmutableValue
        implements ImmutableIntegerValue
{
    public static MessageFormat mostSuccinctMessageFormat(IntegerValue v)
    {
        if (v.isInByteRange()) {
            return MessageFormat.INT8;
        }
        else if (v.isInShortRange()) {
            return MessageFormat.INT16;
        }
        else if (v.isInIntRange()) {
            return MessageFormat.INT32;
        }
        else if (v.isInLongRange()) {
            return MessageFormat.INT64;
        }
        else {
            return MessageFormat.UINT64;
        }
    }

    private final BigInteger value;

    public ImmutableBigIntegerValueImpl(BigInteger value)
    {
        this.value = value;
    }

    private static final BigInteger BYTE_MIN = BigInteger.valueOf(Byte.MIN_VALUE);
    private static final BigInteger BYTE_MAX = BigInteger.valueOf(Byte.MAX_VALUE);
    private static final BigInteger SHORT_MIN = BigInteger.valueOf(Short.MIN_VALUE);
    private static final BigInteger SHORT_MAX = BigInteger.valueOf(Short.MAX_VALUE);
    private static final BigInteger INT_MIN = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger INT_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);

    @Override
    public ValueType getValueType()
    {
        return ValueType.INTEGER;
    }

    @Override
    public ImmutableIntegerValue immutableValue()
    {
        return this;
    }

    @Override
    public ImmutableNumberValue asNumberValue()
    {
        return this;
    }

    @Override
    public ImmutableIntegerValue asIntegerValue()
    {
        return this;
    }

    @Override
    public byte toByte()
    {
        return value.byteValue();
    }

    @Override
    public short toShort()
    {
        return value.shortValue();
    }

    @Override
    public int toInt()
    {
        return value.intValue();
    }

    @Override
    public long toLong()
    {
        return value.longValue();
    }

    @Override
    public BigInteger toBigInteger()
    {
        return value;
    }

    @Override
    public float toFloat()
    {
        return value.floatValue();
    }

    @Override
    public double toDouble()
    {
        return value.doubleValue();
    }

    @Override
    public boolean isInByteRange()
    {
        return 0 <= value.compareTo(BYTE_MIN) && value.compareTo(BYTE_MAX) <= 0;
    }

    @Override
    public boolean isInShortRange()
    {
        return 0 <= value.compareTo(SHORT_MIN) && value.compareTo(SHORT_MAX) <= 0;
    }

    @Override
    public boolean isInIntRange()
    {
        return 0 <= value.compareTo(INT_MIN) && value.compareTo(INT_MAX) <= 0;
    }

    @Override
    public boolean isInLongRange()
    {
        return 0 <= value.compareTo(LONG_MIN) && value.compareTo(LONG_MAX) <= 0;
    }

    @Override
    public MessageFormat mostSuccinctMessageFormat()
    {
        return mostSuccinctMessageFormat(this);
    }

    @Override
    public byte asByte()
    {
        if (!isInByteRange()) {
            throw new MessageIntegerOverflowException(value);
        }
        return value.byteValue();
    }

    @Override
    public short asShort()
    {
        if (!isInShortRange()) {
            throw new MessageIntegerOverflowException(value);
        }
        return value.shortValue();
    }

    @Override
    public int asInt()
    {
        if (!isInIntRange()) {
            throw new MessageIntegerOverflowException(value);
        }
        return value.intValue();
    }

    @Override
    public long asLong()
    {
        if (!isInLongRange()) {
            throw new MessageIntegerOverflowException(value);
        }
        return value.longValue();
    }

    @Override
    public BigInteger asBigInteger()
    {
        return value;
    }

    @Override
    public void writeTo(MessagePacker pk)
            throws IOException
    {
        pk.packBigInteger(value);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Value v)) {
            return false;
        }

        if (!v.isIntegerValue()) {
            return false;
        }
        IntegerValue iv = v.asIntegerValue();
        return value.equals(iv.toBigInteger());
    }

    @Override
    public int hashCode()
    {
        if (INT_MIN.compareTo(value) <= 0 && value.compareTo(INT_MAX) <= 0) {
            return (int) value.longValue();
        }
        else if (LONG_MIN.compareTo(value) <= 0
                && value.compareTo(LONG_MAX) <= 0) {
            long v = value.longValue();
            return (int) (v ^ (v >>> 32));
        }
        return value.hashCode();
    }

    @Override
    public String toJson()
    {
        return value.toString();
    }

    @Override
    public String toString()
    {
        return toJson();
    }
}

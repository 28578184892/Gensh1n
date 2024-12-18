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
package dev.undefinedteam.gensh1n.protocol.heypixel.msgpack.core;

/**
 * A base class of all of the message pack exceptions.
 */
public class MessagePackException
        extends RuntimeException
{
    public MessagePackException()
    {
        super();
    }

    public MessagePackException(String message)
    {
        super(message);
    }

    public MessagePackException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MessagePackException(Throwable cause)
    {
        super(cause);
    }

    public static UnsupportedOperationException UNSUPPORTED(String operationName)
    {
        return new UnsupportedOperationException(operationName);
    }

    public static final IllegalStateException UNREACHABLE = new IllegalStateException("Cannot reach here");
}

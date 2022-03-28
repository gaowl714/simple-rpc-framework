package com.github.liyue2008.rpc.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import com.github.liyue2008.rpc.serialize.AbstractJsonSerializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/27 13:33
 */
public class StringJsonSerializer extends AbstractJsonSerializer<String> {

    @Override
    public String parse(byte[] bytes, int offset, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, length);
        int sizeOfJson = buffer.getInt();
        byte[] jsonBytes = new byte[sizeOfJson];
        buffer.get(jsonBytes);
        return new String(jsonBytes, StandardCharsets.UTF_8);
    }

    @Override
    public byte type() {
        return Types.TYPE_STRING;
    }

    @Override
    public Class<String> getSerializeClass() {
        return String.class;
    }

}

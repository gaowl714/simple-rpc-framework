package com.github.liyue2008.rpc.serialize.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.liyue2008.rpc.serialize.AbstractJsonSerializer;

import java.nio.ByteBuffer;

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
        return JSONObject.parseObject(jsonBytes, String.class);
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

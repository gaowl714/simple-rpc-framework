package com.github.liyue2008.rpc.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/27 13:32
 */
public abstract class AbstractJsonSerializer<T> implements Serializer<T> {

    @Override
    public int size(T entry) {
        return Integer.BYTES + JSON.toJSONString(entry).getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public void serialize(T entry, byte[] bytes, int offset, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, length);
        byte[] jsonBytes = JSONObject.toJSONBytes(entry);
        buffer.putInt(jsonBytes.length);
        buffer.put(jsonBytes);
    }

}

package com.github.liyue2008.rpc.serialize.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.liyue2008.rpc.client.stubs.RpcRequest;
import com.github.liyue2008.rpc.serialize.AbstractJsonSerializer;

import java.nio.ByteBuffer;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/27 13:45
 */
public class RpcRequestJsonSerializer extends AbstractJsonSerializer<RpcRequest> {


    @Override
    public RpcRequest parse(byte[] bytes, int offset, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, length);
        int sizeOfJson = buffer.getInt();
        byte[] jsonBytes = new byte[sizeOfJson];
        buffer.get(jsonBytes);
        return JSONObject.parseObject(jsonBytes, getSerializeClass());
    }

    @Override
    public byte type() {
        return Types.TYPE_RPC_REQUEST;
    }

    @Override
    public Class<RpcRequest> getSerializeClass() {
        return RpcRequest.class;
    }
}

package com.github.liyue2008.rpc.serialize.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.liyue2008.rpc.nameservice.Metadata;
import com.github.liyue2008.rpc.serialize.AbstractJsonSerializer;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/27 13:44
 */
public class MetadataJsonSerializer extends AbstractJsonSerializer<Metadata> {

    @Override
    public Metadata parse(byte[] bytes, int offset, int length) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, length);
        int sizeOfJson = buffer.getInt();
        byte[] jsonBytes = new byte[sizeOfJson];
        buffer.get(jsonBytes);
        String json = new String(jsonBytes, StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(json);
        Metadata metadata = new Metadata();
        jsonObject.forEach((k, v) -> {
            List<String> uriList = (List<String>) v;
            List<URI> uris = uriList.stream()
                    .map(URI::create)
                    .collect(Collectors.toList());
            metadata.put(k, uris);
        });
        return metadata;
    }

    @Override
    public byte type() {
        return Types.TYPE_METADATA;
    }

    @Override
    public Class<Metadata> getSerializeClass() {
        return Metadata.class;
    }
}

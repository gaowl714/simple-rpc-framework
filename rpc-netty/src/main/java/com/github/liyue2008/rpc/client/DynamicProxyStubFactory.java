package com.github.liyue2008.rpc.client;

import com.github.liyue2008.rpc.client.proxy.InvocationHandleImpl;
import com.github.liyue2008.rpc.transport.Transport;

import java.lang.reflect.Proxy;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/28 14:28
 */
public class DynamicProxyStubFactory implements StubFactory {


    @Override
    @SuppressWarnings("unchecked")
    public <T> T createStub(Transport transport, Class<T> serviceClass) {
        InvocationHandleImpl handler = new InvocationHandleImpl(serviceClass.getCanonicalName());
        handler.setTransport(transport);
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass}, handler);

    }

}

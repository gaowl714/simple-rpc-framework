package com.github.liyue2008.rpc.client.proxy;

import com.github.liyue2008.rpc.client.stubs.AbstractStub;
import com.github.liyue2008.rpc.client.stubs.RpcRequest;
import com.github.liyue2008.rpc.serialize.SerializeSupport;
import com.github.liyue2008.rpc.transport.Transport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaoWL
 * @description
 * @date 2022/3/28 15:23
 */
public class InvocationHandleImpl extends AbstractStub implements InvocationHandler {

    private String interfaceName;

    public InvocationHandleImpl(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    @Override
    public void setTransport(Transport transport) {
        super.setTransport(transport);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return SerializeSupport.parse(invokeRemote(new RpcRequest(interfaceName, method.getName(), SerializeSupport.serialize(args))));
    }
}

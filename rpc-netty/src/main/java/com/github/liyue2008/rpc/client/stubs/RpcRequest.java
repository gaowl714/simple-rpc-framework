/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.liyue2008.rpc.client.stubs;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYue
 * Date: 2019/9/27
 */
public class RpcRequest {
    private final String interfaceName;
    private final String methodName;
    private final byte [] serializedArguments;

    @JSONCreator
    public RpcRequest(@JSONField(name = "interfaceName") String interfaceName,
                      @JSONField(name = "methodName") String methodName,
                      @JSONField(name = "serializedArguments") byte[] serializedArguments) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.serializedArguments = serializedArguments;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public byte[] getSerializedArguments() {
        return serializedArguments;
    }
}

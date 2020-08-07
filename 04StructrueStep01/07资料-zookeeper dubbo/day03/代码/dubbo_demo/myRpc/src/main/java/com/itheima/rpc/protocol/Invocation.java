package com.itheima.rpc.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;

}

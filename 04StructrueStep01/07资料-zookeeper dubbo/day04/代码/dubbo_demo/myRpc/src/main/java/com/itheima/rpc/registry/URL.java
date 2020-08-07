package com.itheima.rpc.registry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class URL {

    private String hostname;
    private Integer port;
}

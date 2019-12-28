package com.meng.daily.basejava.VirtualMachine;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/24 16:02
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("17908");
        vm.loadAgent("E:\\hotswap.jar");
    }
}

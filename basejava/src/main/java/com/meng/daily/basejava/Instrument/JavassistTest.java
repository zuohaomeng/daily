package com.meng.daily.basejava.Instrument;

/**
 * @Description: TODO
 * @Author: Hao.Zuo
 * @Date: 2019/12/24 15:47
 */
import javassist.*;

import java.io.IOException;

public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.meng.daily.basejava.Instrument.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        System.out.println(c.getClassLoader());
        cc.writeFile("E:\\log");
        Base h = (Base)c.newInstance();
        h.process();
    }
}

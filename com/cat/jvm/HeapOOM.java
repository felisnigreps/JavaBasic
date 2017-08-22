package com.cat.jvm;

/*
vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
*/

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for(;;){
            list.add(new OOMObject());
        }

    }
}

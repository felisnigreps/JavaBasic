package com.cat.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapFailFast {
    public static void main(String[] args) {
        //如果改成ConcurrentHashMap就不会出现快速失败
        Map<String, String> premiumPhone = new HashMap<String, String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung", "S5");
        Iterator iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            //在这修改了map结构 会发生fail-fast
            //维持了一个modecount,每次修改会做对比,如果不一致,抛出异常
            //注意 remove()方法会让expectModcount和modcount 相等，所以不会抛出这个异常。
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}

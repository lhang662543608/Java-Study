package base.colllection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    @Test
    public void testHashMap() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("aa", "bb");
        hashMap.putIfAbsent("aa", "cc");
        hashMap.put("dd", "bb");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next().getKey();
            String value = hashMap.get(key);
            System.out.println("key:"+key+" value:"+value);
        }


    }


    @Test
    public void testHashTable(){
        Hashtable<String,Object> hashtable = new Hashtable();
        hashtable.put("aa",12);

    }

    @Test
    public void testConcurrentHashMap(){
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");

    }

}

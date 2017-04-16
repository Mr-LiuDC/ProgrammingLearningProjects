package cn.alittler.study.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class MapCompare {

	/**
	 * 用map的keySet()的迭代器(性能效率较低)
	 * 
	 */
	public void compareMap1() {

		Map<String, String> m1 = new HashMap<String, String>();// 小
		Map<String, String> m2 = new HashMap<String, String>();// 大

		Iterator<String> iter1 = m1.keySet().iterator();

		while (iter1.hasNext()) {
			String m1Key = (String) iter1.next();
			if (!m1.get(m1Key).equals(m2.get(m1Key))) {// 若两个map中相同key对应的value不相等
				// ......
			}
		}

	}

	/**
	 * 用map的entrySet()的迭代器(性能效率较高)
	 */
	public void compareMap2(){
        Map<String, String> m1 = new HashMap<String, String>();
        Map<String, String> m2 = new HashMap<String, String>();
         
        Iterator<Entry<String, String>> iter1 = m1.entrySet().iterator();
        while(iter1.hasNext()){
        	Map.Entry<String, String> entry1 = (Entry<String, String>) iter1.next();
        	String m1value = entry1.getValue() == null?"":entry1.getValue();
            String m2value = m2.get(entry1.getKey())==null?"":m2.get(entry1.getKey());
                  
            if (!m1value.equals(m2value)) {//若两个map中相同key对应的value不相等
                //其他操作...
            }
        }
    }

	/**
	 * 用map的entrySet()的增强型for循环(性能效率较高)
	 */
	public void compareMap3() {
		Map<String, String> m1 = new HashMap<String, String>();
		Map<String, String> m2 = new HashMap<String, String>();

		for (Map.Entry<String, String> entry1 : m1.entrySet()) {
			String m1value = entry1.getValue() == null ? "" : entry1.getValue();
			String m2value = m2.get(entry1.getKey()) == null ? "" : m2
					.get(entry1.getKey());
			if (!m1value.equals(m2value)) {// 若两个map中相同key对应的value不相等
				// 其他操作...
			}
		}
	}

	@Test
	public void test_TwoMapCompare() {
		Map<Object, Object> map1 = new HashMap<>();
		Map<Object, Object> map2 = new HashMap<>();

		map1.put("name", "刘德财");
		map1.put("age", 23);
		System.out.println(map1);

		map2.put("name", "刘德财");
		map2.put("sex", "男");
		map2.put("address", "重庆市");
		System.out.println(map2);

		if (map1.get("name").equals(map2.get("name"))) {
			map1.putAll(map2);
		}
		System.out.println(map1);
	}

}

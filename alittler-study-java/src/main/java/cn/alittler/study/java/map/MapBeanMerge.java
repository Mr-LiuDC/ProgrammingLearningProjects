package cn.alittler.study.java.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class MapBeanMerge {

	@SuppressWarnings("deprecation")
	@Test
	public void componentA() {
		HashMap<Object, Object> map1 = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			MapBeanA mapBeanA = new MapBeanA();
			mapBeanA.setId(i);
			mapBeanA.setName("AA_" + i);
			mapBeanA.setAge(new Random().nextInt(100));
			mapBeanA.setBirthday(new Date("1993/10/11"));
			map1.put("M_AA_" + i, mapBeanA);
		}
		System.out.println(map1);
		System.out.println(map1.get("M_AA_2"));

		HashMap<Object, Object> map2 = new HashMap<>();

		for (int j = 0; j < 5; j++) {
			MapBeanB mapBeanB = new MapBeanB();
			mapBeanB.setId(j);
			mapBeanB.setName("AA_" + j);
			mapBeanB.setAddress("loacation——" + j);
			mapBeanB.setDescription("this is MapBean_" + j);
			mapBeanB.setCreateTime(new Date());
			map2.put("M_AA_" + j, mapBeanB);
		}
		System.out.println(map2);
		System.out.println(map2.get("M_AA_2"));

		map1.putAll(map2);
		System.out.println(map1);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void component2() {
		List<MapBeanA> mapBeanAs = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			MapBeanA mapBeanA = new MapBeanA();
			mapBeanA.setId(i);
			mapBeanA.setName("AA_" + i);
			mapBeanA.setAge(new Random().nextInt(100));
			mapBeanA.setBirthday(new Date("1993/10/11"));
			mapBeanAs.add(mapBeanA);
		}
		System.out.println(mapBeanAs);
		System.out.println(mapBeanAs.get(2));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<MapBeanB> mapBeanBs = new ArrayList<>();
		for (int j = 0; j < 5; j++) {
			MapBeanB mapBeanB = new MapBeanB();
			mapBeanB.setId(j);
			mapBeanB.setName("AA_" + j);
			mapBeanB.setAddress("loacation——" + j);
			mapBeanB.setDescription("this is MapBean_" + j);
			mapBeanB.setCreateTime(new Date());
			mapBeanBs.add(mapBeanB);
		}
		System.out.println(mapBeanBs);
		System.out.println(mapBeanBs.get(2));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (MapBeanA mapBeanA : mapBeanAs) {
			for (MapBeanB mapBeanB : mapBeanBs) {
				if (mapBeanA.getId() == (mapBeanB.getId()) && mapBeanA.getName().equals(mapBeanB.getName())) {
					mapBeanA.setAddress(mapBeanB.getAddress());
					mapBeanA.setDescription(mapBeanB.getDescription());
					mapBeanA.setCreateTime(mapBeanB.getCreateTime());
				}
			}
		}
		System.out.println(mapBeanAs);
	}

}

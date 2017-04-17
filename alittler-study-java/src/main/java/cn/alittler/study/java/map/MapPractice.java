package cn.alittler.study.java.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MapPractice {

	@Test
	public void test_bean2Map() {
		MapBean mapBean = new MapBean();
		mapBean.setId(1);
		mapBean.setName("小米");
		mapBean.setDate(new Date());

		Map<Object, Object> map = new HashMap<>();
		map.put("map1", mapBean);

		System.out.println(map);
		System.out.println(map.get("map1"));
	}

	@Test
	public void test_bean2Map2() {
		MapBean mapBean = new MapBean();
		mapBean.setId(1);
		mapBean.setName("小米");
		mapBean.setDate(new Date());

		List<MapBean> mapBeans = new ArrayList<>();
		mapBeans.add(mapBean);
		mapBean.setId(2);
		mapBean.setName("小米2");
		mapBean.setDate(new Date());
		mapBeans.add(mapBean);

		Map<Object, Object> map = new HashMap<>();
		map.put("maps", mapBeans);

		System.out.println(map);
		System.out.println(map.get("maps"));
	}

	@Test
	public void test_bean2Map3() {
		MapBean mapBean = new MapBean();
		mapBean.setId(1);
		mapBean.setName("小米");
		mapBean.setDate(new Date());

		MapBean mapBean2 = new MapBean();
		mapBean2.setId(2);
		mapBean2.setName("小米2");
		mapBean2.setDate(new Date());

		List<MapBean> mapBeans = new ArrayList<>();
		mapBeans.add(mapBean);
		mapBeans.add(mapBean2);

		Map<Object, Object> map = new HashMap<>();
		map.put("maps", mapBeans);

		System.out.println(map);
		System.out.println(map.get("maps"));
	}

}

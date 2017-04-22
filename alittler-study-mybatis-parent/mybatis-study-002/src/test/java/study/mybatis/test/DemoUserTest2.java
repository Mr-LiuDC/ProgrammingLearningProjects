package study.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.alittler.demo.mapper.DemoUserMapper;
import cn.alittler.demo.pojo.DemoUser;
import cn.alittler.demo.pojo.DemoUserExample;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class DemoUserTest2 {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testBatch() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		// 可以执行批量操作的sqlSession
		SqlSession openSession = sqlSessionFactory
				.openSession(ExecutorType.BATCH);
		long start = System.currentTimeMillis();
		try {
			DemoUserMapper mapper = openSession.getMapper(DemoUserMapper.class);
			for (int i = 0; i < 100000; i++) {
				DemoUser user = new DemoUser();
				user.setUserName("AA_" + i);
				user.setUserage(new Random().nextInt(100));
				user.setSex(new Random().nextInt(1));
				user.setHobby("Hobby-" + i);
				mapper.insertSelective(user);
			}
			openSession.commit();
			long end = System.currentTimeMillis();
			// 批量：（预编译sql一次==>设置参数===>10000次===>执行（1次））
			// Parameters: 616c1(String), b(String), 1(String)==>4598
			// 非批量：（预编译sql=设置参数=执行）==》10000 10200
			System.out.println("执行时长：" + (end - start));
		} finally {
			openSession.close();
		}

	}

	@Test
	public void test01() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			DemoUserMapper mapper = openSession.getMapper(DemoUserMapper.class);
			Page<Object> page = PageHelper.startPage(5, 15);

			DemoUserExample example = new DemoUserExample();
			List<DemoUser> users = mapper.selectByExample(example);

			System.out.println("当前页码：" + page.getPageNum());
			System.out.println("总记录数：" + page.getTotal());
			System.out.println("每页的记录数：" + page.getPageSize());
			System.out.println("总页码：" + page.getPages());

			// 传入要连续显示多少页
			PageInfo<DemoUser> info = new PageInfo<>(users, 5);
			for (DemoUser user : users) {
				System.out.println(user);
			}
			System.out.println("当前页码：" + info.getPageNum());
			System.out.println("总记录数：" + info.getTotal());
			System.out.println("每页的记录数：" + info.getPageSize());
			System.out.println("总页码：" + info.getPages());
			System.out.println("是否第一页：" + info.isIsFirstPage());
			System.out.println("连续显示的页码：");
			int[] nums = info.getNavigatepageNums();
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
		} finally {
			openSession.close();
		}

	}

}

1.MyBatis错误提示与解决方式：

	1、mapper未绑定错误 org.apache.ibatis.binding.BindingException: Type interface cn.alittler.demo.mapper.DemoUserMapper is not known to the MapperRegistry.
	
	解决方案：将XXXMapper.xml绑定到配置文件中
		
		
		
	
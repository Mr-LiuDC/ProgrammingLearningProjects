package cn.alittler.mapper;

import cn.alittler.pojo.DemoUser;
import cn.alittler.pojo.DemoUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoUserMapper {
    long countByExample(DemoUserExample example);

    int deleteByExample(DemoUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    List<DemoUser> selectByExample(DemoUserExample example);

    DemoUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByExample(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);
}
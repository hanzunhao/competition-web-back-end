package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where account=#{account} and password=#{password}")
    User selectByUsernameAndPassword(User user);
}

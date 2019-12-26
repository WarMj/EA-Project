package top.warmj.ea.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.warmj.ea.domain.UserDO;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<UserDO> selectUser(String username, String password);
}

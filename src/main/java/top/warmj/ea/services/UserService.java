package top.warmj.ea.services;

import top.warmj.ea.domain.UserDO;

import java.util.List;

public interface UserService {
    List<UserDO> selectUser(String username, String password);
}

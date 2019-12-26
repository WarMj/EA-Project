package top.warmj.ea.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.warmj.ea.dao.UserDao;
import top.warmj.ea.domain.UserDO;
import top.warmj.ea.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDO> selectUser(String username, String password) {
        return userDao.selectUser(username, password);
    }
}

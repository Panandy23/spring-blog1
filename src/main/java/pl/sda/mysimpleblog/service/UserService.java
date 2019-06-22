package pl.sda.mysimpleblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.mysimpleblog.model.Role;
import pl.sda.mysimpleblog.model.User;
import pl.sda.mysimpleblog.repository.RoleRepository;
import pl.sda.mysimpleblog.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void registerUser (User user){
       user.addRole(roleRepository.getOne(1L));
       userRepository.save(user);

    }

    public boolean passwordCheck (String password, String password_confirm){

        if (password.equals(password_confirm)){
            return true;
        }
        return false;
    }


}

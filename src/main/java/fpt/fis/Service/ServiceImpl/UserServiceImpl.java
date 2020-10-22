package fpt.fis.Service.ServiceImpl;

import fpt.fis.Service.UserService;
import fpt.fis.dto.UserDto;
import fpt.fis.model.User;
import fpt.fis.repository.UserResponsitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserResponsitory userResponsitory;
    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<UserDto> getAll() {
        List<User> users = userResponsitory.getAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper
                .map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public User Updated(User user1) {
        User user=userResponsitory.findById(user1.getId()).orElse(null);
        user.setUserName(user1.getUserName());
        user.setPassword(user1.getPassword());
        userResponsitory.save(user);
        return user;
    }
    @Override
    public User Add(User user1) {
        User user=userResponsitory.save(user1);
        return userResponsitory.findById(user1.getId()).orElse(null);
    }
    @Override
    public User Deleted(User user1){
        User user=userResponsitory.findById(user1.getId()).orElse(null);
        userResponsitory.delete(user);
        return userResponsitory.findById(user.getId()).orElse(null);
    }

}

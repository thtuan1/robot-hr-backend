package fpt.fis.Service;

import fpt.fis.dto.UserDto;
import fpt.fis.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    User Updated(User user);
    User Add(User user);
    User Deleted(User user);
}

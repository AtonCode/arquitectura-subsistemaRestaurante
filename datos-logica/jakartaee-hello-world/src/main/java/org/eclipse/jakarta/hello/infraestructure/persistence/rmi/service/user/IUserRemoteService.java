package org.eclipse.jakarta.hello.infraestructure.persistence.rmi.service.user;



import jakarta.ejb.Remote;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.user.mapper.User;

import java.util.List;

@Remote
public interface IUserRemoteService {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    User readUser(long id);
    List<User> readAllUser();
}

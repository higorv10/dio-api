package dio.api.service;

import dio.api.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
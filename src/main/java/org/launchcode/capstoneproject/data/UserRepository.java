package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}

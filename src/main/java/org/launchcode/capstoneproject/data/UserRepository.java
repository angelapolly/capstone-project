package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Integer> {

    UserProfile findByUsername(String username);
}

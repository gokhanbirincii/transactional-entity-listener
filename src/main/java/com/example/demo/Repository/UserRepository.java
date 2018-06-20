package com.example.demo.Repository;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on June, 2018
 *
 * @author gokhan
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUserName(String userName);
}

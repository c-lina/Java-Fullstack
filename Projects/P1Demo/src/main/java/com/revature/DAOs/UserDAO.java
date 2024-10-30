package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

By attending JpaRepository, we get access to various DAO methods that we don't have to write

    JavaRepository takes two generics
    -The Java Model we intend to perform DB operations with (User => users table in this case)
    -The datatype of the Primary Key field in the Model (Integer => user_Id in this case)

 */

/*

    I want to be able to find a User by their username
    Unfortunately, Spring Data doesn't have a built-in method for that

 */


@Repository //1 of the 4 stereotype annotations. It registers this interface as a Spring Bean
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    /*

    NOTE: The method MUST be named findByXyz, where Xyz is the name of the field in User

    How does Spring Data know? It's based on the name of the field in the Model
    more examples: User findByUsernameAndPassword, List<User> findByRole

    Property Expression are quite flexible, look into them for more patterns

     */
}

package org.example.book_my_show.repo;

import org.example.book_my_show.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepo extends CrudRepository<User,Long> {

}

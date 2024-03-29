package org.example.book_my_show.repo;

import org.example.book_my_show.models.Seat;
import org.example.book_my_show.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

}

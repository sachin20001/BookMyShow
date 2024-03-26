package org.example.book_my_show.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class SeatInShow extends Base {
    @ManyToOne
    MovieShow show;
    @ManyToOne
    Seat seat;

    @ManyToOne
    private Ticket ticket;

}

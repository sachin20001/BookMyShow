package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;



@Entity
@Getter@Setter
public class Ticket extends Base {
    private Date bookingTime;


    @ManyToOne
    private User bookedBy;

    @OneToMany(mappedBy = "ticket")
    private List<SeatInShow> seats;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
}

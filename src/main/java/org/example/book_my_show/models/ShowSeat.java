package org.example.book_my_show.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.book_my_show.models.enums.SeatStatus;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat extends Base {

    @ManyToOne
    MovieShow movieShow;

    @ManyToOne
    Seat seat;

    int price;

    @Enumerated(EnumType.STRING)
    SeatStatus seatStatus;

    @ManyToOne
    private Ticket ticket;

}

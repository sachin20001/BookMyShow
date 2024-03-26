package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.book_my_show.models.enums.SeatType;



@Entity
@Getter
@Setter
public class Seat extends Base {
    private String number;
    private int rowVal;
    private int colVal;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;

}

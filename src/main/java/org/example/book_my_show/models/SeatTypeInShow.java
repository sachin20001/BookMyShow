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
public class SeatTypeInShow extends Base {

    private int price;


    @ManyToOne
    private MovieShow show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;


}

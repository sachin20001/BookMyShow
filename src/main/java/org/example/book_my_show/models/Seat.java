package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.book_my_show.models.enums.SeatType;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends Base {
    private String number;


    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int price;

    @ManyToOne
    private Auditorium auditorium;

    @Builder.Default
    @OneToMany(mappedBy = "seat",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats=new ArrayList<>();

}

package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow extends Base {
    private String name;
    private LocalDate showDate;
    private LocalTime startTime;
    private float rateMultiplier;

    @ManyToOne
    private Auditorium auditorium;

    @Builder.Default
    @OneToMany(mappedBy = "movieShow",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList=new ArrayList<>();

}

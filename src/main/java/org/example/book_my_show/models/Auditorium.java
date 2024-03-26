package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.book_my_show.models.enums.Feature;

import java.util.List;





@Entity
@Getter
@Setter
public class Auditorium extends Base {
    private String name;
    private int numRows;
    private int numCols;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @OneToMany(mappedBy = "auditorium")
    private List<MovieShow> shows;

    @ManyToOne
    private Theatre theatre;
}

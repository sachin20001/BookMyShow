package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.*;
import org.example.book_my_show.models.enums.Feature;

import java.util.ArrayList;
import java.util.List;





@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium extends Base {
    private String name;
    private int numRows;
    private int numCols;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<Feature> features=new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats=new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "auditorium",cascade = CascadeType.ALL)
    private List<MovieShow> shows=new ArrayList<>();

    @ManyToOne
    private Theatre theatre;
}

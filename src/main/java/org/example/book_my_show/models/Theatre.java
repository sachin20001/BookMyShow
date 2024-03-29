package org.example.book_my_show.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theatre extends Base {
    private String name;
    private String address;


    @ManyToOne
    private City city;

    @Builder.Default
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Auditorium> auditoriums=new ArrayList<>();

}

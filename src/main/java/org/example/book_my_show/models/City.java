package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;



@Entity
@Getter
@Setter
public class City extends Base{
    private String name;


    @OneToMany(mappedBy = "city")
    private List<Theatre> theatreList;
}

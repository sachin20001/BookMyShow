package org.example.book_my_show.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City extends Base{
    private String name;


    @Builder.Default
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Theatre> theatreList=new ArrayList<>();
}

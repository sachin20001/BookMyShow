package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Entity
@Getter
@Setter
public class MovieShow extends Base {
    private String name;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

}

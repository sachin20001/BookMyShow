package org.example.book_my_show.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends Base {
    private Date bookingTime;


    @ManyToOne
    private User bookedBy;


    @Builder.Default
    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> seats=new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<Payment> payments=new ArrayList<>();
}

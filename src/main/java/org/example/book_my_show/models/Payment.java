package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.example.book_my_show.models.enums.Mode;
import org.example.book_my_show.models.enums.PaymentStatus;
import org.springframework.stereotype.Component;

import java.util.List;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends Base {
    private int transactionId;
    private int amount;
    private Mode mode;
    private PaymentStatus paymentStatus;


    @ManyToOne
    private Ticket ticket;

}

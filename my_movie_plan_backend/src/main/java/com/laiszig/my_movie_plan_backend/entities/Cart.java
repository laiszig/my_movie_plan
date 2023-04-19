package com.laiszig.my_movie_plan_backend.entities;


import com.laiszig.my_movie_plan_backend.security.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    private UserEntity user;

    @JoinColumn(name = "ticket_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticket;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = true)
    private Payment payment;
}

package com.hunglevi.expense_be.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "budget")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double amount;
        private String period;
        private String createdAt;
        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

}

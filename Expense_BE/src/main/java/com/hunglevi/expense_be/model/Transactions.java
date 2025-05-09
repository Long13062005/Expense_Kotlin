package com.hunglevi.expense_be.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double amount;
        private String type;
        private String date;
        private String createdAt;
        private String description;
        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

}

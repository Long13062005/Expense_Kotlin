package com.hunglevi.expense_be.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String content;
        private String response;
        private String createdAt;
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

}

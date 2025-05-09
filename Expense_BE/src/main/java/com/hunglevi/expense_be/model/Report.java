package com.hunglevi.expense_be.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String note;
        private String startDate;
        private String endDate;
        private String createdAt;
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

}

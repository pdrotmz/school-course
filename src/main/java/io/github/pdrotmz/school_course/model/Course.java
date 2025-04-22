package io.github.pdrotmz.school_course.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "course")
@Table(name = "tb_course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", length = 150, nullable = false, updatable = true)
    private String name;

    @Column(name = "description", length = 255, nullable = false, updatable = true)
    private String description;

    @Column(name = "price", precision = 5, scale = 2)
    private BigDecimal price;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PrePersist
    public void onPrePersist() {
        this.setCreationDate(LocalDateTime.now());
        this.setUpdateDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdateDate(LocalDateTime.now());
    }
}

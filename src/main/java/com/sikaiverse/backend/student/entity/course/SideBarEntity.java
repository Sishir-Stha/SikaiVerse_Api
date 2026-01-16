package com.sikaiverse.backend.student.entity.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SideBarEntity {
        @Id
        @Column(name ="result")
        private String result;
}

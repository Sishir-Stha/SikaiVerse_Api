package com.sikaiverse.backend.shared.entity.privileged;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class InstructorListEntity {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fullname")
    private String fullName;
}

package com.simplug.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "player_data")
@NoArgsConstructor
@AllArgsConstructor
public class PlayerData {

    @Id
    @Column(name = "player_name", nullable = false)
    @Setter(value = AccessLevel.NONE)
    private String playerName;

    @Column(name = "experience", nullable = false)
    private Long experience;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "kill_count", nullable = false)
    private Long killCount;

//    @PrePersist
//    protected void beforeSave() {
//        lastModifiedDate = Instant.now();
//    }
}

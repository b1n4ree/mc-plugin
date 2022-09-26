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

    @Column(name = "kill_count_cow", nullable = false)
    private Long killCountCow;

    @Column(name = "kill_count_pig", nullable = false)
    private Long killCountPig;

    @Column(name = "spawn_entity_lvl_1", nullable = false)
    private Long spawnEntityLvl1;

//    @PrePersist
//    protected void beforeSave() {
//        lastModifiedDate = Instant.now();
//    }
}

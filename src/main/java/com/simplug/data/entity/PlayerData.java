package com.simplug.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ValueGenerationType;

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

    @Column(name = "spawn_chicken_lvl", nullable = false)
    private Long spawnChickenLvl;

    @Column(name = "spawn_cow_lvl", nullable = false)
    private Long spawnCowLvl;

    @Column(name = "spawn_pig_lvl", nullable = false)
    private Long spawnPigLvl;

    @Column(name = "spawn_mushroom_cow_lvl", nullable = false)
    private Long spawnMushroomCowLvl;

    @Column(name = "spawn_sheep_lvl", nullable = false)
    private Long spawnSheepLvl;

    @Column(name = "spawn_horse_lvl", nullable = false)
    private Long spawnHorseLvl;

    @Column(name = "spawn_spider_lvl", nullable = false)
    private Long spawnSpiderLvl;

    @Column(name = "spawn_cave_spider_lvl", nullable = false)
    private Long spawnCaveSpiderLvl;

    @Column(name = "spawn_golem_lvl", nullable = false)
    private Long spawnGolemLvl;

    @Column(name = "spawn_creeper_lvl", nullable = false)
    private Long spawnCreeperLvl;

    @Column(name = "spawn_zombie", nullable = false)
    private Long spawnZombieLvl;

    @Column(name = "spawn_pig_zombie_lvl", nullable = false)
    private Long spawnPigZombieLvl;

    @Column(name = "spawn_skeleton_lvl", nullable = false)
    private Long spawnSkeletonLvl;

    @Column(name = "spawn_wither_lvl", nullable = false)
    private Long spawnWitherLvl;

    @Column(name = "kill_count", nullable = false)
    private Long killCount;

    @Column(name = "kill_count_chicken", nullable = false)
    private Long killCountChicken;

    @Column(name = "kill_count_cow", nullable = false)
    private Long killCountCow;

    @Column(name = "kill_count_pig", nullable = false)
    private Long killCountPig;

    @Column(name = "kill_count_mushroom_cow", nullable = false)
    private Long killCountMushroomCow;

    @Column(name = "kill_count_sheep", nullable = false)
    private Long killCountSheep;

    @Column(name = "kill_count_horse", nullable = false)
    private Long killCountHorse;

    @Column(name = "kill_count_spider", nullable = false)
    private Long killCountSpider;

    @Column(name = "kill_count_cave_spider", nullable = false)
    private Long killCountCaveSpider;

    @Column(name = "kill_count_golem", nullable = false)
    private Long killCountGolem;

    @Column(name = "kill_count_creeper", nullable = false)
    private Long killCountCreeper;

    @Column(name = "kill_count_zombie", nullable = false)
    private Long killCountZombie;

    @Column(name = "kill_count_pig_zombie", nullable = false)
    private Long killCountPigZombie;

    @Column(name = "kill_count_skeleton", nullable = false)
    private Long killCountSkeleton;

    @Column(name = "kill_count_wither", nullable = false)
    private Long killCountWither;

    @Column(name = "is_spawnable_chicken", nullable = false)
    private Boolean isSpawnableChicken;

    @Column(name = "is_spawnable_cow", nullable = false)
    private Boolean isSpawnableCow;

    @Column(name = "is_spawnable_pig", nullable = false)
    private Boolean isSpawnablePig;

    @Column(name = "is_spawnable_mushroom_cow", nullable = false)
    private Boolean isSpawnableMushroomCow;

    @Column(name = "is_spawnable_sheep", nullable = false)
    private Boolean isSpawnableSheep;

    @Column(name = "is_spawnable_horse", nullable = false)
    private Boolean isSpawnableHorse;

    @Column(name = "is_spawnable_spider", nullable = false)
    private Boolean isSpawnableSpider;

    @Column(name = "is_spawnable_cave_spider", nullable = false)
    private Boolean isSpawnableCaveSpider;

    @Column(name = "is_spawnable_golem", nullable = false)
    private Boolean isSpawnableGolem;

    @Column(name = "is_spawnable_creeper", nullable = false)
    private Boolean isSpawnableCreeper;

    @Column(name = "is_spawnable_zombie", nullable = false)
    private Boolean isSpawnableZombie;

    @Column(name = "is_spawnable_pig_zombie", nullable = false)
    private Boolean isSpawnablePigZombie;

    @Column(name = "is_spawnable_skeleton", nullable = false)
    private Boolean isSpawnableSkeleton;

    @Column(name = "is_spawnable_wither", nullable = false)
    private Boolean isSpawnableWither;

    @Column(name = "is_first_on_server", nullable = false)
    private Boolean isFirstOnServer;
//    @PrePersist
//    protected void beforeSave() {
//        lastModifiedDate = Instant.now();
//    }
}

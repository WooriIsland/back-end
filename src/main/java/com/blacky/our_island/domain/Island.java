package com.blacky.our_island.domain;

import com.blacky.our_island.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "island")
public class Island extends BaseEntity {

    public Island() {
    }

    @Id
    @Column(name = "island_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long islandId;

    @Column(name = "island_unique_number", nullable = false)
    private String islandUniqueNumber;

    @Column(name = "island_name")
    @Size(max = 10)                 // 글자수 제한 10자.
    private String islandName;

    @Column(name = "Secret")
    private Boolean Secret = true;  // Secret 필드에 아무런 값이 전달되지 않으면 기본값으로 true가 설정.

    @Column(name = "island_introduce")
    @Size(max = 20)
    private String island_introduce;


    public long getDaysSinceCreation() {         // 생성날짜 기준으로 며칠이 지났는지 계산하는 로직.
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(getCreatedAt(), now);
        return duration.toDays() + 1;
    }

}

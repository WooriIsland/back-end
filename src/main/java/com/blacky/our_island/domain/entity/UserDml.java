package com.blacky.our_island.domain.entity;

import com.blacky.our_island.domain.enum_class.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "User_TB")
public class UserDml {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;    // 닉네임

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;  // 권한

    // character는 MySQL에서 예약어이며, 테이블 생성 쿼리에서 사용하면 문법 오류가 발생하여, 이를 해결하기 위해 character 필드의 이름을 charactor로 변경함.
    @Column(name = "charactor")
    private String character;

    @Column(name = "island_id")
    private Long islandId;          // 수정된 부분


}

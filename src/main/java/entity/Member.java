package entity;

import javax.persistence.*;


/**
 * 즉시 로딩과 지연 로딩
 *
 * JPA는 개발자가 연관된 엔티티의 조회 시점을 선택할 수 있도록 다음 두 가지 방법을 제공한다.
 *
 * 1. 즉시 로딩
 *  예 : em.find(Member.class, "member1")를 호출할 때 회원 에닡티와 연관된 팀 엔티티도 함께 조회한다.
 *  설정 방법 : @ManyToOne(fetch = FetchType.EAGER)
 *
 * 2. 지연 로딩
 *  예 : member.getTeam().getName()처럼 조회한 팀 엔티티를 실제 사용하는 시점에 JPA가 SQL을 호출해서 팀 엔티티를 조회한다.
 *  설정 방법 : @ManyToOne(fetch = FetchType.LAZY)
 */
@Entity
public class Member {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}

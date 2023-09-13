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

    // 즉시 로딩
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    // 조인 컬럼이 NULLABLE 이라면 자체적으로 외부 조인을 하게 됨.
    // 외부 조인보다 내부 조인이 성능과 최적화에 유리하므로, 원하는 경우 외래 키에 NOT NULL 제약 조건을 설정하여, 내부 조인을 유도한다.
    // @JoinColumn(name = "TEAM_ID", nullable = false)
    // 또는 @JoinColumn(name = "TEAM_ID", optional = false)
    private Team team;

    // 지연 로딩
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    // em.find(Member.class, "member1")를 호출하면 회원만 조회하고, 팀은 조회하지 않는다.
    // 조회한 회원의 team 멤버변수에 프록시 객체를 넣어 둔다.
    private Team team2;

}

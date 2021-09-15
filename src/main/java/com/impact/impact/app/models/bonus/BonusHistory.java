package com.impact.impact.app.models.bonus;

import javax.persistence.*;

@Entity
@Table(name = "bonus_history")
public class BonusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long history_id;

    @Column(name = "bonus_type")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bonus_id", nullable = false)
    private BonusType bonusType;

    @Column
    private long total_points;
}

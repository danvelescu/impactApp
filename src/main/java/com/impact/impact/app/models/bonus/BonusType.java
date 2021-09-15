package com.impact.impact.app.models.bonus;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "bonus_types")
public class BonusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bonus_id;

    @Column
    private String bonus_name;

    @Column
    private long bonus_points;
}

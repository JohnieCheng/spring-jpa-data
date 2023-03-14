package com.johnie.springjpadata.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class Role {
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @Column(name = "id", nullable = false)
    private Long id;
    private String no;
    private String name;

}

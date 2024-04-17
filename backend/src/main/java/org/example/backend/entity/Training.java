package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraining;

    private String theme;
    private String state;
    private int staff;
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Groupe> groups;
}

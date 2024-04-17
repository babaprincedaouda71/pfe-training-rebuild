package org.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

//    @SuppressWarnings("JpaAttributeTypeInspection")
@ElementCollection
@CollectionTable(name = "group_dates", joinColumns = @JoinColumn(name = "groupe_id"))
@Column(name = "group_date")
    private List<String> groupDates;
    private int groupStaff;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Training training;
}

package org.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TrainingDTO {
    private String theme;
    private String state;
    private int staff;
    private List<GroupDTO> groups;
}

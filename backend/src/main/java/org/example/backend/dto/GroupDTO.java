package org.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GroupDTO {
    private List<String> groupDates;
    private int groupStaff;
}

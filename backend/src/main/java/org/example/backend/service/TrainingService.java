package org.example.backend.service;

import org.example.backend.dto.TrainingDTO;
import org.example.backend.entity.Training;

import java.util.List;

public interface TrainingService {
//    List<Training> findAll();
//    Training findById(Long id);
    Training createTraining(TrainingDTO trainingDTO);
//    Training updateTraining(Long id, TrainingDTO trainingDTO);
//    void deleteTraining(Long id);
}

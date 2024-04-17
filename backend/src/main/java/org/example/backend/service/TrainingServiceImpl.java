package org.example.backend.service;

import jakarta.transaction.Transactional;
import org.example.backend.dto.GroupDTO;
import org.example.backend.dto.TrainingDTO;
import org.example.backend.entity.Groupe;
import org.example.backend.entity.Training;
import org.example.backend.repo.GroupRepo;
import org.example.backend.repo.TrainingRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {
    private TrainingRepo trainingRepo;
    private GroupRepo groupRepo;

    public TrainingServiceImpl(TrainingRepo trainingRepo, GroupRepo groupRepo) {
        this.trainingRepo = trainingRepo;
        this.groupRepo = groupRepo;
    }

//    @Override
//    public List<Training> findAll() {
//        return trainingRepo.findAll();
//    }
//
//    @Override
//    public Training findById(Long id) {
//        return trainingRepo.findById(id).orElse(null);
//    }

    @Override
    public Training createTraining(TrainingDTO trainingDTO) {
        Training training = new Training();
        training.setTheme(trainingDTO.getTheme());
        training.setState(trainingDTO.getState());
        training.setStaff(trainingDTO.getStaff());

        List<Groupe> groups = new ArrayList<>();
        for (GroupDTO groupDTO : trainingDTO.getGroups()) {
            Groupe group = new Groupe();
            group.setGroupDates(groupDTO.getGroupDates());
            group.setGroupStaff(groupDTO.getGroupStaff());
            group.setTraining(training);  // Associer le groupe à la formation
            groups.add(group);
        }

        training.setGroups(groups);

        // Sauvegarder la formation et les groupes
        training = trainingRepo.save(training);
        for (Groupe group : groups) {
            groupRepo.save(group);
        }

        return training;
    }

//    @Override
//    public void deleteById(Long id) {
//        trainingRepo.deleteById(id);
//    }
//
//    @Override
//    public Training update(Training training, Long id) {
//        return trainingRepo.save(training);
//    }
}

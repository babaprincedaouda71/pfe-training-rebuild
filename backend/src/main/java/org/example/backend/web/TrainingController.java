package org.example.backend.web;

import org.example.backend.dto.TrainingDTO;
import org.example.backend.entity.Training;
import org.example.backend.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

//    @GetMapping("/all")
//    public List<Training> getTrainings() {
//        return trainingService.findAll();
//    }

//    @GetMapping("/find/{id}")
//    public Training getTrainingById(@PathVariable Long id) {
//        return trainingService.findById(id);
//    }

    @PostMapping("/add")
    public Training createTraining(@RequestBody TrainingDTO trainingDTO) {
        return trainingService.createTraining(trainingDTO);
    }

//    @PutMapping("/update/{id}")
//    public Training updateTraining(@PathVariable Long id, @RequestBody Training training) {
//        return trainingService.save(training);
//    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteTraining(@PathVariable Long id) {
//        trainingService.deleteById(id);
//    }
}

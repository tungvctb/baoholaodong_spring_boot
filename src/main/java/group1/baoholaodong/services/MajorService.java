package group1.baoholaodong.services;

import group1.baoholaodong.models.Major;
import group1.baoholaodong.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorRepository majorRepository;

    // Find all majors
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

 // Find major by ID
    public Major findById(int id) {
        return majorRepository.findById(id);
    }

    // Create a new major
    public void create(Major major) {
        LocalDateTime now = LocalDateTime.now();
        major.setCreatedAt(now);
        majorRepository.create(major);
    }

    // Update an existing major
    public void update(Major major) {
        majorRepository.update(major);
    }

    // Delete a major by ID
    public void delete(int id) {
        majorRepository.delete(id);
    }
}

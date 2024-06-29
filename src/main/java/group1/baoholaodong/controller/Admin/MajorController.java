package group1.baoholaodong.controller.Admin;

import group1.baoholaodong.models.Major;
import group1.baoholaodong.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/majors")
public class MajorController {

    @Autowired
    private MajorService majorService;

    // View all majors
    @GetMapping("")
    public String viewAllMajors(Model model) {
        List<Major> majors = majorService.findAll();
        model.addAttribute("majors", majors);
        return "admin/majors/index";
    }

    @GetMapping("/detail/{id}")
    public String viewMajorDetails(@PathVariable("id") int id, Model model) {
        Major major = majorService.findById(id);
        if (major != null) {
            model.addAttribute("major", major);
            return "admin/majors/detail";
        } else {
            return "redirect:/admin/majors";
        }
    }

    // View form to create a new major
    @GetMapping("/create")
    public String viewCreateMajorForm(Model model) {
        model.addAttribute("major", new Major());
        return "admin/majors/create";
    }

    // Create a new major
    @PostMapping("/createMajor")
    public String createMajor(@ModelAttribute Major major) {
        majorService.create(major);
        return "redirect:/admin/majors";
    }

    // View form to update an existing major
    @GetMapping("/edit/{id}")
    public String viewUpdateMajorForm(@PathVariable int id, Model model) {
        Major major = majorService.findById(id);
        if (major != null) {
            model.addAttribute("major", major);
            return "admin/majors/edit";
        } else {
            return "redirect:/admin/majors";
        }
    }

    // Update an existing major
    @PostMapping("/update/{id}")
    public String updateMajor(@PathVariable int id, @ModelAttribute Major major) {
        Major existingMajor = majorService.findById(id);
        if (existingMajor != null) {
            major.setId(id); // Ensure the ID remains the same
            majorService.update(major);
        }
        return "redirect:/admin/majors";
    }

    // Delete a major by ID
    @GetMapping("/delete/{id}")
    public String deleteMajor(@PathVariable int id) {
        Major major = majorService.findById(id);
        if (major != null) {
            majorService.delete(id);
        }
        return "redirect:/admin/majors";
    }
}

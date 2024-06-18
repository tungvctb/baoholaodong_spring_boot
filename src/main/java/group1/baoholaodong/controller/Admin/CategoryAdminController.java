package group1.baoholaodong.controller.Admin;

import group1.baoholaodong.dao.CategoryDAO;
import group1.baoholaodong.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryAdminController {
    @Autowired
    private CategoryDAO categoryDAO;
    @GetMapping("/index")
    public String getCategories(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size){
        List<Category> categories = categoryDAO.findAll(page, size);
        int totalCategories = categoryDAO.count();
        int totalPages = (int) Math.ceil((double) totalCategories / size);
        model.addAttribute("category", categories);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "admin/category/index";
    }

    @GetMapping("/detail")
    public String getCategory(@RequestParam int id, Model model){
        model.addAttribute("category", categoryDAO.findById(id));
        return "admin/category/detail";
    }

    @GetMapping ("/create")
    public String createCategory(Model model){

        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("parentCategory", categories);
        model.addAttribute("category", new Category());
        return "admin/category/create";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, Model model) {
        try {
            int result = categoryDAO.insert(category);
        } catch (IllegalArgumentException e) {
            List<Category> categories = categoryDAO.findAll();
            model.addAttribute("parentCategory", categories);
            return "admin/category/create";
        }
        model.addAttribute("category", categoryDAO.findAll());
        return "redirect:/admin/categories/index?page=1&size=";
    }

    @GetMapping("/edit")
    public String editCategory(@RequestParam int id, Model model){
        model.addAttribute("category",categoryDAO.findById(id));
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("parentCategory", categories);
        return "/admin/category/edit";
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category, Model model) {
        var result = categoryDAO.update(category);
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("parentCategory", categories);
        model.addAttribute("category", categoryDAO.findAll());
        return "redirect:/admin/categories/index?page=1";
    }


    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int id,
                                 @RequestParam int page,
                                 Model model){
        int result = categoryDAO.deleteById(id);
        model.addAttribute("category", categoryDAO.findAll());
        return "redirect:/admin/categories/index?page=" + page + "&size=" + 10;
    }
}

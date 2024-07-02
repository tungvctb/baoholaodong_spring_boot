package group1.baoholaodong.controller;

import group1.baoholaodong.dao.CategoryDAO;
import group1.baoholaodong.models.Category;
import group1.baoholaodong.services.MajorService;
import group1.baoholaodong.models.Major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class HomeController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private MajorService majorService;

    @GetMapping("")
    public String index(){
        List<Category> categories = categoryDAO.findAll();
        return "category/index";
    }
 // a Truong them phan Index cho Customer
    @GetMapping("/demo")
    public String demo(Model model) {
    	List<Major> ls = majorService.findAll();
    	model.addAttribute("ls",ls);
    	return "/customer/index";
    }
}
    

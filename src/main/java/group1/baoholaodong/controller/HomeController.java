package group1.baoholaodong.controller;

import group1.baoholaodong.dao.CategoryDAO;
import group1.baoholaodong.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping("")
    public String index(){
        List<Category> categories = categoryDAO.findAll();
        return "index";
    }
}

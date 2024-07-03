package group1.baoholaodong.controller.Admin;

import group1.baoholaodong.dao.ManufactureDAO;
import group1.baoholaodong.models.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/manu-facture")
public class ManufactureAdminController {
    @Autowired
    private ManufactureDAO manufactoryDAO;

    @GetMapping("")
    public String index (Model model){
        List<Manufacture> manufactures = manufactoryDAO.findAll();
        model.addAttribute("manufactures", manufactures);
        return "admin/manu-facture/index";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("manufacture", new Manufacture());
        return "admin/manu-facture/create";
    }

    @PostMapping ("/create")
    public String create(@ModelAttribute Manufacture manufacture){
        manufactoryDAO.create(manufacture);
        return "redirect:/admin/manu-facture";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id,Model model){
        Manufacture manufacture = manufactoryDAO.findById(id);

        model.addAttribute("manufacture", manufacture);
        return "admin/manu-facture/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id,@ModelAttribute Manufacture manufacture){
        manufactoryDAO.update(manufacture);
        return "redirect:/admin/manu-facture";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        Manufacture manufacture = manufactoryDAO.findById(id);

        model.addAttribute("manufacture", manufacture);
        return "admin/manu-facture/detail";
    }

    @PostMapping("/delete/{id}")
    public String delete (@PathVariable int id, Model mode){
        Manufacture manufacture = manufactoryDAO.findById(id);
        if(manufacture == null){
            return "redirect:/admin/manu-facture";
        }

        manufacture.setStatus((byte) 2);
        manufactoryDAO.update(manufacture);

        return "redirect:/admin/manu-facture";

    }
}

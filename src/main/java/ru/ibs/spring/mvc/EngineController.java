package ru.ibs.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ibs.spring.mvc.service.Engine;

@Controller
@RequestMapping("/")
public class EngineController {
    @Autowired
    private Engine petrolEngine;

    @Autowired
    private Engine dieselEngine;

    @GetMapping("add")
    public String add() {
        return "add";
    }

    @PostMapping("add")
    @FuelExceptionHandle
    public String postAdd(@RequestParam("name") String name, Model model) throws Exception {
        if ("diesel".equalsIgnoreCase(name)) {
            model.addAttribute("addedText", dieselEngine.powerUp());
            return "show";
            //  return "show-diesel";
        } else if ("petrol".equalsIgnoreCase(name)) {
            model.addAttribute("addedText", petrolEngine.powerUp());
            return "show";
        } else {
            throw new Exception();
        }
    }
}


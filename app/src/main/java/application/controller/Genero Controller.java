package application.controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframeworkweb.bind.annotation.requestMethod;
import org.springframeworkweb.bind.annotation.RequestParam; 

import application.model.Genero;
import application.model.GeneroRepository;

@Controller
@RequestMapping("/genero")
public class GeneroController {
    @Autowided
    private GeneroRepository generoRepo;

    @@RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("generos", generoRepo.finalAll());
        return "return/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/genero/insert";
    }

    @RequestMapping(value = "/insert", method = requestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);

        generoRepo.save(genero);
        
        return "redirect:/genero/list";
    }
}
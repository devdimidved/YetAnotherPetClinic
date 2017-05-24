package me.devdimidved.playground.petclinic.controller;

import me.devdimidved.playground.petclinic.model.Vet;
import me.devdimidved.playground.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VetController {

    @Autowired
    VetService vetService;

    @RequestMapping(value = "/vets", method = RequestMethod.GET)
    public String listAllVets(Model model) {
        model.addAttribute("vetList", vetService.findAllVets());
        model.addAttribute("vet", new Vet());
        return "vets";
    }

    @RequestMapping(value = "/vets/save", method = RequestMethod.POST)
    public String saveVet(@ModelAttribute("vet") Vet vet) {
        vetService.saveVet(vet);
        return "redirect:/vets";
    }

    @RequestMapping(value = "/vets/edit/{id}")
    public String editVet (@PathVariable("id") Integer id, Model model) {
        model.addAttribute("vetList", vetService.findAllVets());
        model.addAttribute("vet", vetService.findVetById(id));
        return "vets";
    }

    @RequestMapping(value = "/vets/delete/{id}")
    public String deleteVet(@PathVariable("id") Integer id) {
        vetService.deleteVetById(id);
        return "redirect:/vets";
    }
}

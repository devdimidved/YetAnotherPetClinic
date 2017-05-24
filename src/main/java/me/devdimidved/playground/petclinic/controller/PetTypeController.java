package me.devdimidved.playground.petclinic.controller;

import me.devdimidved.playground.petclinic.model.PetType;
import me.devdimidved.playground.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PetTypeController {

    @Autowired
    PetTypeService petTypeService;

    @RequestMapping(value = "/pettypes", method = RequestMethod.GET)
    public String listAllPetTypes(Model model) {
        model.addAttribute("petTypeList", petTypeService.findAllPetTypes());
        model.addAttribute("petType", new PetType());
        return "pettypes";
    }

    @RequestMapping(value = "/pettypes/save", method = RequestMethod.POST)
    public String savePetType(@ModelAttribute("petType") PetType petType) {
        petTypeService.savePetType(petType);
        return "redirect:/pettypes";
    }

    @RequestMapping(value = "/pettypes/edit/{id}")
    public String editPetType (@PathVariable("id") Integer id, Model model) {
        model.addAttribute("petTypeList", petTypeService.findAllPetTypes());
        model.addAttribute("petType", petTypeService.findPetTypeById(id));
        return "pettypes";
    }

    @RequestMapping(value = "/pettypes/delete/{id}")
    public String deletePetType(@PathVariable("id") Integer id) {
        petTypeService.deletePetTypeById(id);
        return "redirect:/pettypes";
    }
}

package me.devdimidved.playground.petclinic.controller;

import me.devdimidved.playground.petclinic.model.Owner;
import me.devdimidved.playground.petclinic.model.Pet;
import me.devdimidved.playground.petclinic.model.PetType;
import me.devdimidved.playground.petclinic.service.OwnerService;
import me.devdimidved.playground.petclinic.service.PetService;
import me.devdimidved.playground.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    PetTypeService petTypeService;

    @Autowired
    OwnerService ownerService;

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Integer ownerId) {
        return ownerService.findOwnerById(ownerId);
    }

    @ModelAttribute("petTypeList")
    public List<PetType> populatePetTypes() {
        return petTypeService.findAllPetTypes();
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/pets/edit/{petId}")
    public String editPet (@PathVariable("petId") Integer petId, Model model) {
        model.addAttribute("pet", petService.findPetById(petId));
        return "petdata";
    }

    @RequestMapping(value = "/pets/add")
    public String addPet (Model model) {
        model.addAttribute("pet", new Pet());
        return "petdata";
    }

    @RequestMapping(value = "/pets/save", method = RequestMethod.POST)
    public String savePet(@ModelAttribute("owner") Owner owner, @ModelAttribute("pet") Pet pet) {
        pet.setOwner(owner);
        petService.savePet(pet);
        return "redirect:/owners/{ownerId}";
    }

    @RequestMapping(value = "/pets/delete/{petId}")
    public String deletePet (@PathVariable("petId") Integer petId) {
        petService.deletePetById(petId);
        return "redirect:/owners/{ownerId}";
    }
}

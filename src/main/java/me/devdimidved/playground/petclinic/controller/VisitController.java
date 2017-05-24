package me.devdimidved.playground.petclinic.controller;

import me.devdimidved.playground.petclinic.model.Pet;
import me.devdimidved.playground.petclinic.model.Vet;
import me.devdimidved.playground.petclinic.model.Visit;
import me.devdimidved.playground.petclinic.service.PetService;
import me.devdimidved.playground.petclinic.service.VetService;
import me.devdimidved.playground.petclinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class VisitController {

    @Autowired
    VisitService visitService;

    @Autowired
    PetService petService;

    @Autowired
    VetService vetService;

    @InitBinder("pet")
    public void setPetDisallowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("pet")
    public Pet findPet(@PathVariable("petId") Integer petId) {
        return petService.findPetById(petId);
    }

    @RequestMapping(value = "/owners/*/pets/{petId}/visits/add")
    public String addNewVisit(Model model) {
        model.addAttribute("vetList", vetService.findAllVets());
        model.addAttribute("visit", new Visit());
        return "visitdetails";
    }

    @RequestMapping(value = "/owners/*/pets/{petId}/visits/edit/{visitId}")
    public String updateVisit(@PathVariable("visitId") Integer visitId, Model model) {
        model.addAttribute("vetList", vetService.findAllVets());
        model.addAttribute("visit", visitService.findVisitById(visitId));
        return "visitdetails";
    }

    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}/visits/save", method = RequestMethod.POST)
    public String savePet(@ModelAttribute("pet") Pet pet, @ModelAttribute("visit") Visit visit, @RequestParam("vetId") Integer vetId) {
        Vet vet = vetService.findVetById(vetId);
        visit.setPet(pet);
        visit.setVet(vet);
        visitService.saveVisit(visit);
        return "redirect:/owners/{ownerId}";
    }
}

package me.devdimidved.playground.petclinic.controller;

import me.devdimidved.playground.petclinic.model.Owner;
import me.devdimidved.playground.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public String listOwners(Model model, @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("ownerList", ownerService.findOwnerByName(name));
        return "owners";
    }

    @RequestMapping(value = "/owners/save", method = RequestMethod.POST)
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners/" + owner.getId();
    }

    @RequestMapping(value = "/owners/add", method = RequestMethod.GET)
    public String addOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "ownerdata";
    }

    @RequestMapping(value = "/owners/edit/{id}")
    public String editOwner (@PathVariable("id") Integer id, Model model) {
        model.addAttribute("owner", ownerService.findOwnerById(id));
        return "ownerdata";
    }

    @RequestMapping(value = "/owners/delete/{id}")
    public String deleteOwner(@PathVariable("id") Integer id) {
        ownerService.deleteOwnerById(id);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/{id}")
    public String listOwnerDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("owner", ownerService.findOwnerById(id));
        return "ownerdetails";
    }
}

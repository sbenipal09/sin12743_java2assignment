package sheridan.sin12743.assignment2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sheridan.sin12743.assignment2.model.Pet;
import sheridan.sin12743.assignment2.service.PetService;
//controller class
@Controller
@RequestMapping(value={"/pets","/"})
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {

        this.petService = petService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "list-pets";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("pet", new Pet());
        return "new-pet";
    }

    @PostMapping
    public String save(@ModelAttribute("pet")  Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-pet";
        }

        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id));
        return "edit-pet";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("pet")  Pet pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            pet.setId(id);
            return "edit-pet";
        }

        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }
}



package com.example.myspringbootcrudappcurso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myspringbootcrudappcurso.entities.Estudio;
import com.example.myspringbootcrudappcurso.services.EstudioService;

/**
 * Estudio controller.
 */
@Controller
public class EstudioController {

    private EstudioService estudioService;

    @Autowired
    public void setEstudioService(EstudioService estudioService) {
        this.estudioService = estudioService;
    }

    /**
     * List all estudios.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/estudio", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("estudios", estudioService.listAllEstudios());
        System.out.println("Returning restudios:");
        return "estudios";
    }

    

    /**
     * View a specific estudio by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("estudio/{id}")
    public String showEstudio(@PathVariable Integer id, Model model) {
        model.addAttribute("estudio", estudioService.getEstudioById(id));
        return "estudioshow";
    }

    // Afficher le formulaire de modification du Estudio
    @RequestMapping("estudio/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("estudio", estudioService.getEstudioById(id));
        return "estudioform";
    }

    /**
     * New estudio.
     *
     * @param model
     * @return
     */
    @RequestMapping("estudio/new")
    public String newEstudio(Model model) {
        model.addAttribute("estudio", new Estudio());
        return "estudioform";
    }

    /**
     * Save estudio to database.
     *
     * @param estudio
     * @return
     */
    @RequestMapping(value = "estudio", method = RequestMethod.POST)
    public String saveEstudio(Estudio estudio) {
        estudioService.saveEstudio(estudio);
        return "redirect:/estudio/" + estudio.getId();
    }

    /**
     * Delete estudio by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("estudio/delete/{id}")
    public String delete(@PathVariable Integer id) {
        estudioService.deleteEstudio(id);
        return "redirect:/estudios";
    }

}

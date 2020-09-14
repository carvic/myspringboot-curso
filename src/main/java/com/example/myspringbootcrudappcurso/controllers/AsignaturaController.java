package com.example.myspringbootcrudappcurso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.services.AsignaturaService;

/**
 * Asignatura controller.
 */
@Controller
public class AsignaturaController {

    private AsignaturaService asignaturaService;

    @Autowired
    public void setAsignaturaService(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    /**
     * List all asignaturas.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/asignatura", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("asignaturas", asignaturaService.listAllAsignaturas());
        System.out.println("Returning rasignaturas:");
        return "asignaturas";
    }

    /**
     * View a specific asignatura by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("asignatura/{id}")
    public String showAsignatura(@PathVariable Integer id, Model model) {
        model.addAttribute("asignatura", asignaturaService.getAsignaturaById(id));
        return "asignaturashow";
    }

    // Afficher le formulaire de modification du Asignatura
    @RequestMapping("asignatura/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("asignatura", asignaturaService.getAsignaturaById(id));
        return "asignaturaform";
    }

    /**
     * New asignatura.
     *
     * @param model
     * @return
     */
    @RequestMapping("asignatura/new")
    public String newAsignatura(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "asignaturaform";
    }

    /**
     * Save asignatura to database.
     *
     * @param asignatura
     * @return
     */
    @RequestMapping(value = "asignatura", method = RequestMethod.POST)
    public String saveAsignatura(Asignatura asignatura) {
        asignaturaService.saveAsignatura(asignatura);
        return "redirect:/asignatura/" + asignatura.getId();
    }

    /**
     * Delete asignatura by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("asignatura/delete/{id}")
    public String delete(@PathVariable Integer id) {
        asignaturaService.deleteAsignatura(id);
        return "redirect:/asignaturas";
    }

}

package com.example.myspringbootcrudappcurso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myspringbootcrudappcurso.entities.Pregunta;
import com.example.myspringbootcrudappcurso.services.PreguntaService;

/**
 * Pregunta controller.
 */
@Controller
public class PreguntaController {

    private PreguntaService preguntaService;

    @Autowired
    public void setPreguntaService(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    /**
     * List all preguntas.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/pregunta", method = RequestMethod.GET)
    public String list(Model model) {
        //model.addAttribute("preguntas", preguntaService.listAllPreguntas());
        model.addAttribute("preguntas", preguntaService.listAllPreguntasByEstudio("Ingeniería industrial"));

        System.out.println("Returning rpreguntas:");
        return "preguntas";
    }

    /**
     * View a specific pregunta by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("pregunta/{id}")
    public String showPregunta(@PathVariable Integer id, Model model) {
        model.addAttribute("pregunta", preguntaService.getPreguntaById(id));
        return "preguntashow";
    }

    // Afficher le formulaire de modification du Pregunta
    @RequestMapping("pregunta/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pregunta", preguntaService.getPreguntaById(id));
        return "preguntaform";
    }

    /**
     * New pregunta.
     *
     * @param model
     * @return
     */
    @RequestMapping("pregunta/new")
    public String newPregunta(Model model) {
        model.addAttribute("pregunta", new Pregunta());
        return "preguntaform";
    }

    /**
     * Save pregunta to database.
     *
     * @param pregunta
     * @return
     */
    @RequestMapping(value = "pregunta", method = RequestMethod.POST)
    public String savePregunta(Pregunta pregunta) {
        preguntaService.savePregunta(pregunta);
        return "redirect:/pregunta/" + pregunta.getId();
    }

    /**
     * Delete pregunta by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("pregunta/delete/{id}")
    public String delete(@PathVariable Integer id) {
        preguntaService.deletePregunta(id);
        return "redirect:/preguntas";
    }

}

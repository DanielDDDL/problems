package br.mackenzie.lfs.controllers;

import br.mackenzie.lfs.model.Person;
import br.mackenzie.lfs.service.SomeOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SomeOtherController {

    @Autowired
    private SomeOtherService service;

    @RequestMapping(value = "/something", method = RequestMethod.GET)
    public ModelAndView someEndPoint(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", service.someOtherMethod("Something"));
        return mav;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public RedirectView firstEntry(RedirectAttributes attributes){
        attributes.addAttribute("message","Hey. This is message is passed in a redirection");
        return new RedirectView("/test/redirect");
    }

    @RequestMapping(value = "/test/redirect")
    public ModelAndView redirectEntry (@ModelAttribute("message") String message){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", message);
        return mav;
    }

    @RequestMapping(value = "/secondentry", method = RequestMethod.GET)
    public RedirectView secondEntry(RedirectAttributes attributes){
        Person somePerson = new Person();
        somePerson.setName("Joana");
        somePerson.setAge(16);
        somePerson.setSomeOtherInformation("Something");
        attributes.addFlashAttribute("person",somePerson);
        return new RedirectView("/another/redirect");
    }

    @RequestMapping(value = "/another/redirect", method = RequestMethod.GET)
    public ModelAndView secondRedirectEntry (@ModelAttribute("person") Person person){

        if(person == null)
            System.out.println("Person is null");
        else {
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getSomeOtherInformation());
        }

        ModelAndView mav = new ModelAndView("person");
        mav.addObject("person",person);
        return mav;
    }

    @RequestMapping(value = "saying/{message}", method = RequestMethod.GET)
    public ModelAndView testingHomeMessageEntryController (@PathVariable("message") String message){

        ModelAndView mav = new ModelAndView();
        mav.addObject("message",message + "something else at the end");
        mav.setViewName("redirect:/home");

        return mav;
    }

    /**
     * So apparently I can receive a message and pass it right along, without mentioning its existence *inside*
     * the handling method of the controller
     *
     * which is nice, but it also means that i will have parameter like the message below, without any real use
     * it's better than adding it every time to the model, I guess
     * */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView homeController (@ModelAttribute("message") String message) {

        ModelAndView mav = new ModelAndView("home");

        return mav;
    }

}

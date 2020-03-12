package pmtest.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pmtest.org.model.Event;
import pmtest.org.model.EventWrapper;
import pmtest.org.service.TeamServiceImplementation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class ControllerEvent {

    private static final org.apache.logging.log4j.Logger logger =  org.apache.logging.log4j.LogManager.getLogger(ControllerEvent.class);

    @Autowired
    private TeamServiceImplementation teamServiceImplementation;

    @RequestMapping (value = "/start", method = RequestMethod.GET)
    public String startPmExpress(){
        return "index.jsp";
    }

    @GetMapping (value = "/bye")
    public String byePmExpress(){
        return "bye.jsp";
    }

    @GetMapping (value = "/passData")
    public String passData(){
        return "passData.jsp";
    }

    @GetMapping (value = "/sum")
    public ModelAndView getNameEvent(ModelAndView modelAndView)
    {
        List<Event> response =  teamServiceImplementation.listAllEvents();
        int sumWin = 1;
        for (Event e: response
             ) {
            if (e.getBackEvent().equals("true")){
                sumWin *= 1;
            } else {
                sumWin *= e.getKefEvent();
            }
            if (e.getLoseEvent().equals("true")){
                sumWin *= 0;
            } else {
                sumWin *= e.getKefEvent();
            }
        }
        sumWin = sumWin * (Integer.parseInt(response.get(0).getSumEvent()));
        modelAndView.addObject("sumWin", sumWin);
        modelAndView.addObject("events", response);
        modelAndView.setViewName("sum.jsp");
        return modelAndView;
    }


    @PostMapping (value = "/add" , headers = {"Content-type=application/json"})
    @ResponseBody
    public ModelAndView addNewEvent(@RequestBody EventWrapper wrapper) throws IOException {
        List<String> response = new ArrayList<String>();
        for (Event event : wrapper.getEvents()) {
            teamServiceImplementation.addTeam(event);
            response.add(event.toString());
        }
        for (String s: response) {
            logger.info("+++: "+s);
        }
           return new ModelAndView("redirect:/sum");
    }






}















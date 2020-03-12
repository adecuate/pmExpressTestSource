package pmtest.org.service;

import pmtest.org.model.Event;
import pmtest.org.model.EventWrapper;

import java.util.List;


public interface TeamServiceInterface {
    List <String> getNameEvent();
    List<Event> findAll();
    List<Event> listAllEvents();
    Event addTeam (Event event);
    List<Event> addListTeam (List<Event> event);
}

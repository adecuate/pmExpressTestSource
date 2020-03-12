package pmtest.org.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmtest.org.dao.repositories.TeamRepository;
import pmtest.org.model.Event;
import pmtest.org.model.EventWrapper;

import java.util.List;

@Service
public class TeamServiceImplementation implements TeamServiceInterface {

    private TeamRepository teamRepository;

    @Override
    public List<String> getNameEvent() {
        return teamRepository.getNameEvent();
    }

    @Override
    public List<Event> addListTeam(List<Event> events) {
        return (List<Event>) teamRepository.saveAll(events);
    }


    @Override
    public List<Event> findAll() {
        return Lists.newArrayList(teamRepository.findAll());
    }

    @Override
    public List<Event> listAllEvents() {
        return (List<Event>)teamRepository.findAll();
    }

    @Override
    public Event addTeam(Event event) {
        return teamRepository.save(event);
    }

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}

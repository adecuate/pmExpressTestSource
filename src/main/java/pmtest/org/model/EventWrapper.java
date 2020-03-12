package pmtest.org.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Setter
@Getter
public class EventWrapper implements Serializable {
    private List <Event> events;
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

package basicmeeting.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import basicmeeting.demo.model.Host;
import basicmeeting.demo.service.HostService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "host-attendance")
@RestController
public class HostController {
    @Autowired HostService infoserv;
    @PostMapping("/addhostinfo")
    public Host postMethodName1(@RequestBody Host info) {
        
        return infoserv.addinfo(info);
    }
    @GetMapping("/gethostinfo")
    public List<Host> getMethodName() {
        return infoserv.getinfo();
    }
    @GetMapping("/gethostinfo/{meeting_id}")
    public Optional<Host> getinfoid(@PathVariable int meeting_id) {
        return infoserv.getinfobyid(meeting_id);
    }
    @GetMapping("/getpaginatedhosts/{page}/{size}/{sortBy}")
    public Page<Host> getPaginatedHosts(@PathVariable int page, @PathVariable int size, @PathVariable String sortBy) {
        return infoserv.getPaginatedMeetings(page, size, sortBy);
    }
}

package com.wembleyleach.library.patrons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1", headers = "Accept=application/json")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @PostMapping("/patrons")
    @ResponseBody
    public Patron createPatron(@RequestBody Patron body) {
        return patronService.addPatron(body);
    }

    @GetMapping("/patrons/{patronId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Patron getPatron(@PathVariable("patronId") long patronId) {
        return patronService.getPatronById(patronId);
    }
}

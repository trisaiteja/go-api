package com.vertafore.go.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoController {

    @Autowired
    private IGoService service;

    @PostMapping("/add")
    public void add(@RequestBody Go go) {
        service.add(go);
    }

    @PutMapping("/update")
    public Go update(@RequestBody Go go) {
        return service.update(go);
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @GetMapping("/list")
    public List<Go> list() {
        return service.list();
    }

    @GetMapping("/{short_name}")
    public String getUrl(@PathVariable String short_name) {
        return service.getUrl(short_name);
    }

}

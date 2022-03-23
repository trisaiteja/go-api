package com.vertafore.go.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoService implements IGoService {

    @Autowired
    private GoRepository repository;

    @Override
    public void add(Go go) {
        repository.save(go);
    }

    @Override
    public Go update(Go go) {
        Optional<Go> og = repository.findById(go.getId());
        Go ug = (og.isPresent() ? og.get() : null);
        ug.setId(go.getId());
        ug.setName(go.getName());
        ug.setShort_name(go.getShort_name());
        ug.setDescription(go.getDescription());
        ug.setUrl(go.getUrl());
        return repository.save(ug);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Go> list() {
        List<Go> list = (List<Go>) repository.findAll();
        return list;
    }

    @Override
    public String getUrl(String shortName) {
        List<Go> list = (List<Go>) repository.findAll();
        for (Go go : list) {
            if (go.getShort_name().equals(shortName)) {
                return go.getUrl();
            }
        }
        return null;
    }

}
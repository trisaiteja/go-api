package com.vertafore.go.api;

import java.util.List;

public interface IGoService {

    void add(Go go);

    Go update(Go go);

    void remove(Long id);

    List<Go> list();

    String getUrl(String shortName);

}

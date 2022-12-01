package com.software.kudos.services;

import com.software.kudos.models.KudoDto;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Kudos;

import java.util.List;

public interface KudoServiceInterface {
    List<Kudos> getKudos();

    Kudos getKudo(String id);

    boolean create(KudoDto newKudo);
    boolean update(KudoDto newKudo, String id);

    void deleteKudo(String id);
}

package com.software.kudos.controllers;

import com.software.kudos.models.KudoDto;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Kudos;
import com.tej.JooQDemo.jooq.sample.model.tables.records.KudosRecord;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface KudosControllerInterface {
    ResponseEntity<List<Kudos>> getKudos();
//
    ResponseEntity<Kudos> getKudo(String id);
//
    ResponseEntity<Boolean> createKudo(KudoDto kudo);
//
    ResponseEntity<Boolean> updateKudo(KudoDto kudo, String id);
//
    ResponseEntity<Boolean> deleteKudo(String id);
}

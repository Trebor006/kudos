package com.software.kudos.controllers;

import com.software.kudos.models.KudoDto;
import com.software.kudos.services.KudoServiceInterface;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Kudos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/kudos")
@RequiredArgsConstructor
public class KudosController implements KudosControllerInterface {

    private final ObjectFactory<KudoServiceInterface> kudoServiceFactory;

    @Override
    @GetMapping
    public ResponseEntity<List<Kudos>> getKudos() {
        try {
            var kudos = kudoServiceFactory.getObject().getKudos();
            return new ResponseEntity<>(kudos, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Kudos> getKudo(@PathVariable String id) {
        try {
            Kudos kudo = kudoServiceFactory.getObject().getKudo(id);
            return new ResponseEntity<>(kudo, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Boolean> createKudo(@RequestBody KudoDto newKudo) {
        try {
            var kudo = kudoServiceFactory.getObject().create(newKudo);
            return new ResponseEntity<>(kudo, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateKudo(@RequestBody KudoDto updatedKudo, @PathVariable String id) {
        try {
            var kudo = kudoServiceFactory.getObject().update(updatedKudo, id);
            return new ResponseEntity<>(kudo, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteKudo(@PathVariable String id) {
        try {
            kudoServiceFactory.getObject().deleteKudo(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

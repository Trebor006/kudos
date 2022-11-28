package com.software.kudos.controllers;

import com.software.kudos.models.KudoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KudosControllerInterface {
    ResponseEntity<List<KudoDto>> getKudos();

    ResponseEntity<KudoDto> getKudo(String id);

    ResponseEntity<KudoDto> createKudo(KudoDto kudo);

    ResponseEntity<KudoDto> updateKudo(KudoDto kudo, String id);

    ResponseEntity<Boolean> deleteKudo(String id);
}

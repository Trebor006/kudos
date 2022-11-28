package com.software.kudos.services;

import com.software.kudos.components.redis.exceptions.ConnectionException;
import com.software.kudos.models.KudoDto;

import java.util.List;

public interface KudoServiceInterface {
    List<KudoDto> getKudos() throws ConnectionException;

    KudoDto getKudo(String id) throws ConnectionException;

    KudoDto createUpdate(KudoDto kudo) throws ConnectionException;

    void deleteKudo(String id) throws ConnectionException;
}

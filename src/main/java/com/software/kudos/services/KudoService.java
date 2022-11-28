package com.software.kudos.services;

import com.google.gson.Gson;
import com.software.kudos.components.redis.RedisClientInterface;
import com.software.kudos.components.redis.exceptions.ConnectionException;
import com.software.kudos.models.KudoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KudoService implements KudoServiceInterface {

    private final ObjectFactory<RedisClientInterface> jedisServiceFactory;

    @Override
    public List<KudoDto> getKudos() throws ConnectionException {
        return Arrays.asList(new Gson().fromJson(jedisServiceFactory.getObject().getObject(), KudoDto[].class));
    }

    @Override
    public KudoDto getKudo(String id) throws ConnectionException {
        return new Gson().fromJson(jedisServiceFactory.getObject().getObjectById(id), KudoDto.class);
    }

    @Override
    public KudoDto createUpdate(KudoDto kudo) throws ConnectionException {
        jedisServiceFactory.getObject().addUpdateObjectOnNamespace(kudo.getRecipientEmployeeId(), new Gson().toJson(kudo));
        return kudo;
    }

    @Override
    public void deleteKudo(String id) throws ConnectionException {
        jedisServiceFactory.getObject().removeObjectOnNamespace(id);
    }
}

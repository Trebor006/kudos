package com.software.kudos.services;

import com.software.kudos.models.KudoDto;
import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Kudos;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KudoService implements KudoServiceInterface {
    @Autowired
    DSLContext context;

    public List<Kudos> getKudos() {
        return context
                .selectFrom(Tables.KUDOS)
                .fetchInto(Kudos.class);
    }

    @Override
    public Kudos getKudo(String id) {
        return context
                .selectFrom(Tables.KUDOS)
                .where(
                        Tables.KUDOS.ID.eq(Integer.valueOf(id))
                )
                .fetchSingle().into(Kudos.class);
    }

    @Override
    public boolean create(KudoDto newKudo) {
        context
                .insertInto(Tables.KUDOS, Tables.KUDOS.SUBJECT,
                        Tables.KUDOS.DATE, Tables.KUDOS.RECIPIENTEMPLOYEEID,
                        Tables.KUDOS.TEXT, Tables.KUDOS.SOURCEEMPLOYEEID
                )
                .values(
                        newKudo.getSubject(),
                        newKudo.getDate(),
                        newKudo.getRecipientEmployeeId(),
                        newKudo.getText(),
                        newKudo.getSourceEmployeeId()
                )
                .execute();
        return true;
    }

    @Override
    public boolean update(KudoDto newKudo, String id) {
        context.update(Tables.KUDOS)
                .set(Tables.KUDOS.SUBJECT, newKudo.getSubject())
                .set(Tables.KUDOS.DATE, newKudo.getDate())
                .set(Tables.KUDOS.RECIPIENTEMPLOYEEID, newKudo.getRecipientEmployeeId())
                .set(Tables.KUDOS.TEXT, newKudo.getText())
                .set(Tables.KUDOS.SOURCEEMPLOYEEID, newKudo.getSourceEmployeeId())
                .where(Tables.KUDOS.ID.eq(Integer.valueOf(id)))
                .execute();
        return true;
    }

    @Override
    public void deleteKudo(String id) {
        context.delete(Tables.KUDOS)
                .where(Tables.KUDOS.ID.eq(Integer.valueOf(id)))
                .execute();
    }

    public List<Kudos> getKudoById(Integer id) {
        return context
                .selectFrom(Tables.KUDOS)

                .fetchInto(Kudos.class);
    }

    public void insertKudo(Kudos kudo) {

    }
}

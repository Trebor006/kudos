package com.software.kudos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.software.kudos.constants.GeneralConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KudoDto {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @JsonProperty(GeneralConstant.TEMA)
    private String subject;

    @JsonProperty(GeneralConstant.FECHA)
    private String date;

    @JsonProperty(GeneralConstant.EMPLEADO_DESTINATARIO)
    private String recipientEmployeeId;

    @JsonProperty(GeneralConstant.TEXTO)
    private String text;

    @JsonProperty(GeneralConstant.EMPLEADO_ORIGEN)
    private String sourceEmployeeId;
}

package com.software.kudos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.software.kudos.constants.GeneralConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;

    @JsonProperty(GeneralConstant.EMPLEADO_DESTINATARIO)
    private String recipientEmployeeId;

    @JsonProperty(GeneralConstant.TEXTO)
    private String text;

    @JsonProperty(GeneralConstant.EMPLEADO_ORIGEN)
    private String sourceEmployeeId;
}

package com.project.dvdrental.Filme.Dto;

import java.util.Objects;
import com.project.dvdrental.Filme.Model.Ator;
import com.project.dvdrental.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtorDto {

    private Integer id;
    private String primeiroNome;
    private String ultimoNome;

    public static AtorDto of(Ator entity) {

        if (Objects.isNull(entity)) {
            return null;
        }

        AtorDto dto = new AtorDto();

        Optional.ofValue(entity.getAtorId())
                .to(dto::setId);

        Optional.ofValue(entity.getPrimeiroNome())
                .to(dto::setPrimeiroNome);

        Optional.ofValue(entity.getUltimoNome())
                .to(dto::setUltimoNome);

        return dto;
    }
}

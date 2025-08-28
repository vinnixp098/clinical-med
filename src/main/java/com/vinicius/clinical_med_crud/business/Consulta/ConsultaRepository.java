package com.vinicius.clinical_med_crud.business.Consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByDataConsultaAndCrm(@NotNull LocalDate localDate, @NotBlank @Pattern(regexp = "\\d{4,6}") String crm);
}

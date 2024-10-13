package com.relatorios.demo.Controller;

import com.relatorios.demo.model.Municipio;
import com.relatorios.demo.model.Uf;
import com.relatorios.demo.repository.MunicipioRepository;
import com.relatorios.demo.repository.UfRepository;
import com.relatorios.demo.service.ReportSevice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("municipio")
@AllArgsConstructor
public class MunicipioController {

    private final MunicipioRepository repository;
    private final ReportSevice reportSevice;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Municipio> data = repository.findAll();
        Map<String, Object> params = new HashMap<>();
        params.put("nmSistema", "Sistema Gerador de Relatórios");
        reportSevice.generateReport(data, params, "MunicipioReport.pdf", "MunicipioReport.jrxml");
        return ResponseEntity.ok("Sucesss");
    }
}

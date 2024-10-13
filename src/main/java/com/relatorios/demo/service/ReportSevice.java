package com.relatorios.demo.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportSevice {
    private final String filePath = "C:\\Users\\Wesley Bruno\\Documents\\workspace\\Spring\\Ireport-Relatorios\\ireportCrieRelatoriosPraticosEelegantes\\demo\\src\\main\\resources\\templates\\";

    public void generateReport(List<?> data, Map<String, Object> parameters, String pdfName, String reportName) {

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(filePath + reportName);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Wesley Bruno\\Documents\\workspace\\Spring\\Ireport-Relatorios\\ireportCrieRelatoriosPraticosEelegantes\\demo\\src\\main\\resources\\static\\" + pdfName);
            System.out.println("Report Generated successfully");
        } catch (JRException e) {
            System.err.println(e.getMessage());
            e.getMessage();
        }
    }
}

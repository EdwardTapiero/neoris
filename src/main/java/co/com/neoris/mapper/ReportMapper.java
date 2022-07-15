package co.com.neoris.mapper;

import co.com.neoris.dto.ReportDTO;
import co.com.neoris.entity.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDTO getReportDTO(Movimiento report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setFecha(report.getFecha());
        reportDTO.setCliente(report.getCuenta().getCliente().getNombre());
        reportDTO.setNumeroCuenta(report.getCuenta().getNumeroCuenta());
        reportDTO.setTipo(report.getTipoMovimiento());
        reportDTO.setSaldoInicial(report.getCuenta().getSaldoInicial());
        reportDTO.setEstado(report.getCuenta().isEstado());
        reportDTO.setMovimiento(report.getValor());
        reportDTO.setSaldoDisponible(report.getSaldo());
        return reportDTO;
    }
}

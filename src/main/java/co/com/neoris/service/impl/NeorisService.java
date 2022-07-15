package co.com.neoris.service.impl;

import co.com.neoris.dto.ReportListDTO;
import co.com.neoris.entity.Cliente;
import co.com.neoris.entity.Cuenta;
import co.com.neoris.entity.Movimiento;
import co.com.neoris.exception.NeorisException;

import java.time.LocalDate;

public interface NeorisService {

    int saveAccount(Cuenta cuenta) throws NeorisException;

    int updateAccount(Cuenta cuenta) throws NeorisException;

    String removeAccount(Integer id) throws NeorisException;

    int saveClient(Cliente cliente) throws NeorisException;

    int updateClient(Cliente cliente) throws NeorisException;

    String removeClient(Integer id) throws NeorisException;

    int saveMovements(Movimiento movimiento) throws NeorisException;

    int updateMovements(Movimiento movimiento) throws NeorisException;

    String removeMovements(Integer id) throws NeorisException;

    ReportListDTO reports(LocalDate fecha) throws NeorisException;
}

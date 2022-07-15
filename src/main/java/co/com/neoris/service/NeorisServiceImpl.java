package co.com.neoris.service;

import co.com.neoris.controller.NeorisController;
import co.com.neoris.dto.ReportListDTO;
import co.com.neoris.entity.Cliente;
import co.com.neoris.entity.Cuenta;
import co.com.neoris.entity.Movimiento;
import co.com.neoris.exception.NeorisException;
import co.com.neoris.mapper.ReportMapper;
import co.com.neoris.repository.AccountRepository;
import co.com.neoris.repository.ClientRepository;
import co.com.neoris.repository.MovementsRepository;
import co.com.neoris.service.impl.NeorisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NeorisServiceImpl implements NeorisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NeorisController.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MovementsRepository movementsRepository;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public int saveAccount(Cuenta cuenta) throws NeorisException {

        LOGGER.info("Iniciando servicio saveAccount: {}", cuenta);

        try {

            if (cuenta.getId() != null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id debe ser nulo");
            }

            Cuenta response = accountRepository.save(cuenta);

            LOGGER.info("Finalizando servicio saveAccount: {}", cuenta);

            return response.getId();
        } catch (Exception ex) {
            LOGGER.error("Error al guardar cuenta: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido guardar la cuenta");
        }
    }

    @Override
    public int updateAccount(Cuenta cuenta) throws NeorisException {

        LOGGER.info("Iniciando servicio updateAccount: {}", cuenta);

        try {

            if (cuenta.getId() == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Cuenta> accountById = accountRepository.findById(cuenta.getId());

            if (accountById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            Cuenta response = accountRepository.save(cuenta);

            LOGGER.info("Finalizando servicio updateAccount: {}", cuenta);

            return response.getId();
        } catch (Exception ex) {
            LOGGER.error("Error al actualizar cuenta: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido actualizar la cuenta");
        }
    }

    @Override
    public String removeAccount(Integer id) throws NeorisException {

        LOGGER.info("Iniciando servicio removeAccount: {}", id);

        try {

            if (id == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Cuenta> accountById = accountRepository.findById(id);

            if (accountById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            accountRepository.deleteById(id);

            LOGGER.info("Finalizando servicio removeAccount: {}", id);

            return "Se ha eliminado el id: " + id + ", exitosamente";
        } catch (Exception ex) {
            LOGGER.error("Error al eliminar cuenta id: {} ", id, ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido eliminar la cuenta");
        }
    }

    @Override
    public int saveClient(Cliente cliente) throws NeorisException {

        LOGGER.info("Iniciando servicio saveClient: {}", cliente);

        try {

            if (cliente.getId() != null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id debe ser nulo");
            }

            Cliente response = clientRepository.save(cliente);

            LOGGER.info("Finalizando servicio saveClient: {}", cliente);

            return response.getId();
        } catch (Exception ex) {
            LOGGER.error("Error al guardar cliente: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido guardar cliente");
        }
    }

    @Override
    public int updateClient(Cliente cliente) throws NeorisException {

        LOGGER.info("Iniciando servicio updateClient: {}", cliente);

        try {

            if (cliente.getId() == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Cliente> clientById = clientRepository.findById(cliente.getId());

            if (clientById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            Cliente response = clientRepository.save(cliente);

            LOGGER.info("Finalizando servicio updateClient: {}", cliente);

            return response.getId();
        } catch (Exception ex) {
            LOGGER.error("Error al actualizar cliente: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido actualizar cliente");
        }
    }

    @Override
    public String removeClient(Integer id) throws NeorisException {

        LOGGER.info("Iniciando servicio removeClient: {}", id);

        try {

            if (id == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Cliente> clientById = clientRepository.findById(id);

            if (clientById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            clientRepository.deleteById(id);

            LOGGER.info("Finalizando servicio removeClient: {}", id);

            return "Se ha eliminado el id: " + id + ", exitosamente";
        } catch (Exception ex) {
            LOGGER.error("Error al eliminar cliente id: {} ", id, ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido eliminar cliente");
        }
    }

    @Override
    public int saveMovements(Movimiento movimiento) throws NeorisException {

        LOGGER.info("Iniciando servicio saveMovements: {}", movimiento);



            if (movimiento.getId() != null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id debe ser nulo");
            }

        Movimiento response = getMovements(movimiento);
        LOGGER.info("Finalizando servicio saveMovements: {}", movimiento);

            return response.getId();


    }

    @Override
    public int updateMovements(Movimiento movimiento) throws NeorisException {

        LOGGER.info("Iniciando servicio updateMovements: {}", movimiento);

        try {

            if (movimiento.getId() == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Movimiento> clientById = movementsRepository.findById(movimiento.getId());

            if (clientById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            Movimiento response = getMovements(movimiento);

            LOGGER.info("Finalizando servicio updateMovements: {}", movimiento);

            return response.getId();
        } catch (Exception ex) {
            LOGGER.error("Error al actualizar movimiento: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido actualizar movimiento");
        }
    }

    @Override
    public String removeMovements(Integer id) throws NeorisException {

        LOGGER.info("Iniciando servicio removeMovements: {}", id);

        try {

            if (id == null) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "El campo id no debe ser nulo");
            }

            Optional<Movimiento> movementsRepositoryById = movementsRepository.findById(id);

            if (movementsRepositoryById.isEmpty()) {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "No se ha encontrado el id especificado");
            }

            clientRepository.deleteById(id);

            LOGGER.info("Finalizando servicio removeMovements: {}", id);

            return "Se ha eliminado el id: " + id + ", exitosamente";
        } catch (Exception ex) {
            LOGGER.error("Error al eliminar movimiento id: {} ", id, ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido eliminar movimiento");
        }
    }

    @Override
    public ReportListDTO reports(LocalDate fecha) throws NeorisException {

        LOGGER.info("Iniciando servicio reports: {}", fecha);

        try {

            List<Movimiento> getAllReports = movementsRepository.findAllByFecha(fecha);

            ReportListDTO reportListDTO = new ReportListDTO();
            reportListDTO.setReportes(getAllReports
                    .stream()
                    .map(report -> reportMapper.getReportDTO(report))
                    .collect(Collectors.toList()));

            return reportListDTO;
        } catch (Exception ex) {
            LOGGER.error("Error al obtener reportes: " + ex);
            throw new NeorisException(HttpStatus.INTERNAL_SERVER_ERROR, "No se ha podido obtener los reportes");
        }
    }

    private Movimiento getMovements(Movimiento movimiento) throws NeorisException {
        List<Movimiento> allByIdCuenta = movementsRepository.findAllByIdCuenta(movimiento.getCuenta().getId());

        Movimiento response = null;
        if (allByIdCuenta.size() == 0) {
            Optional<Cuenta> byId = accountRepository.findById(movimiento.getCuenta().getId());

            if (byId.isPresent()) {

                if (byId.get().getSaldoInicial() >= 0) {
                    long saldo = byId.get().getSaldoInicial() + movimiento.getValor();

                    if (saldo > 0) {
                        movimiento.setSaldo(saldo);
                        response = getMovimiento(movimiento, saldo);
                    } else {
                        throw new NeorisException(HttpStatus.BAD_REQUEST, "Saldo no disponible");
                    }
                } else {
                    throw new NeorisException(HttpStatus.BAD_REQUEST, "Saldo no disponible");
                }
            }
        } else {
            Optional<Movimiento> maxMovByAccount = allByIdCuenta.stream().max(Comparator.comparingInt(Movimiento::getId));

            if (maxMovByAccount.get().getSaldo() > 0) {
                long saldo = maxMovByAccount.get().getSaldo() + movimiento.getValor();
                response = getMovimiento(movimiento, saldo);
            } else {
                throw new NeorisException(HttpStatus.BAD_REQUEST, "Saldo no disponible");
            }

        }
        return response;
    }

    private Movimiento getMovimiento(Movimiento movimiento, long saldo) throws NeorisException {
        Movimiento response;
        if (saldo > 0) {
            movimiento.setSaldo(saldo);
            response = movementsRepository.save(movimiento);
        } else {
            throw new NeorisException(HttpStatus.BAD_REQUEST, "Saldo no disponible");
        }
        return response;
    }

}

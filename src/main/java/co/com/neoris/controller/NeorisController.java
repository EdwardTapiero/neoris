package co.com.neoris.controller;

import co.com.neoris.dto.ReportListDTO;
import co.com.neoris.entity.Cliente;
import co.com.neoris.entity.Cuenta;
import co.com.neoris.entity.Movimiento;
import co.com.neoris.exception.NeorisException;
import co.com.neoris.exception.handler.ErrorResponse;
import co.com.neoris.service.impl.NeorisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class NeorisController {

    private static final Logger log = LoggerFactory.getLogger(NeorisController.class);

    @Autowired
    private NeorisService neorisService;

    @PostMapping(value = "/cuentas", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "saveCuenta", notes = "Servicio que guarda una cuenta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> saveCuenta(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Cuenta cuenta) throws Exception {

        log.info("Iniciando controlador");

        int id = neorisService.saveAccount(cuenta);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);
    }

    @PutMapping(value = "/cuentas", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "updateCuenta", notes = "Servicio que actualiza una cuenta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> updateCuenta(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Cuenta cuenta) throws Exception {

        log.info("Iniciando controlador");

        int id = neorisService.updateAccount(cuenta);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);

    }

    @DeleteMapping(value = "/cuentas/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "removeCuenta", notes = "Servicio que elimina una cuenta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<String> removeCuenta(
            @ApiParam(value = "Id de la cuenta", required = true) @PathVariable("id") int id) throws Exception {

        log.info("Iniciando controlador");

        String response = neorisService.removeAccount(id);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(response);

    }

    @PostMapping(value = "/clientes", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "saveCliente", notes = "Servicio que guarda un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> saveCliente(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Cliente cliente) throws Exception {

        log.info("Iniciando controlador");

        int id = neorisService.saveClient(cliente);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);

    }

    @PutMapping(value = "/clientes", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "updateCliente", notes = "Servicio que actualiza un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> updateCliente(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Cliente cliente) throws Exception {

        log.info("Iniciando controlador");

        int id = neorisService.updateClient(cliente);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);

    }

    @DeleteMapping(value = "/clientes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "removeCliente", notes = "Servicio que elimina un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<String> removeCliente(
            @ApiParam(value = "Id del cliente", required = true) @PathVariable("id") Integer id) throws Exception {

        log.info("Iniciando controlador");

        String response = neorisService.removeClient(id);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(response);

    }

    @PostMapping(value = "/movimientos", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "saveMovimientos", notes = "Servicio que guarda un movimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> saveMovimientos(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Movimiento movimiento) throws NeorisException {

        log.info("Iniciando controlador");

        int id = neorisService.saveMovements(movimiento);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);

    }

    @PutMapping(value = "/movimientos", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "updateMovimientos", notes = "Servicio que actualiza un movimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<Integer> updateMovimientos(
            @ApiParam(value = "Body de la petición", required = true) @RequestBody Movimiento movimiento) throws Exception {

        log.info("Iniciando controlador");

        int id = neorisService.updateMovements(movimiento);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(id);

    }

    @DeleteMapping(value = "/movimientos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "removeMovimientos", notes = "Servicio que elimina un movimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<String> removeMovimientos(
            @ApiParam(value = "Id del movimiento", required = true) @PathVariable("id") Integer id) throws Exception {

        log.info("Iniciando controlador");

        String response = neorisService.removeMovements(id);

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(response);

    }

    @GetMapping(value = "/reportes", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "removeMovimientos", notes = "Servicio que obtiene reportes por fecha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa", response = Integer.class),
            @ApiResponse(code = 400, message = "Error en los parámetros de consulta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error desconocido", response = ErrorResponse.class)})
    public ResponseEntity<ReportListDTO> reports(
            @ApiParam(value = "Fecha a consultar", required = true) @RequestParam("fecha") String fecha) throws NeorisException {

        log.info("Iniciando controlador");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ReportListDTO response = neorisService.reports(LocalDate.parse(fecha, formatter));

        log.info("Finalizando controlador");

        return ResponseEntity.ok().body(response);
    }
}

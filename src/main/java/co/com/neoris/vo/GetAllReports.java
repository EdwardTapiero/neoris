package co.com.neoris.vo;

import co.com.neoris.entity.Cliente;
import co.com.neoris.entity.Cuenta;
import co.com.neoris.entity.Movimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllReports {

    private Cliente cliente;

    private Cuenta cuenta;

    private Movimiento movimiento;
}

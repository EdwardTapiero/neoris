package co.com.neoris.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuenta", schema = "neoris")
public class Cuenta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Integer id;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "numero_cuenta")
    private Long numeroCuenta;

    @Column(name = "saldo_inicial")
    private Long saldoInicial;

    @Column(name = "estado")
    private boolean estado;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}

package co.com.neoris.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private int edad;

    @Column(name = "identificacion")
    private long identificacion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private long telefono;
}

package pe.edu.upeu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    private String ruc;
    private String nombre;
    private String titulo;
    private String propietario;
    private String direccion;

    @Override
    public String toString(){
        return String.format("%-12s | %-20s | %-15s", ruc, nombre, titulo);
    }
}
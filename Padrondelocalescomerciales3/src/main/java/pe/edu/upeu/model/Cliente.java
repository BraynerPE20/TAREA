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
    private String id;          // RUC
    private String nombre;      // Razón Social
    private String telefono;    // Título / Giro
    private String email;       // Representante Legal

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%-11s | %-30s | %-15s", id, nombre, telefono);
    }
}
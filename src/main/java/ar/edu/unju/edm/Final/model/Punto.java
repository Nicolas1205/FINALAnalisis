package ar.edu.unju.edm.Final.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.model.Valoracion;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "puntos")
@Getter
@Setter
@NoArgsConstructor
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int puntoId;

    @NotNull(message = "debe especificar un nombre")
    @Size(min = 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String nombre;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "turista_id")//, nullable=false)
    private Turista turista;

    @OneToMany(mappedBy = "punto", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "punto", cascade = CascadeType.REMOVE)
    private List<Valoracion> valoraciones;

    public Punto(@NotNull String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "puntoId=" + puntoId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';
    }
}

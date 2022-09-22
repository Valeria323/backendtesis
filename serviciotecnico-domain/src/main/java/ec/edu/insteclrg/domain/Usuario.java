package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuarios")

public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nombre;
  @Column(nullable = false)
  private String apellido;
  @Column(nullable = false)
  private String userName;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String direccion;
  @Column(nullable = false)
  private String telefono;
  @Column(nullable = false)
  private String rol;
  @Column(nullable = false)
  private String password;

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", userName=" + userName + ", email="
        + email + ", direccion=" + direccion + ", telefono=" + telefono + ", rol="
        + rol + ", password=" + password + "]";
  }

}

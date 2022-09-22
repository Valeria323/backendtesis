package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, nullable = false)
  private long id;

  @Column(nullable = false)
  private String nombres;

  @Column(nullable = false)
  private String apellidos;

  @Column(nullable = false, unique = true)
  private Long dni;

  @Column(nullable = false)
  private String direccion;

  @Column(nullable = false)
  private Long telefono;

  @Column(nullable = false)
  private Long celular;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private boolean is_active;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Long getDni() {
    return dni;
  }

  public void setDni(Long dni) {
    this.dni = dni;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Long getTelefono() {
    return telefono;
  }

  public void setTelefono(Long telefono) {
    this.telefono = telefono;
  }

  public Long getCelular() {
    return celular;
  }

  public void setCelular(Long celular) {
    this.celular = celular;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  @Override
  public String toString() {
    return "Cliente [apellidos=" + apellidos + ", celular=" + celular + ", direccion=" + direccion + ", dni=" + dni
        + ", email=" + email + ", id=" + id + ", is_active=" + is_active + ", nombres=" + nombres + ", telefono="
        + telefono + "]";
  }

}

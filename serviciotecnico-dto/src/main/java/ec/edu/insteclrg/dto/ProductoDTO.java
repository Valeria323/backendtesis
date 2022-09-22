package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ProductoDTO {

  private long id;

  private String codigo;

  private String nombre;

  private double precioventa;

  private long stockMin;

  private long stockMax;

  private long stock;

  private long controlaStock;

  private double aplicaIva;

  private EmpresaDTO empresa;

  private String imagen;

}

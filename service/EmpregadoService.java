package service;

import empregado.Empregado;
import java.util.List;

public class EmpregadoService {

  public Empregado getEmpregadoPorId(List<Empregado> empregados, String empregadoId) {
    return empregados.stream().filter(empregado -> empregado.getId().equals(empregadoId)).findFirst().get();
  }
}

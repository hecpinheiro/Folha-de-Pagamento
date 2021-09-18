package service;

import empregado.Empregado;


import database.Database;

public class EmpregadoService {
  private Database database = Database.obterInstancia();

  public Empregado getEmpregadoPorId(String empregadoId) {
    return this.database.obterEmpregados().stream().filter(empregado -> empregado.getId().equals(empregadoId)).findFirst().get();
  }
}

package Contribuidor;

public interface ContribuidorInterface {
    Contribuidor incluir(String idUsuario);
    String buscar(String idUsuario);
    String excluir(Contribuidor usuario);
    String validar(Contribuidor usuario);
    String alterar(Contribuidor usuario);
}

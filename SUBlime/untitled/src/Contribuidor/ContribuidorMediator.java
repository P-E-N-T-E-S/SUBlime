package Contribuidor;

import java.util.HashMap;
import java.util.Map;

public class ContribuidorMediator implements ContribuidorInterface {
    private Map<String, Contribuidor> contribuidores = new HashMap<>();

    @Override
    public Contribuidor incluir(String idUsuario) {
        if (contribuidores.containsKey(idUsuario)) {
            return contribuidores.get(idUsuario);
        } else {
            Contribuidor novoContribuidor = new Contribuidor(this);
            novoContribuidor.setIdUsuario(Double.parseDouble(idUsuario));
            contribuidores.put(idUsuario, novoContribuidor);
            return novoContribuidor;
        }
    }

    @Override
    public String buscar(String idUsuario) {
        Contribuidor contribuidor = contribuidores.get(idUsuario);
        return contribuidor != null ? contribuidor.toString() : "Usuário não encontrado.";
    }

    @Override
    public String excluir(Contribuidor usuario) {
        if (contribuidores.containsKey(String.valueOf(usuario.getIdUsuario()))) {
            contribuidores.remove(String.valueOf(usuario.getIdUsuario()));
            return "Usuário excluído com sucesso.";
        } else {
            return "Usuário não encontrado.";
        }
    }

    @Override
    public String validar(Contribuidor usuario) {
        if (usuario.getEmail() != null && usuario.getSenha() != null) {
            return "Usuário válido.";
        } else {
            return "Usuário inválido.";
        }
    }

    @Override
    public String alterar(Contribuidor usuario) {
        String idUsuario = String.valueOf(usuario.getIdUsuario());
        if (contribuidores.containsKey(idUsuario)) {
            contribuidores.put(idUsuario, usuario);
            return "Usuário alterado com sucesso.";
        } else {
            return "Usuário não encontrado.";
        }
    }
}

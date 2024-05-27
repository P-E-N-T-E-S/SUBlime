package Contribuidor;

import java.util.HashMap;
import java.util.Map;

public class ModeradorMediator implements ContribuidorInterface {
    private Map<String, Moderador> moderadores = new HashMap<>();

    @Override
    public Moderador incluir(String idUsuario) {
        if (moderadores.containsKey(idUsuario)) {
            return moderadores.get(idUsuario);
        } else {
            Moderador novoModerador = new Moderador(this, Double.parseDouble(idUsuario), "", "", "", true);
            moderadores.put(idUsuario, novoModerador);
            return novoModerador;
        }
    }

    @Override
    public String buscar(String idUsuario) {
        Moderador moderador = moderadores.get(idUsuario);
        return moderador != null ? moderador.toString() : "Moderador não encontrado.";
    }

    @Override
    public String excluir(Contribuidor usuario) {
        if (usuario instanceof Moderador) {
            Moderador moderador = (Moderador) usuario;
            if (moderadores.containsKey(String.valueOf(moderador.getIdUsuario()))) {
                moderadores.remove(String.valueOf(moderador.getIdUsuario()));
                return "Moderador excluído com sucesso.";
            } else {
                return "Moderador não encontrado.";
            }
        } else {
            return "Usuário não é um moderador.";
        }
    }

    @Override
    public String validar(Contribuidor usuario) {
        if (usuario instanceof Moderador) {
            Moderador moderador = (Moderador) usuario;
            if (moderador.getEmail() != null && moderador.getSenha() != null) {
                return "Moderador válido.";
            } else {
                return "Moderador inválido.";
            }
        } else {
            return "Usuário não é um moderador.";
        }
    }

    @Override
    public String alterar(Contribuidor usuario) {
        if (usuario instanceof Moderador) {
            Moderador moderador = (Moderador) usuario;
            String idUsuario = String.valueOf(moderador.getIdUsuario());
            if (moderadores.containsKey(idUsuario)) {
                moderadores.put(idUsuario, moderador);
                return "Moderador alterado com sucesso.";
            } else {
                return "Moderador não encontrado.";
            }
        } else {
            return "Usuário não é um moderador.";
        }
    }
}
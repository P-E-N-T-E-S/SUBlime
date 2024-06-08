package Contribuidor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeradorMediator implements ContribuidorInterface {
    private final Map<String, Moderador> moderadores = new HashMap<>();

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
        if (usuario instanceof Moderador moderador) {
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
        if (usuario instanceof Moderador moderador) {
            if (moderador.getEmail() == null || moderador.getSenha() == null) {
                return "Moderador inválido: e-mail ou senha ausente.";
            }

            String email = moderador.getEmail();
            String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                return "Moderador inválido: e-mail inválido.";
            }

            return "Moderador válido.";
        } else {
            return "Usuário não é um moderador.";
        }
    }

    @Override
    public String alterar(Contribuidor usuario) {
        if (usuario instanceof Moderador moderador) {
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
package br.com.code.spring.sublime.contribuidor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RevisorMediator implements ContribuidorInterface {
    private final Map<String, Revisor> moderadores = new HashMap<>();

    @Override
    public Revisor incluir(String idUsuario) {
        if (moderadores.containsKey(idUsuario)) {
            return moderadores.get(idUsuario);
        } else {
            Revisor novoRevisor = new Revisor(this, Double.parseDouble(idUsuario), "", "", "", true);
            moderadores.put(idUsuario, novoRevisor);
            return novoRevisor;
        }
    }

    @Override
    public String buscar(String idUsuario) {
        Revisor revisor = moderadores.get(idUsuario);
        return revisor != null ? revisor.toString() : "Moderador não encontrado.";
    }

    @Override
    public String excluir(Contribuidor usuario) {
        if (usuario instanceof Revisor revisor) {
            if (moderadores.containsKey(String.valueOf(revisor.getIdUsuario()))) {
                moderadores.remove(String.valueOf(revisor.getIdUsuario()));
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
        if (usuario instanceof Revisor revisor) {
            if (revisor.getEmail() == null || revisor.getSenha() == null) {
                return "Moderador inválido: e-mail ou senha ausente.";
            }

            String email = revisor.getEmail();
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
        if (usuario instanceof Revisor revisor) {
            String idUsuario = String.valueOf(revisor.getIdUsuario());
            if (moderadores.containsKey(idUsuario)) {
                moderadores.put(idUsuario, revisor);
                return "Moderador alterado com sucesso.";
            } else {
                return "Moderador não encontrado.";
            }
        } else {
            return "Usuário não é um moderador.";
        }
    }
}
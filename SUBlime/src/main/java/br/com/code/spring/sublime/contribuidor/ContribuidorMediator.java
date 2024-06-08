package br.com.code.spring.sublime.contribuidor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (usuario.getEmail() == null || usuario.getSenha() == null) {
            return "Usuário inválido: e-mail ou senha ausente.";
        }

        String email = usuario.getEmail();
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            return "Usuário inválido: e-mail inválido.";
        }

        return "Usuário válido.";
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

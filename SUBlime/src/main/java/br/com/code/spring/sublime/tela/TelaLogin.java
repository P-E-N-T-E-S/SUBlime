package br.com.code.spring.sublime.tela;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TelaLogin {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String senha, Model model) {
        boolean loginValido = "pentes@gmail.com".equals(email) && "pentes".equals(senha);

        if (loginValido) {
            model.addAttribute("mensagem", "Login realizado com sucesso!");
            return "redirect:/";
        } else {
            model.addAttribute("mensagem", "Email ou senha incorretos. Tente novamente.");
            return "login";
        }
    }
}

package br.com.code.spring.sublime.tela;

import br.com.code.spring.sublime.obra.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TelaCatalogo {
    private List<Filme> obras;

    public TelaCatalogo() {
        this.obras = new ArrayList<>();
        obras.add(new Filme(1, "Howls Moving Castle", "130min", "Diretor XYZ", 2018,
                "Tipo de Filme", 5.0, 1, null, "/caminho/link"));
    }

    @GetMapping("/")
    public String mostrarIndex() {
        return "index";
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("obras", obras);
        return "catalogo";
    }

    @GetMapping("/legenda")
    public String legendar(@RequestParam("id") int id, Model model) {
        Filme filme = encontrarFilmePorId(id);
        if (filme != null) {
            model.addAttribute("filme", filme);
            return "legenda";
        } else {
            return "redirect:/catalogo";
        }
    }

    private Filme encontrarFilmePorId(int id) {
        for (Filme filme : obras) {
            if (filme.getIdObra() == id) {
                return filme;
            }
        }
        return null;
    }
}

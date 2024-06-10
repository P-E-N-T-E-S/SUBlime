package br.com.code.spring.sublime.tela;

import br.com.code.spring.sublime.obra.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TelaCatalogo {
    private List<Filme> obras;

    public TelaCatalogo() {
        this.obras = new ArrayList<>();
        obras.add(new Filme(1, "Howls Moving Castle", "130min", "Diretor XYZ", 2018,
                "Tipo de Filme", 5.0, 1, null, "/images/howls.jpg"));

        obras.add(new Filme(2, "Spirited Away", "125min", "Diretor ABC", 2001,
                "Tipo de Filme", 4.8, 2, null, "/images/spirited.png"));

        obras.add(new Filme(3, "Princess Mononoke", "134min", "Diretor DEF", 1997,
                "Tipo de Filme", 4.9, 3, null, "/images/monoke.png"));

        obras.add(new Filme(4, "My Neighbor Totoro", "86min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 4, null, "/images/totoro.png"));

        obras.add(new Filme(5, "Nausicaä of the valley of the wind", "117min", "Diretor GHI", 1984,
                "Tipo de Filme", 4.0, 5, null, "/images/nausica.png"));

        obras.add(new Filme(6, "Panda go Panda!", "79min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 6, null, "/images/panda.png"));

        obras.add(new Filme(7, "Whisper of the Heart", "96min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 7, null, "/images/Sussurros.png"));

        obras.add(new Filme(8, "The boy and the Heron", "124min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 8, null, "/images/boy.png"));

        obras.add(new Filme(9, "Castle in the sky", "124min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 9, null, "/images/castelodoceu.png"));

        obras.add(new Filme(10, "From up on Poppy hill", "91min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 10, null, "/images/colina.png"));

        obras.add(new Filme(11, "The Wind Rises", "126min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 11, null, "/images/vento.png"));

        obras.add(new Filme(12, "Kiki's Delivery Service", "102min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 12, null, "/images/kiki.png"));

        obras.add(new Filme(13, "Ponyo", "103min", "Diretor GHI", 1988,
                "Tipo de Filme", 4.7, 13, null, "/images/ponyo.png"));       
    }

    public List<Filme> getObras() {
        return obras;
    }

    @GetMapping("/")
    public String mostrarIndex(Model model) {
        model.addAttribute("obras", obras);
        return "index";
    }

    @GetMapping("/legenda/{id}")
    public String legendar(@PathVariable("id") int id, Model model) {
        Filme filme = encontrarFilmePorId(id);
        if (filme != null) {
            model.addAttribute("filme", filme);
            return "subtitle";
        } else {
            return "redirect:/";
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

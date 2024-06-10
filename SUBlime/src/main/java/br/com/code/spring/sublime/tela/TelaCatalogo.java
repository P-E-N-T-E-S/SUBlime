package br.com.code.spring.sublime.tela;

import br.com.code.spring.sublime.obra.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TelaCatalogo {
    private List<Filme> obras;

    public TelaCatalogo() {
        this.obras = new ArrayList<>();
        // Adicionando os Filmes assim enquanto não temos um banco de dados
        obras.add(new Filme(1, "Howls Moving Castle", "130min", "Hayao Miyazaki", 2018,
                "Tipo de Filme", 5.0, 1, null, "/images/howls.jpg"));

        obras.add(new Filme(2, "Spirited Away", "125min", "Hayao Miyazaki", 2001,
                "Tipo de Filme", 4.8, 2, null, "/images/spirited.png"));

        obras.add(new Filme(3, "Princess Mononoke", "134min", "Hayao Miyazaki", 1997,
                "Tipo de Filme", 4.9, 3, null, "/images/monoke.png"));

        obras.add(new Filme(4, "My Neighbor Totoro", "86min", "Hayao Miyazaki", 1988,
                "Tipo de Filme", 4.7, 4, null, "/images/totoro.png"));

        obras.add(new Filme(5, "Nausicaä of the valley of the wind", "117min", "Hayao Miyazaki", 1984,
                "Tipo de Filme", 4.4, 5, null, "/images/nausica.png"));

        obras.add(new Filme(6, "Panda go Panda!", "79min", "Hayao Miyazaki", 1972,
                "Tipo de Filme", 4.8, 6, null, "/images/panda.png"));

        obras.add(new Filme(7, "Whisper of the Heart", "96min", "Hayao Miyazaki", 1995,
                "Tipo de Filme", 4.3, 7, null, "/images/Sussurros.png"));

        obras.add(new Filme(8, "The boy and the Heron", "124min", "Hayao Miyazaki", 1988,
                "Tipo de Filme", 4.0, 8, null, "/images/boy.png"));

        obras.add(new Filme(9, "Castle in the sky", "124min", "Isao Takahata", 1986,
                "Tipo de Filme", 4.2, 9, null, "/images/castelodoceu.png"));

        obras.add(new Filme(10, "From up on Poppy hill", "91min", "Hayao Miyazaki", 2011,
                "Tipo de Filme", 4.7, 10, null, "/images/colina.png"));

        obras.add(new Filme(11, "The Wind Rises", "126min", "Hayao Miyazaki", 2013,
                "Tipo de Filme", 4.9, 11, null, "/images/vento.png"));

        obras.add(new Filme(12, "Kiki's Delivery Service", "102min", "Hayao Miyazaki", 1989,
                "Tipo de Filme", 4.2, 12, null, "/images/kiki.png"));

        obras.add(new Filme(13, "Ponyo", "103min", "Gorō Miyazaki", 2008,
                "Tipo de Filme", 4.1, 13, null, "/images/ponyo.png"));

        obras.add(new Filme(14, "The tale of princess kaguya", "137min", "Isao Takahata", 2013,
                "Tipo de Filme", 4.7, 14, null, "/images/Kaguya.png"));

        obras.add(new Filme(15, "Castle of Cagliostro", "110min", "Hayao Miyazaki", 1979,
                "Tipo de Filme", 5.0, 15, null, "/images/LupinIII.png"));

        obras.add(new Filme(16, "When Marnie Was There", "103min", "Hayao Miyazaki", 2014,
                "Tipo de Filme", 4.0, 15, null, "/images/marnie.png"));

        obras.add(new Filme(17, "The Kingdom of Dreams and Madness", "120min", "Hayao Miyazaki", 2013,
                "Tipo de Filme", 4.5, 15, null, "/images/reino.png"));

        obras.add(new Filme(18, "Tales from Earthsea", "115min", "Hayao Miyazaki", 2006,
                "Tipo de Filme", 4.2, 15, null, "/images/terramar.png"));
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

    @GetMapping("/search")
    public String pesquisar(@RequestParam("query") String query, Model model) {
        List<Filme> resultados = obras.stream()
                .filter(filme -> filme.getTitulo().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        model.addAttribute("obras", resultados);
        return "index";
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

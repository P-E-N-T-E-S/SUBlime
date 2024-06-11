package br.com.code.spring.sublime.tela;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class TelaLegenda {

    private static int contadorLegenda = 1;

    @GetMapping("/legenda")
    public String legenda() {
        return "subtitle";
    }

    @PostMapping("legenda")
    public String saveLegenda(@RequestParam("legenda") String legenda, Model model) {
        try {
            String fileName = "legenda_" + contadorLegenda + ".txt";
            saveLegendaToFile(legenda, "textos/" + fileName);
            model.addAttribute("mensagem", "Legenda salva com sucesso!");
            contadorLegenda++;
        } catch (IOException e) {
            model.addAttribute("mensagem", "Erro ao salvar a legenda.");
            e.printStackTrace();
        }
        return "subtitle";
    }

    private void saveLegendaToFile(String legenda, String fileName) throws IOException {
        String filePath = Paths.get(System.getProperty("user.dir"), fileName).toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(legenda);
        }
    }
}

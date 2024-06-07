package Legenda;

import utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class LegendaMediator {
    private Map<Long, Legenda> legendasCache = new HashMap<>();
    private LegendaDAO legendaDAO;

    public LegendaMediator(LegendaDAO legendaDAO) {
        this.legendaDAO = legendaDAO;
    }

    public String save(Legenda legenda) {
        if (StringUtils.isVazioOuNulo(legenda.getTexto())) {
            return "O texto da legenda está vazio!";
        }

        legendaDAO.save(legenda);
        legendasCache.put(legenda.getId(), legenda);
        return "Legenda salva com sucesso!";
    }

    public Legenda findById(long id) {
        if (legendasCache.containsKey(id)) {
            return legendasCache.get(id);
        } else {
            Legenda legenda = legendaDAO.findById(id);
            if (legenda != null) {
                legendasCache.put(id, legenda);
            }
            return legenda;
        }
    }

    public void update(Legenda legenda) {
        legendaDAO.update(legenda);
        legendasCache.put(legenda.getId(), legenda);
    }

    public void delete(long id) {
        legendaDAO.delete(id);
        legendasCache.remove(id);
    }
}
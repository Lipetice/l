package br.edu.fiec.passe_gamer.service;

import br.edu.fiec.passe_gamer.model.dto.DevDTO;
import br.edu.fiec.passe_gamer.model.entity.Dev;
import br.edu.fiec.passe_gamer.repository.DevRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DevService {

    private DevRepository devRepository;

    public void criarDevs(DevDTO devDTO) {
        devRepository.save(new Dev("Desenvolvedor", devDTO));
    }

    public void deletarDev(Integer id) {
        DevRepository.deletarDev(id);
    }

    public void darUpdate(Integer id, DevDTO devDTO) {
        Dev dev = DevRepository.findById(id).orElse(null);

        if (dev != null) {
            dev.setDesenvolvedores(devDTO.getDesenvolvedores());
            dev.setGenero(devDTO.getGenero());
            dev.setJogos(devDTO.getJogos());

            DevRepository.save(dev);
        }
    }

    public List<Dev> procurarDevs() {
        return DevRepository.findAll();
    }

    public Dev procurarPorID(Integer id) {
        return DevRepository.findById(id).orElse(null);
    }

    public List<Dev> procurarPorNome(String nome) {
        return DevRepository.findAllByNome(nome);
    }
}

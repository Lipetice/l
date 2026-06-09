package br.edu.fiec.passe_gamer.controller;

import br.edu.fiec.passe_gamer.model.dto.DevDTO;
import br.edu.fiec.passe_gamer.model.entity.Dev;
import br.edu.fiec.passe_gamer.service.DevService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Desenvolvedores")
public class DevController {

    private DevService devService;

    //Criação de devs
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "Desenvolvedores", consumes = APPLICATION_JSON_VALUE)
    public void criarDevs(@RequestBody DevDTO devDTO) {
        DevService.criarDevs(devDTO);
    }

    //Deletar devs
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    public void deletarDev(@RequestParam Integer id) {
        DevService.deletarDev(id);
    }

    //Dar update nos devs
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void darUpdate(@RequestParam Integer id, @RequestBody DevDTO devDTO) {
        DevService.darUpdate(id, devDTO);
    }

    //Procurar todos
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Dev> procurarDevs() {
        return DevService.procurarDevs();
    }

    //Procurar por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Dev procurarPorID(@RequestParam Integer id) {
        return DevService.procurarPorID(id);
    }

    //Procurar pelo nome
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "nome", produces = APPLICATION_JSON_VALUE)
    public List<Dev> procurarPorNome(@RequestParam String nome) {
        return DevService.procurarPorNome(nome);
    }
}

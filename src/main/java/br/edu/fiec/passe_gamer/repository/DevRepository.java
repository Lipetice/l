package br.edu.fiec.passe_gamer.repository;

import br.edu.fiec.passe_gamer.model.entity.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevRepository extends JpaRepository<Dev, Integer> {

    List<Dev> findAllByTipo(String tipo);

    List<Dev> findAllByNome(String nome);
}
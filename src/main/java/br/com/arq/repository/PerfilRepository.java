package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arq.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}

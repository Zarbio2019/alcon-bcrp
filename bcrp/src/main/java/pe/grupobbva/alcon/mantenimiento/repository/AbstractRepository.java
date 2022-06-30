package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, String> {

}

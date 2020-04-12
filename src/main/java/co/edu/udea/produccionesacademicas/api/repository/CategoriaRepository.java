package co.edu.udea.produccionesacademicas.api.repository;

import co.edu.udea.produccionesacademicas.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    public Categoria findByMateria(String Materia);
}

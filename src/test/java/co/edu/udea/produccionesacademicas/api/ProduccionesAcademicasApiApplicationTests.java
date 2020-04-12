package co.edu.udea.produccionesacademicas.api;

import co.edu.udea.produccionesacademicas.api.controller.CategoriaController;
import co.edu.udea.produccionesacademicas.api.model.Categoria;

import co.edu.udea.produccionesacademicas.api.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest()
class ProduccionesAcademicasApiApplicationTests {

    @Test
    public void testGetProduccionesListSuccess() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/producciones/";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(true, result.getBody().contains("produccionID"));
    }

    @Test
    public void testGetProduccionIdSuccess() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/producciones/consultar/6";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //System.out.print(result.getTitulo());

        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(true, result.getBody().contains("\"produccionID\":6"));
    }

    @Test
    public void testWhenFindByID_thenReturnEmployeeProduccion() throws URISyntaxException
    {
        Categoria categoria1 = new Categoria("Computacion","Elementos Finitos");

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/categorias/m/" + categoria1.getMateria();
        URI uri = new URI(baseUrl);

        ResponseEntity<Categoria> found = restTemplate.getForEntity(uri, Categoria.class);

        assertThat(found.getBody().getMateria())
                .isEqualTo(categoria1.getMateria());
    }

}

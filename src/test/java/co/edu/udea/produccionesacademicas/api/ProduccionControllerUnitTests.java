package co.edu.udea.produccionesacademicas.api;

import co.edu.udea.produccionesacademicas.api.controller.ProduccionController;
import co.edu.udea.produccionesacademicas.api.model.Produccion;
import co.edu.udea.produccionesacademicas.api.service.impl.ProduccionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// test integracion
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProduccionController.class)
@ActiveProfiles("test")
public class ProduccionControllerUnitTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ProduccionService produccionService;

    @Test
    public void obtener_Producciones_returnsOkWithListOfProducciones() throws Exception {

        List<Produccion> producciones = new ArrayList<>();
        Produccion produccion1 = new Produccion(99, "Titulo Prueba", "Resumen Prueba", new Date());
        Produccion produccion2 = new Produccion(98, "Titulo Prueba2", "Resumen Prueba2", new Date());
        producciones.add(produccion1);
        producciones.add(produccion2);

        Mockito.when(produccionService.getProducciones()).thenReturn(producciones);

        mockMvc.perform(MockMvcRequestBuilders.get("/producciones").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].produccionID", is(99)))
                .andExpect(jsonPath("$[0].titulo", is("Titulo Prueba")))
                .andExpect(jsonPath("$[1].produccionID", is(98)))
                .andExpect(jsonPath("$[1].titulo", is("Titulo Prueba2")));
    }

    @Test
    public void crearNuevaProduccion_andReturnsObjWith201() throws Exception {
        Produccion produccion = new Produccion(70, "Titulo Prueba", "Resumen Prueba", new Date());

        Mockito.when(produccionService.addProduccion(Mockito.any(Produccion.class))).thenReturn(produccion);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/producciones/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(produccion));

        mockMvc.perform(builder).andExpect(status().isCreated()).andExpect(jsonPath("$.produccionID", is(70)))
                .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(produccion)));
    }

    @Test
    public void post_submitsInvalidProduccion_WithEmptyTitulo_Returns400() throws Exception {
        Produccion produccion = new Produccion(58, "", "Resumen Prueba", new Date());

        String produccionJsonString = this.mapper.writeValueAsString(produccion);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/producciones/add")
                .contentType(MediaType.APPLICATION_JSON).content(produccionJsonString)).andExpect(status().isBadRequest());

        assertEquals(MethodArgumentNotValidException.class,
                resultActions.andReturn().getResolvedException().getClass());
        assertTrue(resultActions.andReturn().getResolvedException().getMessage().contains("'make' field was empty"));
    }


    @Test
    public void delete_deleteProduccion_Returns204Status() throws Exception {
        Integer produccionID = 48;

        ProduccionService serviceSpy = Mockito.spy(produccionService);
        Mockito.doNothing().when(serviceSpy).deleteProduccion(produccionID);

        mockMvc.perform(MockMvcRequestBuilders.delete("/producciones/delete/48")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

        verify(produccionService, times(1)).deleteProduccion(produccionID);
        //assertEquals("5","3");
    }

/*
    @Test
    public void put_updatesAndReturnsUpdatedObjWith202() throws Exception {
        Produccion produccion = new Produccion(89,"Titulo prueba","Resumen Prueba",new Date());

        Mockito.when(produccionService.updateProduccion(89, produccion)).thenReturn(produccion);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/producciones/update/89", produccion)
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(produccion));

        mockMvc.perform(builder).andExpect(status().isAccepted()).andExpect(jsonPath("$.produccionID", is(89)))
                .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(produccion)));
    }

 */

}

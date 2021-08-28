package mx.uami.backendmongodb.Controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.uami.backendmongodb.DAO.SerieDAO;
import mx.uami.backendmongodb.Entidad.Serie;
import mx.uami.backendmongodb.Repositories.SerieRepository;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieDAO serieDAO;

    /*Metodo para agregar series a la BD*/
    @PostMapping("/series")
    public void agregarSerie(@RequestBody final List<Serie> serie){
        serieDAO.saveAll(serie);
    } 

    /*Metodo para consultar todas las series de la BD*/
    @GetMapping("/series")
    public List<Serie> mostrarProductos(){
        return serieDAO.findAll();
    }

    /*Metodo para consultar una serie por ID en la BD*/
    @GetMapping("/series/{serie_Id}")
    public Serie findSerie(@PathVariable final String serie_Id){
        return serieDAO.findById(serie_Id);
    }

    /*Metodo para actualizar un registro en la BD basado en su ID y parcialmente*/
    @PatchMapping("/series/{serie_Id}")
    public void UpdateSerie(@PathVariable final String serie_Id,
    @RequestBody final Serie serie) throws Exception {
        for(final Field campo : Serie.class.getDeclaredFields()){
            final String fieldname = campo.getName();

            if(fieldname.equals("id")){
                continue;
            }

            final java.lang.reflect.Method getter = Serie.class.getDeclaredMethod("get"+StringUtils.capitalize(fieldname));
            final Object valorCampo = getter.invoke(serie);

            if(Objects.nonNull(valorCampo)){
                serieRepository.UpdateSerie(serie_Id, fieldname,valorCampo);
            }
        }
    }

    
}

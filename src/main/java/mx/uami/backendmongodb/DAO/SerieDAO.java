package mx.uami.backendmongodb.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import mx.uami.backendmongodb.Entidad.Serie;

@Repository
public class SerieDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveAll(List<Serie> serie) {
        mongoTemplate.insertAll(serie);
    }

    public List<Serie> findAll() {
        return mongoTemplate.findAll(Serie.class);
    }

    public Serie findById(String serie_Id) {
        return mongoTemplate.findById(serie_Id, Serie.class);
    }
    
}

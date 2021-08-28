package mx.uami.backendmongodb.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import mx.uami.backendmongodb.Entidad.Serie;

public interface SerieRepository extends MongoRepository<Serie, String>, CustomSerieRepository{

}

package mx.uami.backendmongodb.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import mx.uami.backendmongodb.Entidad.Serie;

public class CustomSerieRepositoryImpl implements CustomSerieRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void UpdateSerie(String serie_Id, String fieldname, Object fieldValue) {
        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(serie_Id)), BasicUpdate.update(fieldname, fieldValue), FindAndModifyOptions.none(),Serie.class);
    }

    
}

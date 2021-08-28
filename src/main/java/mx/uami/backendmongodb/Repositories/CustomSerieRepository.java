package mx.uami.backendmongodb.Repositories;

public interface CustomSerieRepository {
    public void UpdateSerie(String serie_Id, String fieldname, Object valorCampo);
}
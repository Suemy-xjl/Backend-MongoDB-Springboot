package mx.uami.backendmongodb.Entidad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Serie")
public class Serie {

    @Id
    private String id;

    private String Titulo;
    private String Descripción;
    private String Capitulos;
    private String Temporadas;
    private String Categoría;
    private String Fecha_estreno;

    public String getTitulo(){
        return Titulo;
    }

    public void setTitulo(String Titulo){
        this.Titulo = Titulo;
    }

    public String getDescripcion(){
        return Descripción;
    }

    public void setDescripcion(String Descripción){
        this.Descripción = Descripción;
    }

    public String getCapitulos(){
        return Capitulos;
    }

    public void setCapitulos(String Capitulos){
        this.Capitulos = Capitulos;
    }

    public String getTemporadas(){
        return Temporadas;
    }

    public void setTemporadas(){
        this.Temporadas = Temporadas;
    }

    public String getCategoria(){
        return Categoría;
    }

    public void setCategoria(String Categoría){
        this.Categoría = Categoría;
    }

    public String getFecha(){
        return Fecha_estreno;
    }

    public void setFecha(String Fecha_estreno){
        this.Fecha_estreno = Fecha_estreno;
    }
    
}

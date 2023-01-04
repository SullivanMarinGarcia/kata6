package kata6v2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.*;
import javax.xml.bind.JAXBException;


import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;

public class Kata6v2 {

    public static void main(String[] args)throws Exception {
        
        
        URL api = new URL("https://jsonplaceholder.typicode.com/albums");
        HttpURLConnection cx = (HttpURLConnection) api.openConnection();
        cx.setRequestMethod("GET");
        
        InputStream strm = cx.getInputStream();
        byte[] arrStream = strm.readAllBytes();
        
        String json = "";
        
        for(byte tmp:arrStream){
            json += (char)tmp;
        }
        
        JSONArray jsonArray = new JSONArray(json);
        ArrayList<Album> albums = new ArrayList<Album>();
        
        for(Object obj: jsonArray){
            albums.add(new Album((Integer)
            ((JSONObject)obj).get("userId"), (Integer)
            ((JSONObject)obj).get("id"),
            ((JSONObject)obj).get("title").toString()));
        }
        
        
        /*Para comprobar que funciona
        
        for (Album album: albums){
            System.out.println(album);
        }
        
        */
        
        deserialize();
        //serializeXml();
        
        
        
        
        
        
    }
    
    public static void deserialize(){
        Gson gson = new Gson();
        String newObject = "{'userId': 11, 'id': 101, 'title': 'Titulo de prueba'}";
        Album album = gson.fromJson(newObject, Album.class);
        
        
        /*Para comprobar que funciona
        System.out.println("Objeto Serializado: " + album);
        */
         
    }
    
    /*
    
    public static void serializeXml() throws JAXBException{
        Album albumXml = new Album(12, 102, "Album XML");
        JAXBContext context = JAXBContext.newInstance(Album.class);
        Marshaller marshaller = context.createMarshaller();
        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        marshaller.marshal(albumXml, new File("prueba.xml"));
        //marshaller.marshal(albumXml, System.out);
        
        
    }

*/

    
    
}

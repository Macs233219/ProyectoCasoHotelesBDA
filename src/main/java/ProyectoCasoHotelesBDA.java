
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author grupo
 */
public class ProyectoCasoHotelesBDA {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("tienda");
        System.out.println(database);
    }
}

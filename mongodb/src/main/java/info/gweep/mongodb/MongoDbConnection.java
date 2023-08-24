package info.gweep.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MongoDbConnection {

    private static final String CLUSTER = "mongodb+srv://antonlys96:Lys_1996@cluster0.mjotutp.mongodb.net/";
    private static final String CLIENT = "mongodb://127.0.0.1:27017/";

    public static void main(String[] args) {

        try(MongoClient mongoClient = MongoClients.create(CLIENT)){
            MongoDatabase db = mongoClient.getDatabase("entry");
            //db.createCollection("description");
            MongoCollection<Document> collection = db.getCollection("description");
//            Map<String, String> fields = new HashMap<>();
//            fields.put("name", "Anatoliy");
//            fields.put("surname", "Vasarman");
//            fields.put("age", "65");
//            Document fields1 = new Document("title", "ball")
//                    .append("color", new Document("red", "33").append("green", "52").append("blue", "73"))
//                    .append("weight", "10").append("height", "5");
            // insert
           // collection.insertOne(new Document(fields));
           // collection.insertOne(fields1);
            for(Document doc : collection.find()){
                System.out.println(doc);
            }
            BasicDBObject findByField = new BasicDBObject().append("age", 55);

            BasicDBObject updateDoc = new BasicDBObject();

            updateDoc.append("$set", new BasicDBObject().append("age", 11));


            // update
            collection.updateOne(findByField, updateDoc);
          //  collection.updateMany(findByField, updateDoc);

            // find
            for(Document doc : collection.find()){
                System.out.println(doc);
            }

            //delete
            collection.deleteOne(findByField);

            for(Document doc : collection.find()){
                System.out.println(doc);
            }

        }


    }
}

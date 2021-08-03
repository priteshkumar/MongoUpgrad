import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import entity.Student;
import org.bson.Document;

public class MongoApp {

  static final String dbURL = "mongodb://54.147.63.10:27017";

  public static void main(String[] args) {

    MongoClient mongoClient = MongoClients.create(dbURL);
    System.out.println(mongoClient);

    MongoDatabase database = mongoClient.getDatabase("studentappdb");
    MongoCollection<Document> students = database.getCollection("students");

    System.out.println(students);
    Document st = new Student(2, "smith", 4, 29).createDBObject();
    students.insertOne(st);

    MongoCursor<Document> cursor = students.find().iterator();
    while (cursor.hasNext()) {
      System.out.println(cursor.next().toJson());
    }
    // System.out.println(res.toJson());

  }
}

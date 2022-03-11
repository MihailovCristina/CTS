package ro.ase.cts.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.cts.contract.ExpressionNOSQL;

public class CreateTable extends Mongo implements ExpressionNOSQL {

    @Override
    public void expression(MongoCollection<Document> collection) {
        MongoClient mongoClient = new MongoClient(getHost(), getPort());
        MongoDatabase mongoDb = mongoClient.getDatabase(getDatabaseName());
        if (mongoDb.getCollection(getCollection()) != null) {
            mongoDb.getCollection(getCollection()).drop();
        }
        mongoDb.createCollection(getCollection());
    }
}
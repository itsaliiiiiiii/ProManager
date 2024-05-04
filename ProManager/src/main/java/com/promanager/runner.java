package com.promanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.promanager.promanager.ProManager;

public class runner {
    public static void main(String[] args) {
        System.out.println("ProManager Application");
        ProManager.main(args);
        // don't run this function hhhhhhh
        // fillData();
    }

    public static void fillData() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ProManagerDB");
        MongoCollection<Document> collection = database.getCollection("Seances");

        Random random = new Random();
        LocalDate startDate = LocalDate.now().minusYears(5);
        LocalDate endDate = LocalDate.now();

        while (!startDate.isAfter(endDate)) {
            int sessionsPerDay = random.nextInt(4) + 1;
            for (int i = 0; i < sessionsPerDay; i++) {
                LocalDateTime startTime = startDate.atTime(random.nextInt(10) + 8, 0);
                LocalDateTime endTime = startTime.plusHours(random.nextInt(4) + 1);

                Document seance = new Document()
                        .append("DateDepart", Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()))
                        .append("DateFin", Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()))
                        .append("Description",
                                "Session on " + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .append("Note", "")
                        .append("Documents", Collections.emptyList());

                collection.insertOne(seance);
            }
            startDate = startDate.plusDays(1);
        }

        mongoClient.close();
        System.out.println("Data generation complete.");
    }
}

package com.example.firsttomcat.dao.AppNeo4j;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;

public class App {
    public static void main(String... args) {
        // Replace with your actual Neo4j database URI, username, and password
        final String dbUri = "<http://localhost:7474/browser/>";
        final String dbUser = "<neo4j>";
        final String dbPassword = "<vs6z39VUkbZ0jaYF6WtWtIEPKNpb6nYJ5O1fFcjEEZQ>";

        try (var driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, dbPassword))) {
            // Verify connectivity
            driver.verifyConnectivity();
        }
    }
}


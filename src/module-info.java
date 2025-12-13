module Book_Management {
	requires javafx.controls;
	requires java.sql;
	requires de.jensd.fx.glyphs.fontawesome;
	requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
	requires mysql.connector.j;
	requires com.rabbitmq.client;
	requires java.desktop;
	requires org.json;
	requires jbcrypt;
	requires java.prefs;
	requires java.mail;
	requires com.google.api.client.extensions.jetty.auth;
	requires google.api.client;
	requires com.google.api.client.auth;
	requires com.google.api.client;
	requires com.google.api.client.json.gson;
	requires com.google.api.client.extensions.java6.auth;
	requires jdk.httpserver;
	requires javafx.web;
	requires google.api.services.oauth2.v1.rev115;
	requires google.api.services.drive.v3.rev197;

	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}

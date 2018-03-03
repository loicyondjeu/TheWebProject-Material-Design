package de.hs_lu.mensa.model;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import de.hs_lu_mensa_dataaccess.MongoConnection;

public class User {

	public User() {
		
	}
	
	private String username, email, sex, function, password;
	private MongoCollection<Document> users;

	public void persist(){
		MongoConnection mongoConn = new MongoConnection();
		this.users = mongoConn.getMongoDataBase().getCollection("Users");
		users.insertOne(this.getDocument());
		mongoConn.close();
	}
	
	public void lookup(){
		MongoConnection mongoConn = new MongoConnection();
		this.users = mongoConn.getMongoDataBase().getCollection("Users");
		
		Bson userCondition = Filters.eq("username", this.username);
		Bson passwordCondition = Filters.eq("password", this.password);
		
		Document userDoc = this.users.find(Filters.and(userCondition, passwordCondition)).first();
		this.parse(userDoc);
	}
	
	public void parse(Document userDoc) {
		this.setUsername(userDoc.getString("username"));
		this.setPassword(userDoc.getString("password"));
		this.setEmail(userDoc.getString("email"));
		this.setSex(userDoc.getString("sex"));
		this.setFunction(userDoc.getString("function"));
	}

	public Document getDocument(){
		Document userDoc =  new Document();
		
		userDoc.append("username", this.username)
			   .append("password", this.password)
			   .append("email", this.email)
			   .append("sex",this.sex)
			   .append("function", this.function);
		
		return userDoc;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}

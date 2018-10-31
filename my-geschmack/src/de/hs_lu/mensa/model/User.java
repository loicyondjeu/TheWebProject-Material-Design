package de.hs_lu.mensa.model;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import de.hs_lu_mensa_dataaccess.MongoConnection;

public class User implements Persistable {

	private String username, email, sex, function, password;
	private MongoConnection mongoConn;
	private MongoCollection<Document> users;
	
	public User() {
		super();
	}
	
	public void initMongo(){
		this.mongoConn = new MongoConnection();
		this.users = this.mongoConn.getMongoDataBase().getCollection("Users");
	}

	public boolean mongoRead(){
		initMongo();
		
		Bson userCondition = Filters.eq("username", this.username);
		Bson passwordCondition = Filters.eq("password", this.password);
		
		Document userDoc;
		
		userDoc = this.users.find(Filters.and(userCondition, passwordCondition)).first();
		
		mongoConn.close();
		
		
		if(userDoc != null){
			this.toObject(userDoc);
			return true;
			}
		
		return false;
	}
	
	public void mongoUpdate(User old_user){
		initMongo();

		Bson userCondition = Filters.eq("username", old_user.getUsername());
		Bson passwordCondition = Filters.eq("password", old_user.getPassword());
		
		users.updateOne(Filters.and(userCondition, passwordCondition),
				        Updates.combine(Updates.set("username", this.username), Updates.set("password", this.password), Updates.set("email", this.email)));
		
		mongoConn.close();
	}
	
	public void mongoWrite(){
		initMongo();
		users.insertOne(this.toDocument());
		mongoConn.close();
	}
	
	public void toObject(Document userDoc) {
		this.setUsername(userDoc.getString("username"));
		this.setPassword(userDoc.getString("password"));
		this.setEmail(userDoc.getString("email"));
		this.setSex(userDoc.getString("sex"));
		this.setFunction(userDoc.getString("function"));
	}

	public Document toDocument(){
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

	@Override
	public String toString() {
		return String.format("User [username=%s, email=%s, sex=%s, function=%s, password=%s]", username, email, sex,
				function, password);
	}

}

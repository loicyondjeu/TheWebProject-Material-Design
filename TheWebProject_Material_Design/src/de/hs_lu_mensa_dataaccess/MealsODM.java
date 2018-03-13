package de.hs_lu_mensa_dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.hs_lu.mensa.model.Meal;

public class MealsODM {

	MongoConnection mcp;
	MongoClient mc;
	MongoDatabase md;
	MongoCollection<Document> mco;

	public MealsODM() {
		mcp = new MongoConnection();
		mc = mcp.getMongoClient();
		md = mc.getDatabase("MensaBase");
		mco = md.getCollection("Meals");

	}

	public List<Meal> getMeals(String name, String avg_eval, boolean vegetarian, String calories) {
		List<Meal> meals = new ArrayList<Meal>();
		Meal m;
		Document d = new Document();
		if (name.length() > 0)
			d.append("name", name);
		if (avg_eval.length() > 0)
			d.append("average-evaluation", Integer.parseInt(avg_eval));
		if (vegetarian)
			d.append("vegetarian", vegetarian);
		if (calories.length() > 0)
			d.append("calories-in-kcal", Integer.parseInt(calories));

		FindIterable<Document> fi = mco.find(d);
		for (Document meal : fi) {
			m = new Meal();
			m.setName(meal.getString("name"));
			// System.out.println(meal.getString("name"));
			m.setImage(meal.getString("image"));
			meals.add(m);

		}

		return meals;
	}

}

package de.hs_lu.mensa.helpers;

import javax.servlet.http.HttpSession;

import de.hs_lu.mensa.model.MealList;

public abstract class SessionManager {
	
	public static Messenger getSessionMessenger(HttpSession session){
		Messenger messenger = (Messenger)session.getAttribute("messenger");
		if(messenger == null){
			messenger = new Messenger();
			session.setAttribute("messenger", messenger);
		}
		return messenger;
	}
	
	public static MealList getSessionMeals(HttpSession session){
		MealList mealList = (MealList)session.getAttribute("mealList");
		if(mealList == null){
			mealList = new MealList();
			session.setAttribute("mealList", mealList);
		}
		return null;
	}

}

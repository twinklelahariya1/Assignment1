package Main;

import java.util.ArrayList;
import java.util.List;

import Annotations.Food;
import Annotations.Time;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import Entities.Burger;
import Entities.FoodItem;
import Entities.Pizza;

public class Launcher {

	/*
	 * Creating list of class' objects
	 */
	public static void generator() {

		List<FoodItem> foodItem = new ArrayList<>();
		Pizza pizza = new Pizza();
		Burger burger = new Burger();

		foodItem.add(pizza);
		foodItem.add(burger);
		Annotations(foodItem);

	}

	/*
	 * Implementing annotations and displaying values
	 */
	static void Annotations(List<FoodItem> foodItems) {
		for (FoodItem foodItem : foodItems) {

			Class<? extends FoodItem> c = foodItem.getClass();
			Annotation annotation = c.getAnnotation(Food.class);
			Food food = (Food) annotation;
			System.out.println("Food name " + food.name());
			System.out.println("Food price " + food.price());
			// annotations.add(foodInformation);

			Method m = null;
			try {
				m = c.getMethod("setTimeDetails");
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Annotation annotation2 = m.getAnnotation(Time.class);
			Time time = (Time) annotation2;
			System.out.println("Prepare time " + time.prepareTime());
			System.out.println("Cook time " + time.cookTime());
			System.out.println("Send time " + time.sendTime());

		}
	}

	/*
	 * Main class that calls generator that creates the list
	 *
	 */
	public static void main(String[] args) {
		generator();
	}
}

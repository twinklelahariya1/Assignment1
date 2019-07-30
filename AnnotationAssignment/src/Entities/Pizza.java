package Entities;

import Annotations.Food;
import Annotations.Time;

@Food(name = "Pizza", price = 200)
public class Pizza extends FoodItem {

	String name;
	int price;

	@Override
	@Time(prepareTime = 10, cookTime = 20, sendTime = 50)
	public int setTimeDetails() {
		return timeTaken;

	}

//	@Override
//	public void displayTimeInformation() {
//		// TODO Auto-generated method stub
//
//		System.out.println("Preparation time=" + prepareTime);
//		System.out.println("Cooking time=" + cookTime);
//		System.out.println("Delivery time=" + sendTime);
//
//	}
//
//	@Override
//	public void displayFoodInformation() {
//		// TODO Auto-generated method stub
//		System.out.println("Food name=" + name);
//		System.out.println("Price for food=" + price);
//	}

}

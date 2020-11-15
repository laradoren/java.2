//package com.company;
//import Elements.*;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Random;
//import java.util.Scanner;
//
//class Main {
//	private static String generateName() {
//		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
//		String alphaNumeric = lowerAlphabet;
//		StringBuilder sb = new StringBuilder();
//		Random random = new Random();
//		int length = 7;
//		for(int i = 0; i < length; i++) {
//			int index = random.nextInt(alphaNumeric.length());
//			char randomChar = alphaNumeric.charAt(index);
//			sb.append(randomChar);
//		}
//		String randomString = sb.toString();
//
//		return randomString.substring(0, 1).toUpperCase() + randomString.substring(1);
//	}
//
//	private static void createNulls(int x, int y, TerrainMap map1, ArrayList<NullElement> nulls){
//		NullElement n = new NullElement(x, y, Element.TypeOfElement.NULL, " ");
//		try {
//			if(map1.equals(n) && nulls.equals(n)) {
//				throw new ExceptionCreate();
//			} else {
//				nulls.add(n);
//				map1.addElementToMap(n);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//
//	}
//
//	private static void createHouse(int x, int y, TerrainMap map1, ArrayList<HouseElement> houses, String name) {
//		HouseElement house = new HouseElement(x, y, Element.TypeOfElement.HOUSE, name);
//		try {
//			if(map1.equals(house) && houses.equals(house)) {
//				throw new ExceptionCreate();
//			} else {
//				houses.add(house);
//				map1.addElementToMap(house);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//	}
//
//	private static void createShop(int x, int y, TerrainMap map1, ArrayList<ShopElement> shops, String name) {
//		ShopElement shop = new ShopElement(x, y, Element.TypeOfElement.SHOP, name);
//		try {
//			if(map1.equals(shop) && shops.equals(shop)) {
//				throw new ExceptionCreate();
//			} else {
//				shops.add(shop);
//				map1.addElementToMap(shop);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//	}
//
//	private static void createCafe(int x, int y, TerrainMap map1, ArrayList<CafeElement> cafes, String name) {
//		CafeElement cafe = new CafeElement(x, y, Element.TypeOfElement.CAFE, name);
//		try {
//			if(map1.equals(cafe) && cafes.equals(cafe)) {
//				throw new ExceptionCreate();
//			} else {
//				cafes.add(cafe);
//				map1.addElementToMap(cafe);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//	}
//
//	private static void createHospiatal(int x, int y, TerrainMap map1, ArrayList<HospitalElement> hospitals, String name) {
//		HospitalElement hospital = new HospitalElement(x, y, Element.TypeOfElement.HOSPITAL, name);
//		try {
//			if(map1.equals(hospital) && hospitals.equals(hospital)) {
//				throw new ExceptionCreate();
//			} else {
//				hospitals.add(hospital);
//				map1.addElementToMap(hospital);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//	}
//
//	private static void createSchool(int x, int y, TerrainMap map1, ArrayList<SchoolElement> schools, String name) {
//		SchoolElement school = new SchoolElement(x, y, Element.TypeOfElement.SCHOOL, name);
//		try {
//			if(map1.equals(school) && schools.equals(school)) {
//				throw new ExceptionCreate();
//			} else {
//				schools.add(school);
//				map1.addElementToMap(school);
//			}
//		} catch (ExceptionCreate ex) {
//			ex.showTheMessage();
//		}
//	}
//
//	private static void createMap(TerrainMap map1, ArrayList<ShopElement> shops, ArrayList<SchoolElement> schools, ArrayList<NullElement> nulls, ArrayList<HouseElement> houses, ArrayList<CafeElement> cafes, ArrayList<HospitalElement> hospitals, Location location, int SIZE) {
//		for(int x = 0; x < SIZE; x++) {
//			for(int y = 0; y < SIZE; y++) {
//				int randomNum = 1 + (int) (Math.random() * 30);
//				String name = generateName();
//				if(randomNum%2 == 0) {
//					createNulls(x, y, map1, nulls);
//				} else {
//					if(randomNum%3 == 0) {
//						createHouse(x, y, map1, houses, name);
//					} else {
//						if (randomNum%5 == 0) {
//							createShop(x, y, map1, shops, name);
//						} else {
//							if (randomNum%7 == 0) {
//								createCafe(x, y, map1, cafes, name);
//							} else {
//								if (randomNum%11 == 0) {
//									createHospiatal(x, y, map1, hospitals, name);
//								} else {
//									if (randomNum%13 == 0) {
//										createSchool(x, y, map1, schools, name);
//									} else {
//										createHouse(x, y, map1, houses, name);
//									}
//								}
//							}
//						}
//					}
//				}
//				if(x == location.getX() && y == location.getY()) {
//					location.setName(name);
//				}
//			}
//		}
//	}
//
//	private static void moveTo(String name, Location.Move move,  ArrayList<ShopElement> shops, ArrayList<SchoolElement> schools, ArrayList<NullElement> nulls, ArrayList<HouseElement> houses, ArrayList<CafeElement> cafes, ArrayList<HospitalElement> hospitals) {
//		for (ShopElement shop : shops) {
//			if (shop.getName().equals(name)) {
//				move.goTo(shop);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//		for (CafeElement cafe : cafes) {
//			if (cafe.getName().equals(name)) {
//				move.goTo(cafe);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//		for (HospitalElement hospital : hospitals) {
//			if (hospital.getName().equals(name)) {
//				move.goTo(hospital);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//		for (SchoolElement school : schools) {
//			if (school.getName().equals(name)) {
//				move.goTo(school);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//		for (NullElement n : nulls) {
//			if (n.getName().equals(name)) {
//				move.goTo(n);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//		for (HouseElement house : houses) {
//			if (house.getName().equals(name)) {
//				move.goTo(house);
//				move.setNameMoveToElement(name);
//			}
//		}
//
//	}
//
//	private static void printInfoShops(ArrayList<ShopElement> shops, Location location) {
//		Iterator<ShopElement> shop = shops.iterator();
//		while (shop.hasNext()) {
//			ShopElement s = shop.next();
//			s.print();
//			s.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void printInfoHouses(ArrayList<HouseElement> houses, Location location) {
//		Iterator<HouseElement> house = houses.iterator();
//		while (house.hasNext()) {
//			HouseElement h = house.next();
//			h.print();
//			h.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void printInfoSchools(ArrayList<SchoolElement> schools, Location location) {
//		Iterator<SchoolElement> school = schools.iterator();
//		while (school.hasNext()) {
//			SchoolElement s = school.next();
//			s.print();
//			s.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void printInfoCafes(ArrayList<CafeElement> cafes, Location location) {
//		Iterator<CafeElement> cafe = cafes.iterator();
//		while (cafe.hasNext()) {
//			CafeElement c = cafe.next();
//			c.print();
//			c.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void printInfoNulls(ArrayList<NullElement> nulls, Location location) {
//		Iterator<NullElement> null1 = nulls.iterator();
//		while (null1.hasNext()) {
//			NullElement n = null1.next();
//			n.print();
//			n.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void printInfoHospitals(ArrayList<HospitalElement> hospitals, Location location) {
//		Iterator<HospitalElement> hospital = hospitals.iterator();
//		while (hospital.hasNext()) {
//			HospitalElement h = hospital.next();
//			h.print();
//			h.calcDistance(location.getX(), location.getY());
//		}
//	}
//
//	private static void menu() {
//		System.out.println("1 Show all map");
//		System.out.println("2 Show nearest elements");
//		System.out.println("3 Show the all shop info");
//		System.out.println("4 Show the all house info");
//		System.out.println("5 Show the all school info");
//		System.out.println("6 Show the all cafe info");
//		System.out.println("7 Show the all null info");
//		System.out.println("8 Show the all hospital info");
//		System.out.println("9 Show the location");
//		System.out.println("0 Go to!");
//		System.out.println("q Exit");
//	}
//
//	private static String checkInput() {
//		Scanner scannerString = new Scanner(System.in);
//		String menuItem = "";
//		try {
//			menuItem = scannerString.nextLine();
//			String[] result = menuItem.split("");
//			if(result[0].matches("-?\\d+(\\.\\d+)?")) {
//				if(Integer.parseInt(result[0]) < 10) {
//					menuItem = result[0];
//				} else {
//					throw new ExceptionInput(menuItem);
//				}
//			} else {
//				if(result[0].equals("q")) {
//					menuItem = result[0];
//				} else {
//					throw new ExceptionInput(menuItem);
//				}
//			}
//		} catch (ExceptionInput e) {
//			System.out.println("Wrong input");
//			e.showTheMessage();
//		}
//		return menuItem;
//	}
//
//	private static void greeting(TerrainMap map1, ArrayList<ShopElement> shops, ArrayList<SchoolElement> schools, ArrayList<NullElement> nulls, ArrayList<HouseElement> houses, ArrayList<CafeElement> cafes, ArrayList<HospitalElement> hospitals, Location location) {
//		System.out.println("Hello! Carefully read the menu and choose the number!");
//		menu();
//		Scanner scannerInt = new Scanner(System.in);
//		Scanner scannerString = new Scanner(System.in);
//		String menuItem = "";
//		menuItem = checkInput();
//		while (menuItem != "q") {
//			switch (menuItem) {
//				case "1":
//					map1.print();
//					break;
//				case "2":
//					System.out.println("Enter the radius: ");
//					int radius = scannerInt.nextInt();
//					map1.getAroundElement(radius);
//					break;
//				case "3":
//					printInfoShops(shops, location);
//					break;
//				case "4":
//					printInfoHouses(houses, location);
//					break;
//				case "5":
//					printInfoSchools(schools, location);
//					break;
//				case "6":
//					printInfoCafes(cafes, location);
//					break;
//				case "7":
//					printInfoNulls(nulls, location);
//					break;
//				case "8":
//					printInfoHospitals(hospitals, location);
//					break;
//				case "9":
//					Location.Info info = location.new Info();
//					info.printInfo();
//					break;
//				case "0":
//					Location.Move move = location.new Move();
//					System.out.println("Enter the name of Element: ");
//					String name = scannerString.nextLine();
//					moveTo(name, move, shops, schools, nulls, houses, cafes, hospitals);
//					break;
//				case "q":
//					return;
//				default:
//					menu();
//					System.out.println("Please repeat: ");
//			}
//			menuItem = checkInput();
//		}
//	}
//
//    public static void main(String[] args) {
//		int SIZE = 10;
//	    TerrainMap map1 = new TerrainMap(SIZE);
//		Location location = new Location(1, 3);
//		map1.setLocation(location);
//
//		ArrayList<ShopElement> shops = new ArrayList<ShopElement>();
//		ArrayList<SchoolElement> schools = new ArrayList<SchoolElement>();
//		ArrayList<NullElement> nulls = new ArrayList<NullElement>();
//		ArrayList<HouseElement> houses = new ArrayList<HouseElement>();
//		ArrayList<CafeElement> cafes = new ArrayList<CafeElement>();
//		ArrayList<HospitalElement> hospitals = new ArrayList<HospitalElement>();
//
//		createMap(map1, shops, schools, nulls, houses, cafes, hospitals,location, SIZE);
//
//		greeting(map1, shops, schools, nulls, houses, cafes, hospitals, location);
//
//
//	}
//
//
//}

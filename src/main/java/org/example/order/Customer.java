package org.example.order;

public class Customer {

    public Cook order(String menuName, Menus menu, Cooking cooking) {
        MenuItem item = menu.choose(menuName);
        Cook cook = cooking.makeCook(item);
        return cook;
    }
}

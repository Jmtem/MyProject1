package ru.myapp.shopcart;

import ru.myapp.phone.Phone;

import java.util.List;

public class BasketService {


    public static void removeFromBasket(int id, List<Phone> myShopCart) {
        if(myShopCart !=null) {
            myShopCart.remove(id);
        }
    }
}

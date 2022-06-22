package ru.myapp;

import ru.myapp.phone.Phone;
import ru.myapp.phone.PhoneService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/addToBasket")
public class AddBasketPhoneServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";

    private Map<String, Phone> phone = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        phone = PhoneService.getAll();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);


        Phone selectPhone = phone.get(pName);

        Object myBasket = request.getSession().getAttribute(ServletHelper.SESSION_ATTRIBUTE_PHONE_SERVICE);
        if (myBasket !=null) {
            List<Phone> list = (List<Phone>)myBasket;
            list.add(selectPhone);
        } else {
            List<Phone> list = new ArrayList();
            list.add(selectPhone);
            request.getSession().setAttribute(ServletHelper.SESSION_ATTRIBUTE_PHONE_SERVICE, list);
        }

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>Product Added to basket!<p>");
        response.getWriter().append("<p><a href=\"./catalog\">HA3AD</a></p>");
        response.getWriter().append("<p><a href=\"/viewBasket\">Basket</a></p>");
        ServletHelper.populateHtmlEnd(response);
    }

}

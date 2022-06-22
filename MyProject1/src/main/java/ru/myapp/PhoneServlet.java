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

@WebServlet(urlPatterns = {"/phone"})
public class PhoneServlet extends HttpServlet {

    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    private static final String SIZE = "size";
    private static final String COLOR = "color";
    private static final String PRODUCING_COUNTRY = "producingCountry";

    private PhoneService phoneInit = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        phoneInit = (PhoneService) getServletContext().getAttribute(ServletHelper.SC_ATTRIBUTE_PHONE_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String phoneName = request.getParameter(NAME);

        Phone foundPhone = phoneInit.getAll().get(phoneName);

            ServletHelper.populateHtmlBegin(response);

            if (foundPhone != null) {
                response.getWriter().append("<p> Name: " + foundPhone.getName() + " Category " +
                        foundPhone.getCategory() + " Price: " + foundPhone.getPrice() + "</p>");
                response.getWriter().append("<p><a href=\"./addToBasket?name=" + foundPhone.getName() + "\">Add to basket</a></p>");
            } else {
                response.getWriter().append("<p>Unknown product<p>");
            }
            ServletHelper.populateHtmlEnd(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);
        String pCategory = request.getParameter(CATEGORY);
        String pPrice = request.getParameter(PRICE);
        String pSize = request.getParameter(SIZE);
        String pColor = request.getParameter(COLOR);
        String pProducingCountry = request.getParameter(PRODUCING_COUNTRY);

        Phone phone = new Phone(pName, Double.valueOf(pPrice), pCategory, pSize, pColor, pProducingCountry);
        phoneInit.add(phone);

        ServletHelper.populateHtmlBegin(response);

        response.getWriter().append("<p>New product added!</p>");
        response.getWriter().append("<p><a href=\"./phoneAdd.html\">HA3AD</a></p>");

        ServletHelper.populateHtmlEnd(response);
    }

}

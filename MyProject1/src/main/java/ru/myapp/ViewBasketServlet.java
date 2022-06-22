package ru.myapp;

import ru.myapp.phone.Phone;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/viewBasket")
public class ViewBasketServlet extends HttpServlet {

    public static final String TABLE_BEGIN = "<table style=\" border: 5px solid green;   border-collapse: collapse;\">\n" +
            "  <tr>\n" +
            "    <th>Name</th>\n" +
            "    <th>Category</th> \n" +
            "    <th>Price</th>\n" +
            "    <th>Size</th>\n" +
            "    <th>Color</th>\n" +
            "    <th>Country</th>\n" +
            "    <th>         </th>\n" +
            "  </tr>";

    public static final String TABLE_END = "</table>";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ServletHelper.populateHtmlBegin(response);
        HttpSession httpSession = request.getSession();
        List<Phone> myBasket = (List<Phone>)httpSession.getAttribute(ServletHelper.SESSION_ATTRIBUTE_PHONE_SERVICE);

        if (myBasket!=null && myBasket.size() != 0) {
            response.getWriter().append("<p>View basket:</p>");
            response.getWriter().append(TABLE_BEGIN);

            for (int i=0; i < myBasket.size(); i++) {
                Phone p = myBasket.get(i);

                response.getWriter().append("<tr>\n" +
                        "    <td>  " + p.getName() + "       </td>\n" +
                        "    <td>  " + p.getCategory() + "  </td> \n" +
                        "    <td>  " + p.getPrice() + "     </td>\n" +
                        "    <td>  " + p.getSize() + "      </td>\n" +
                        "    <td>  " + p.getColor() + "     </td>\n" +
                        "    <td>  " + p.getProducingCountry() + "      </td>\n" +
                        "    <td><a href= \"./remove?id=" + i + "\">Remove</a></td>\n" +
                        "  </tr>");
            }
            response.getWriter().append(TABLE_END);


        } else {
            response.getWriter().append("<p> The shopping cart is empty, add products </p>");
            response.getWriter().append("<p><a href=\"./catalog\">HA3AD</a></p>");
        }
        ServletHelper.populateHtmlEnd(response);
    }
}

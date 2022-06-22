package ru.myapp;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHelper {

    public static final String HTML_BODY_BEGIN = "<html><head><link rel=\"stylesheet\" href=\"mystyle.css\">\n</head><body>";
    public static final String HTML_BODY_END = "</body></html>";
    public static final String HREF_LINK_BACK = "<p><a href=\"./\">Return back</a></p>";
    public static final String SC_ATTRIBUTE_PHONE_SERVICE = "productService";
    public static final String SESSION_ATTRIBUTE_PHONE_SERVICE = "myBasket";


    public static void populateHtmlBegin(HttpServletResponse response) throws IOException {
        response.getWriter().append(HTML_BODY_BEGIN);
    }

    public static void populateHtmlEnd(HttpServletResponse response) throws IOException {

        response.getWriter().append(HREF_LINK_BACK);
        response.getWriter().append(HTML_BODY_END);
    }
}

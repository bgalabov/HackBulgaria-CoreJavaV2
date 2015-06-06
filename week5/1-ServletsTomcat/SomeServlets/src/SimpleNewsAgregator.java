

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SimpleNewsAgregator")
public class SimpleNewsAgregator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleNewsAgregator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
        URL url = new URL("http://www.sportal.bg/uploads/rss_category_2.xml");
        
        HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
        // Reading the feed
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
		try {
			feed = input.build(new XmlReader(httpcon));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<?> entries = feed.getEntries();
        Iterator<?> itEntries = entries.iterator();
 
        out.println("<h1>�����: </h1>");
        
        while (itEntries.hasNext()) {
            SyndEntry entry = (SyndEntry) itEntries.next();
            out.println("Title: " + entry.getTitle() + "<br/>");
            out.println("Link: " + entry.getLink() + "<br/>");
            out.println("Author: " + entry.getAuthor() + "<br/>");
            out.println("Publish Date: " + entry.getPublishedDate() + "<br/>");
            out.println("Description: " + entry.getDescription() + "<br/>");
            out.println("<br/>");
            System.out.println();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

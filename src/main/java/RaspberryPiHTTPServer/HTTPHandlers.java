package RaspberryPiHTTPServer;

import java.io.IOException;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HTTPHandlers {
    static final Gson gson = new Gson();

    public static class RootHandler implements HttpHandler {

         @Override 
         public void handle(HttpExchange he) throws IOException {
            String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + ServerRun.port + "</h1>";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.getBytes());
			os.close();
         }
    }

    public static class GetDataHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            SensorData sensors = new SensorData();
            String json = gson.toJson(sensors);

            he.sendResponseHeaders(200, json.length());
			OutputStream os = he.getResponseBody();
			os.write(json.getBytes());
			os.close();
        }
    }
}
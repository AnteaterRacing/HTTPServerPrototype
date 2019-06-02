package RaspberryPiHTTPServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

class HTTPServer {
    private int port;
    private HttpServer server;

    public void start(int port) {
        try{
            this.port = port;
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", new HTTPHandlers.RootHandler());
            server.createContext("/GetData", new HTTPHandlers.GetDataHandler());
            server.setExecutor(null);
			server.start();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        server.stop(0);
		System.out.println("server stopped");
    }
}
package server;

import com.sun.net.httpserver.HttpServer;
import sample.Controller;
import server.handlers.ChampionListHandler;
import server.handlers.SpecificChampionHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Michal Szarek
 **/
public class MyServer implements Subscriber {

    private String hostName;
    private int port;
    private HttpServer server;
    private Controller fxcontroller;
    private String filePath;

    public MyServer(String hostName, int port, Controller fxcontroller, String filePath) throws IOException {
        this.hostName = hostName;
        this.port = port;
        this.fxcontroller = fxcontroller;
        this.server = HttpServer.create(new InetSocketAddress(hostName, port), 0);
        this.filePath = filePath;
    }

    public void startServer() {
        server.createContext("/", new ChampionListHandler(this, filePath));
        server.createContext("/champion", new SpecificChampionHandler(this, filePath));
        server.setExecutor(null);
        server.start();
        fxcontroller.notify("Server running on localhost:3000");
    }

    @Override
    public void notify(String msg) {
        fxcontroller.notify(msg);
    }
}

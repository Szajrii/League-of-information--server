package server;

import com.sun.net.httpserver.HttpServer;
import sample.Controller;
import server.handlers.ChampionListHandler;

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

    public MyServer(String hostName, int port, Controller fxcontroller) throws IOException {
        this.hostName = hostName;
        this.port = port;
        this.fxcontroller = fxcontroller;
        this.server = HttpServer.create(new InetSocketAddress(hostName, port), 0);
    }

    public void startServer() {
        server.createContext("/", new ChampionListHandler(this));
        server.setExecutor(null);
        server.start();
        fxcontroller.notify("Server running on localhost:3000");
    }

    @Override
    public void notify(String msg) {
        fxcontroller.notify(msg);
    }
}

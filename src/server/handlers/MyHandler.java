package server.handlers;

import com.sun.net.httpserver.HttpHandler;
import server.Subscriber;


/**
 * Created by Michal Szarek
 **/
public abstract class MyHandler implements HttpHandler {
    protected Subscriber httpserver;
    protected String filePath;

    public MyHandler(Subscriber httpserver, String filePath) {
        this.httpserver = httpserver;
        this.filePath = filePath;
    }

}

package server.handlers;

import com.sun.net.httpserver.HttpHandler;
import server.Subscriber;


/**
 * Created by Michal Szarek
 **/
public abstract class MyHandler implements HttpHandler {
    protected Subscriber httpserver;

    public MyHandler(Subscriber httpserver) {
        this.httpserver = httpserver;
    }

}

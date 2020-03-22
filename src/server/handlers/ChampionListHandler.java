package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import server.Subscriber;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Michal Szarek
 **/
public class ChampionListHandler extends MyHandler {

    public ChampionListHandler(Subscriber httpserver) {
        super(httpserver);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "{\"cos\": \"siema\"}";
        exchange.getResponseHeaders().set("Content-Type", String.format("application/json; charset=%s",
                StandardCharsets.UTF_8));
        // exchange.getResponseHeaders().set("Content-Type", "appication/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        httpserver.notify("GET request for champions");
    }
}

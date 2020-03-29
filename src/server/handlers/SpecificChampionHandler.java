package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import server.Subscriber;
import server.champions.ChampionsList;
import server.champions.ComplexChampion;
import server.champions.SimpleChampion;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by Michal Szarek
 **/
public class SpecificChampionHandler extends MyHandler {

    public SpecificChampionHandler(Subscriber httpserver, String filePath) {
        super(httpserver, filePath);
    }

    public void handle(HttpExchange exchange) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        String championName = getRequestedChampionName(exchange);
        ArrayList<String> championDetails = new ArrayList<>();

        int i = 0;
        boolean championFound;
        for (Row row : sheet) {
            championFound = false;
            if (i == 0) {
                i++;
            } else {
                for (Cell cell : row) {
                    if (cell.toString().compareTo(championName) == 0) {
                        championFound = true;
                    }
                    if (championFound) {
                        championDetails.add(cell.toString());
                    }
                }
                i++;
            }
        }

        ComplexChampion champion = new ComplexChampion(championDetails);
        System.out.println(champion.toString());

        String response = champion.toString();
        exchange.getResponseHeaders().set("Content-Type", String.format("application/json; charset=%s",
                StandardCharsets.UTF_8));
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        httpserver.notify("POST request for champion: " + championName);
    }

    private String getRequestedChampionName(HttpExchange exchange) throws IOException {
        String champioName;
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);

        int b;
        StringBuilder buf = new StringBuilder();
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }

        br.close();
        isr.close();

        champioName = buf.toString().replace("{", "").replace("\"championName\"", "").replace(":", "")
                .replace("\"", "").replace("}", "").trim();
        return champioName;
    }

}

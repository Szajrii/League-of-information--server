package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import server.Subscriber;
import server.champions.ChampionsList;
import server.champions.SimpleChampion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Michal Szarek
 **/
public class ChampionListHandler extends MyHandler {

    public ChampionListHandler(Subscriber httpserver, String filePath) {
        super(httpserver, filePath);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        ChampionsList<SimpleChampion> championsList = new ChampionsList<>();

        int i = 0;
        for (Row row : sheet) {
            if (i == 0) {
                i++;
            } else {
                SimpleChampion champ = new SimpleChampion();
                for (Cell cell : row) {
                    if (cell.getColumnIndex() == 0) {
                        champ.setName(cell.toString());
                    }
                    if (cell.getColumnIndex() == 2) {
                        champ.setImgSuffix(cell.toString());
                    }
                }
                championsList.addChampion(champ);
                i++;
            }
        }
        String response = championsList.toString();
        exchange.getResponseHeaders().set("Content-Type", String.format("application/json; charset=%s",
                StandardCharsets.UTF_8));
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        httpserver.notify("GET request for champions");
    }
}

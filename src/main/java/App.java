
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", ((request, response) -> {


            return modelAndView(new HashMap<>(), "index.hbs");
        }), new HandlebarsTemplateEngine());


        post("/", ((request, response) -> {
            String message = request.queryParams("msg");
            Map<String, Object> data = new HashMap<>();
            data.put("input", message);

            Cipher cipher = new Cipher();

           String cipheredMessage =  cipher.cipherWord(message);
           data.put("encrypted", cipheredMessage);


            return modelAndView(data, "index.hbs");
        }), new HandlebarsTemplateEngine());

    }
}

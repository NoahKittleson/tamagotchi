import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/actions", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      boolean isAlive = true;

      if (request.session().attribute("newTamagotchi") != null) {
        Tamagotchi newTamagotchi = request.session().attribute("newTamagotchi");
        String action = request.queryParams("action");
        if (action != null){
          if (action.equals("feed")) {
            newTamagotchi.feed();
          } else if (action.equals("exercise")) {
            newTamagotchi.exercise();
          } else if (action.equals("sleep")) {
            newTamagotchi.sleep();
          } else if (action.equals("play")) {
            newTamagotchi.play();
          } else if (action.equals("discipline")) {
            newTamagotchi.discipline();
          }
        }
        isAlive = newTamagotchi.isAlive();
        model.put("newTamagotchi", newTamagotchi);
      } else {
        String name = request.queryParams("name");
        String color = request.queryParams("color");
        Tamagotchi newTamagotchi = new Tamagotchi(name, color);
        request.session().attribute("newTamagotchi", newTamagotchi);
        model.put("newTamagotchi", newTamagotchi);
      }

      if (isAlive) {
        model.put("template", "templates/actions.vtl");
      } else {
        model.put("template", "templates/dead.vtl");
        request.session().attribute("newTamagotchi", null);
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}

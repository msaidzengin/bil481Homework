package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
public class App {
    public static String search(ArrayList<Integer> array, ArrayList<Integer> array2, String name, String lastname) {
        System.out.println("inside search");
        String s = "";
        if(array == null) 
            return "";
        else {
            if (array.size() < name.length()) {
                for(int i=0; i<name.length()-array.size(); i++) {
                    Random rand = new Random();
                    array.add(rand.nextInt(20) + 1);
                }
            }
            for(int i=0; i<name.length(); i++) {
                char c = (char)(name.charAt(i) + array.get(i));
                s += c;
            }
            s += " ";
            if (array2.size() < lastname.length()) {
                for(int i=0; i<lastname.length()-array2.size(); i++) {
                    Random rand = new Random();
                    array2.add(rand.nextInt(20) + 1);
                }
            }
            for(int i=0; i<lastname.length(); i++) {
                char c = (char)(lastname.charAt(i) + array2.get(i));
                s += c;
            }
            return s;
        }
   }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "Hello, World");
        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext()) {
                int value2 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value2);
            }
            System.out.println(inputList2);

            String input3 = req.queryParams("input3").replaceAll("\\s","");
            String input4 = req.queryParams("input4").replaceAll("\\s","");
            String result = App.search(inputList, inputList2, input3, input4);
            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute",
            (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
        },
            new MustacheTemplateEngine());
        }
        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }
}

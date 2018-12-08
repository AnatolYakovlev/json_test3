import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class JsonRedaktor extends JFrame {
    private JPanel MainPanel;
    private JButton openButton;
    private JButton saveButton;
    private JEditorPane jsonPole;
    private JButton addButton;

    public JsonRedaktor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(MainPanel);
        setSize(800, 600);
        setVisible(true);

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                try {
                    String soderjimoe = new String(Files.readAllBytes
                            (Paths.get("fruit.json")));
                   jsonPole.setText(soderjimoe);
                } catch (IOException e1) {
                    System.out.println("1");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String izPolia = jsonPole.getText();
                    Writer writer = new FileWriter("fruit.json",false);
                    writer.write(izPolia);
                    writer.flush();


                } catch (IOException e1) {
                    System.out.println("2");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JSONObject jo = new JSONObject();
                    jo.put("fruit","pineaplle");
                    jo.put("Sixe","Medium");
                    jo.put("Weight",900);
                jo.add(jo);
                    JSONArray ja = new JSONArray();
                jo.put("fruit","Melon");
                jo.put("Sixe","large");
                jo.put("Weight",2300);
                ja.add(ja);

                jo = new JSONObject();
                jo.put("Fruties",ja);

                    jsonPole.setText(jo.toJSONString());

            }
        });
    }
}

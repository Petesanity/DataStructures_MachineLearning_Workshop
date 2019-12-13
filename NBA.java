package Hashmap;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NBA extends JFrame {
    //add key val of hashmap to key model
    //list data listener
    DefaultListModel<String> model =  new DefaultListModel<>();
    //selection of multiple objects from a list
    private JList<String>list = new JList<>(model);

    JPanel panel  = new JPanel();
    JLabel labelForImages = new JLabel();

    HashMap<String , String> map =  new HashMap<>(); //associate each string with a file



    public NBA(){
        super("NBA Players");

        map.put("Stephen Curry", "C:\\Users\\Peter Farquharson\\IdeaProjects\\TechnicalInterviewing\\src\\Hashmap\\curry.jpg");
        map.put("Lebron James", "C:\\Users\\Peter Farquharson\\IdeaProjects\\TechnicalInterviewing\\src\\Hashmap\\lebron.jpg");
        map.put("Kevin Durant", "C:\\Users\\Peter Farquharson\\IdeaProjects\\TechnicalInterviewing\\src\\Hashmap\\KD.jpg");
        map.put("Giannis Antetokounmpo", "C:\\Users\\Peter Farquharson\\IdeaProjects\\TechnicalInterviewing\\src\\Hashmap\\giannis.jpg");
        map.put("James Harden", "C:\\Users\\Peter Farquharson\\IdeaProjects\\TechnicalInterviewing\\src\\Hashmap\\Harden.jpg");


        for(Object obj : map.keySet()){
            model.addElement((String.valueOf(obj)));
        }

        add(new JScrollPane(list));
        panel.add(labelForImages);
        panel.setBackground(Color.BLUE);
        add(panel);
        //listener for list
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    //get imgs to be displayed on JPanel
                    for(Object o : map.keySet()){
                        if(list.getSelectedValue().equals(o)){
                            labelForImages.setIcon(new ImageIcon(map.get(o)));
                            panel.add(labelForImages);
                            repaint();

                        }
                    }
                }
            }
        });

        setLayout(new FlowLayout());
        setBackground(Color.BLUE);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,399);
        setVisible(true);
    }
    public static void main(String [] args){
        new NBA();
    }
}

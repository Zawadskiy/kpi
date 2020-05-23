import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main  extends JFrame {

    private static List<Integer> lst = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
    private  static  List<Integer> result = new ArrayList<>();

    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");

    static boolean successfully = true;

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
        generate();

    }

    static void factor(double n){

        if(n==2) result.add(2);
        else {


        double x = Math.sqrt(n);
        double y = 0;
        int k = 0;

        if(x%1!=0) {
            x = (int)++x;
        }

        for ( k = 1;Math.sqrt((x+k-1)*(x+k-1)-n) % 1 != 0 ; k++){
            System.out.println("K=" + k + " y= " + Math.sqrt((x+k)*(x+k)-n) +" x=" + x);
            if(k>n) break;
        }

        if(k<=n) {
            int a = (int) (x + k - 1 + Math.sqrt((x + k - 1) * (x + k - 1) - n));
            int b = (int) (x + k - 1 - Math.sqrt((x + k - 1) * (x + k - 1) - n));

            if (lst.contains(a)) {
                result.add(a);
            } else if (a!=1){
                factor(a);
            }
            if (lst.contains(b)) {
                result.add(b);
            } else if(b!=1) {
                factor(b);
            }
        } else successfully = false;
        }
    }

    public static void generate() {
        for (int i = 2; i < 999999; i++) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) lst.add(i);
        }
    }

    public Main() {
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            result.clear();
            factor(Double.parseDouble(input.getText()));
            String message = "";
            if(successfully) {
                 message = "" + result.get(0);
                for (int i = 1; i < result.size(); i++) {
                    System.out.println(result.get(i));
                    message += ", " + result.get(i);
                }
            } else{
                 message = "Не удалось факторизировать";
            }
            successfully = true;
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}

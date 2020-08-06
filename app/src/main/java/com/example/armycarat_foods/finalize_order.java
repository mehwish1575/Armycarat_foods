package com.example.armycarat_foods;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.String.valueOf;

public class finalize_order extends Activity {
    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";
    databasehelper_order dbo;
    DatabaseHelper dd;
    String temp_order_view;
    TextView tv ;
    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo=this;
        dbo = new databasehelper_order(this);
        dd=new DatabaseHelper(this);
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "chocolate ice cream-" + valueOf(Dessert.chocolate_ice_cream) + ",";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "vannila ice cream-" + valueOf(Dessert.vanilla_ice_cream) + ",";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "strawberry ice cream-" + valueOf(Dessert.strawberry_ice_cream) + ",";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "falooda-" + valueOf(Dessert.falooda) + ",";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "brownie fudge-" + valueOf(Dessert.brownie_fudge) + ",";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "alpine chocolate-" + valueOf(Dessert.alpine_chocolate) + ",";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "devils delite-" + valueOf(Dessert.devils_delight) + ",";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "black forest-" + valueOf(Dessert.black_forest) + ",";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "chocolate lava-" + valueOf(Dessert.chocolate_lava) + ",";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "dutch almond-" + valueOf(Dessert.dutch_almond) + ",";
        }
        if (N_Veg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "chicken burger-" + valueOf(N_Veg.chicken_burger) + ",";
        }
        if (N_Veg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "chicken bbq pizza-" + valueOf(N_Veg.chicken_bbq_pizza) + ",";
        }
        if (N_Veg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "chicken tikka-" + valueOf(N_Veg.chicken_tikka) + ",";
        }
        if (N_Veg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "fried fish rice-" + valueOf(N_Veg.fried_fish_rice) + ",";
        }
        if (N_Veg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "kolhapur chicken-" + valueOf(N_Veg.kolhapuri_chicken) + ",";
        }
        if (N_Veg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "chicken noodles-" + valueOf(N_Veg.chicken_noodles) + ",";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "chicken fried rice-" + valueOf(N_Veg.chicken_fried_rice) + ",";
        }

        if (N_Veg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "chicken lollipop-" + valueOf(N_Veg.chicken_lollipop) + ",";
        }

        if (N_Veg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "chicken biryani-" + valueOf(N_Veg.chicken_biryani) + ",";
        }
        if (N_Veg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "mutton biryani-" + valueOf(N_Veg.mutton_biryani) + ",";
        }

        if (veg.roti > 0) {
            fin_order_string = fin_order_string + "roti-" + valueOf(veg.roti) + ",";
        }
        if (veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "butter roti-" + valueOf(veg.butter_roti) + ",";
        }
        if (veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "paneer tikka-" + valueOf(veg.paneer_tikka) + ",";
        }

        if (veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "veg pulao-" + valueOf(veg.veg_pulao) + ",";
        }
        if (veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "mutter paneer-" + valueOf(veg.mutter_paneer) + ",";
        }
        if (veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "veg noodles-" + valueOf(veg.veg_noodles) + ",";
        }

        if (veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "veg fried rice-" + valueOf(veg.veg_fried_rice) + ",";
        }
        if (veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "veg burger-" + valueOf(veg.veg_burger) + ",";
        }
        if (veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "veg briyani-" + valueOf(veg.veg_biryani) + ",";
        }

        if (veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "paneer kofta-" + valueOf(veg.paneer_kofta) + ",";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "veg crispy-" + valueOf(Starters.veg_crispy) + ",";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "chicken crispy-" + valueOf(Starters.chicken_crispy) + ",";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "paneer chilly-" + valueOf(Starters.paneer_chilly) + ",";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad-" + valueOf(Starters.masala_papad) + ",";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup-" + valueOf(Starters.veg_soup) + ",";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "chicken soup-" + valueOf(Starters.chicken_soup) + ",";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "tomato soup-" + valueOf(Starters.tomato_soup) + ",";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "cheese pakoda-" + valueOf(Starters.cheese_pakoda) + ",";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "paneer pakoda-" + valueOf(Starters.paneer_pakoda) + ",";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "chicken chilly-" + valueOf(Starters.chicken_chilly) + ",";
        }
        temp_order_view=fin_order_string+old_ord_string;
        tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_type.class);
        startActivity(goto_main_menu);
       // overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "Rs" +(finalize_order.all_total));
    }



    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;



        final Object o = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to confirm this order?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int s= home.tablex ;
                        String table= valueOf(s);
                        String user=dd.getuser("0");
                        String order=(""+temp_order_view);
                      long val= dbo.addorder(user,order,table);
                         if(val>0)
                         {
                             Toast.makeText(finalize_order.this, "order added", Toast.LENGTH_SHORT).show();

                         }
                         else
                         {
                             Toast.makeText(finalize_order.this, "error", Toast.LENGTH_SHORT).show();

                         }
                        messsage = "Order:" + home.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total)+"|"+personal_preferances;
                        ; // get the text message on the text field
                        // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                        SendMessage sendMessageTask = new SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((finalize_order) o, thankyou.class);
                        startActivity(nextact);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
package com.example.armycarat_foods;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thankyou extends Activity {
Button revbu;



    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
      Button revbu = (Button)findViewById(R.id.reviewbu);
      revbu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intre = new Intent(thankyou.this,review.class);
              startActivity(intre);

          }
      });
    }


    public void main_menu(View view)
    {
        finalize_order.next_ord_flag=1;
        finalize_order.old_ord_string=finalize_order.order_string+finalize_order.old_ord_string;
        finalize_order.old_all_total=finalize_order.all_total;

        N_Veg.chicken_burger=0;
        N_Veg.chicken_bbq_pizza=0;
        N_Veg.chicken_tikka=0;
        N_Veg.fried_fish_rice=0;
        N_Veg.kolhapuri_chicken=0;
        N_Veg.chicken_noodles=0;
        N_Veg.chicken_fried_rice=0;
        N_Veg.chicken_lollipop=0;
        N_Veg.chicken_biryani=0;
        N_Veg.mutton_biryani=0;
        N_Veg.n_veg_total=0;

        Starters.veg_crispy=0;
        Starters.chicken_crispy=0;
        Starters.paneer_chilly=0;
        Starters.chicken_chilly=0;
        Starters.masala_papad=0;
        Starters.veg_soup=0;
        Starters.chicken_soup=0;
        Starters.tomato_soup=0;
        Starters.cheese_pakoda=0;
        Starters.paneer_pakoda=0;
        Starters.starters_total=0;

        veg.roti=0;
        veg.butter_roti=0;
        veg.paneer_tikka=0;
        veg.veg_pulao=0;
        veg.mutter_paneer=0;
        veg.veg_noodles=0;
        veg.veg_fried_rice=0;
        veg.veg_burger=0;
        veg.veg_biryani=0;
        veg.paneer_kofta=0;
        veg.total_veg=0;

        Dessert.chocolate_ice_cream=0;
        Dessert.vanilla_ice_cream=0;
        Dessert.strawberry_ice_cream=0;
        Dessert.falooda=0;
        Dessert.brownie_fudge=0;
        Dessert.alpine_chocolate=0;
        Dessert.devils_delight=0;
        Dessert.black_forest=0;
        Dessert.chocolate_lava=0;
        Dessert.dutch_almond=0;
        Dessert.dessert_total=0;


        Intent menu= new Intent(this,MainActivity.class);
        startActivity(menu);

    }



}

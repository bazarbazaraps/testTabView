package bazarbazaraps.worldcupgoal

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import bazarbazaraps.worldcupgoal.R.id.tabs_main
import bazarbazaraps.worldcupgoal.R.id.viewpager_main

import kotlinx.android.synthetic.main.activity_main.*

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd


class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-9103822257004637~2938245107")
        mInterstitialAd = InterstitialAd(this)

        mInterstitialAd.adUnitId = "ca-app-pub-9103822257004637/7068513060"

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

       val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.offscreenPageLimit = 10
        viewpager_main.adapter = fragmentAdapter
        //viewpager_main.setPageTransformer(true, CubeOutTransformer())
        tabs_main.setupWithViewPager(viewpager_main)

        tabs_main.getTabAt(0)!!.setIcon(R.drawable.argentina)
        tabs_main.getTabAt(1)!!.setIcon(R.drawable.brazil)
        tabs_main.getTabAt(2)!!.setIcon(R.drawable.colombia)
        tabs_main.getTabAt(3)!!.setIcon(R.drawable.czech)
        tabs_main.getTabAt(4)!!.setIcon(R.drawable.england)
        tabs_main.getTabAt(5)!!.setIcon(R.drawable.france)
        tabs_main.getTabAt(6)!!.setIcon(R.drawable.germany)
        tabs_main.getTabAt(7)!!.setIcon(R.drawable.ghana)
        tabs_main.getTabAt(8)!!.setIcon(R.drawable.iceland)
        tabs_main.getTabAt(9)!!.setIcon(R.drawable.italy)
        tabs_main.getTabAt(10)!!.setIcon(R.drawable.japan)
        tabs_main.getTabAt(11)!!.setIcon(R.drawable.portugal)
        tabs_main.getTabAt(12)!!.setIcon(R.drawable.spain)



        fun Context.toast(message: CharSequence) =
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()


        this.toast("LONG PUSH ON THE ITEM FOR SHARE")

/*        val sample_names_const = arrayListOf<String>(
                "argentinagoal1",
               "argentinagoal2",
               "argentinagoal3",
               "argentinagoal4",
               "argentinagoal5"


       )

       val listView = findViewById<ListView>(R.id.samples_list_view)
       listView.adapter = MyCustomAdapter(this)





       val MP_instances = ArrayList<Int>()

       MP_instances.add(R.raw.argentinagoal1)
       MP_instances.add(R.raw.argentinagoal2)
       MP_instances.add(R.raw.argentinagoal3)
       MP_instances.add(R.raw.argentinagoal4)
       MP_instances.add(R.raw.argentinagoal5)




       mp = MediaPlayer.create(this, R.raw.argentinagoal1)
       fun play(sample: Int) {
           mp = MediaPlayer.create(this, sample)

           mp.start()
           mp.isLooping = false
       }

       fun reset_sound(sample: Int) {

           if (mp.isPlaying) {
               mp.reset();
               mp = MediaPlayer.create(this, sample)
           }


       }

       fun share_audio(file_path: String) {
           val audio = Uri.parse(file_path)

           val shareIntent = Intent()
           shareIntent.action = Intent.ACTION_SEND
           shareIntent.type = "audio/mpeg"
           shareIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
           shareIntent.putExtra(Intent.EXTRA_STREAM, audio);

           startActivity(Intent.createChooser(shareIntent, "Rick Morty SB share..."))

       }


       listView.setOnItemClickListener { parent, view, position, id ->
           reset_sound(MP_instances[position])
           play(MP_instances[position])
           //     mInterstitialAd.show()


       }

       listView.setOnItemLongClickListener { parent, view, position, id ->
           share_audio("android.resource://bazarbazaraps.testtabview/raw/" + sample_names_const[position])

/*
              saveas()
              Toast.makeText(this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString(), Toast.LENGTH_LONG).show()
              */
           true
       }

   }
}

private class MyCustomAdapter(context: Context) : BaseAdapter() {


   private val sample_names = arrayListOf<String>(
           "Argentina Goal 1",
           "Argentina Goal 2",
           "Argentina Goal 3",
           "Argentina Goal 4",
           "Argentina Goal 5"

   )

   private var mContext = context

   init {
       mContext = context
   }

   override fun getCount(): Int {
       return sample_names.size
   }

   override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       //val textView = TextView(mContext)
       //textView.text="row"
       // return textView

       val layoutInflater = LayoutInflater.from(mContext)
       val rowMain = layoutInflater.inflate(R.layout.row_main, parent, false)
       val sampleTextView = rowMain.findViewById<TextView>(R.id.sampletextView)
       sampleTextView.text = sample_names[position]
       return rowMain
   }

   override fun getItemId(position: Int): Long {
       return position.toLong()
   }

   override fun getItem(position: Int): Any {
       return "test"
   }
*/

   }
}
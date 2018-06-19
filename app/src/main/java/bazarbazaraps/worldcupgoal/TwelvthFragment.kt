package bazarbazaraps.worldcupgoal


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import bazarbazaraps.worldcupgoal.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TwelvthFragment : Fragment() {
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        MobileAds.initialize(context, "ca-app-pub-9103822257004637~2938245107")

        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = "ca-app-pub-9103822257004637/9646660666"
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        val testList = arrayOf(
                "Portugal Goal 1",
                "Portugal Goal 2",
                "Portugal Goal 3",
                "Portugal Goal 4",
                "Portugal Goal 5",
                "Portugal Goal 6")

        val sample_names_const = arrayOf(
                "portugalgoal1",
                "portugalgoal2",
                "portugalgoal3",
                "portugalgoal4",
                "portugalgoal5",
                "portugalgoal6")

        val MP_instances = ArrayList<Int>()

        MP_instances.add(R.raw.portugalgoal1)
        MP_instances.add(R.raw.portugalgoal2)
        MP_instances.add(R.raw.portugalgoal3)
        MP_instances.add(R.raw.portugalgoal4)
        MP_instances.add(R.raw.portugalgoal5)
        MP_instances.add(R.raw.portugalgoal6)


        val rootView = inflater.inflate(R.layout.fragment_twelvth, container, false)


        val adapter = MySimpleArrayAdapter(context, testList)

        listView = rootView.findViewById(R.id.listview12)
        listView.adapter = adapter

        val mediaPlayer = MediaPlayerSingleton.instance

        //mediaPlayer.mp = MediaPlayer.create(context, R.raw.argentinagoal1)


        fun share_audio(file_path: String) {
            val audio = Uri.parse(file_path)

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "audio/mpeg"
            shareIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            shareIntent.putExtra(Intent.EXTRA_STREAM, audio);

            startActivity(Intent.createChooser(shareIntent, "Goal share..."))

        }

        listView.setOnItemClickListener {

            parent, view, position, id ->
            mediaPlayer.reset_sound(MP_instances[position], context)
            // reset_sound(mediaPlayer, MP_instances[position])
            mediaPlayer.MPplay(MP_instances[position], context)
            //  mInterstitialAd.show()
            mInterstitialAd.show()
        }

        listView.setOnItemLongClickListener { parent, view, position, id ->
            share_audio("android.resource://bazarbazaraps.worldcupgoal/raw/" + sample_names_const[position])
            true
        }



        return rootView


    }
}
package bazarbazaraps.testtabview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import bazarbazaraps.testtabview.R.id.tabs_main
import bazarbazaraps.testtabview.R.id.viewpager_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }
}

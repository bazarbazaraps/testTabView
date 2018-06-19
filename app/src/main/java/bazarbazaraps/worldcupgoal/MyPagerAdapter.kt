package bazarbazaraps.worldcupgoal
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            4 -> FifthFragment()
            5 -> SixthFragment()
            6 -> SeventhFragment()
            7 -> EigthFragment()
            8 -> NinethFragment()
            9 -> TenthFragment()
            10 -> EleventhFragment()
            11 -> TwelvthFragment()
            else -> {
                return ThirtheenthFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 13
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "ARGENTINA"
            1 -> "BRAZIL"
            2 -> "COLOMBIA"
            3 -> "CZECH"
            4 -> "ENGLAND"
            5 -> "FRANCE"
            6 -> "GERMANY"
            7 -> "GHANA"
            8 -> "ICELAND"
            9 -> "ITALY"
            10 -> "JAPAN"
            11 -> "PORTUGAL"

            else -> {
                return "SPAIN"
            }
        }
    }


}
package kotlins.skills.remember.useCase.Intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import kotlins.skills.remember.R
import javax.inject.Inject

class IntroViewPagerAdapter @Inject constructor(
    val mContext: Context,
    val mListScreen: List<ScreenItem>
) : PagerAdapter() {

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(view: View, _object: Any): Boolean {
        return view == _object
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.layout_screen, null)
        val imgSlide = layoutScreen.findViewById<ImageView>(R.id.img_intro)
        val title = layoutScreen.findViewById<TextView>(R.id.tv_title)
        val description = layoutScreen.findViewById<TextView>(R.id.tv_description)
        title.setText(mListScreen[position].Title)
        description.setText(mListScreen[position].Description)
        imgSlide.setImageResource(mListScreen[position].ScreenImg)
        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun destroyItem(container: ViewGroup, position: Int, _object: Any) {
        container.removeView(_object as View)
    }
}

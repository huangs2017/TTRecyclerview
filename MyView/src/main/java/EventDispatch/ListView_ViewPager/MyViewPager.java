package EventDispatch.ListView_ViewPager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

/**
 * ViewPager ListView 相互冲突解决方法
 * <p>
 * 使用父类的方法requestDisallowInterceptTouchEvent(boolean disallowIntercept);
 * 当disallowIntercept=true的时候，表示父view不拦截子view的touch事件
 */
public class MyViewPager extends ViewPager {

    private ViewGroup parent;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNestedParent(ViewGroup parent) {
        this.parent = parent;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }


	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (parent != null) {
			parent.requestDisallowInterceptTouchEvent(true);
		}
		return super.onInterceptTouchEvent(arg0);
	}

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(arg0);
    }

}

package tang.chinwe.experiment

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet
import android.widget.FrameLayout
import android.widget.ImageView

/**
 * 首页站点site引导动画
 * corner：首页site的左上角顶点横坐标和纵坐标
 */
class HomeSiteGuidanceView(context: Context?, var corner: Pair<Float, Float>) :
    FrameLayout(context) {

    init {
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }


    val dp_36 by lazy {
        AndroidUtil.dpToPx(36f, context)
    }

    val dp_9 by lazy {
        AndroidUtil.dpToPx(9f, context)
    }

    val dp_18 by lazy {
        AndroidUtil.dpToPx(18f, context)
    }

    val dp_27 by lazy {
        AndroidUtil.dpToPx(27f, context)
    }

    val dp_80 by lazy {
        AndroidUtil.dpToPx(80f, context)
    }

    /**
     * 总动画时长
     */
    val allTime = 4000L

    /**
     * 一次缩/放时长
     */
    val scaleTime = 187L

    val screenWidth by lazy {
        DeviceUtil.getScreenWidth(context)
    }

    val isLeft by lazy {
        /**
         * 左上角的点在屏幕左边时动画往右边做
         */
        corner.first <= screenWidth
    }

    val siteLeftMargin by lazy {
        corner.first.toInt()
    }

    val siteTopMargin by lazy {
        corner.second.toInt()
    }

    val youtubeHorizontalMargin by lazy {
        if (isLeft) {
            corner.first.toInt()
        } else {
            corner.first.toInt() - (dp_80 - dp_36)
        }
    }

    val youtubeVerticalMargin by lazy {
        corner.second.toInt() + dp_9
    }

    val siteImageView by lazy {
        ImageView(context).apply {
            layoutParams = LayoutParams(dp_36, dp_36).apply {
                leftMargin = siteLeftMargin
                topMargin = siteTopMargin
            }
            setImageResource(R.mipmap.nav_more)
        }
    }

    val youtubeImageView by lazy {
        ImageView(context).apply {
            layoutParams = LayoutParams(dp_80, dp_18).apply {
                topMargin = youtubeVerticalMargin
                leftMargin = youtubeHorizontalMargin
            }
            setImageResource(R.mipmap.nav_home_guidance)
        }
    }


    /**
     * 开始引导动画
     */
    fun startGuidance() {
        removeAllViews()
        startSiteGuidance()
        startYouTubeGuidance()
    }


    private fun startYouTubeGuidance() {
        addView(youtubeImageView)
        val set1 = AnimatorSet().apply {
            play(youtubeAnima2()).after(200).after(youtubeAnima2())
        }
        val set2 = AnimatorSet().apply {
            play(youtubeAnima3()).before(youtubeAnima4())
        }
        AnimatorSet().apply {
            play(set1).after(youtubeAnima1()).before(set2)
        }.start()
    }


    private fun youtubeAnima1(): ValueAnimator {
        var marginTop = youtubeVerticalMargin
        var marginLeft = youtubeHorizontalMargin
        var h = dp_18
        var w = dp_80
        return ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener {
                val schedule = it.animatedValue as Float
                youtubeImageView.apply {
                    alpha = schedule
                    layoutParams = (layoutParams as? FrameLayout.LayoutParams)?.apply {
                        leftMargin = (marginLeft + schedule * if (isLeft) {
                            dp_18
                        } else {
                            dp_18 - dp_80
                        }).toInt()
                        topMargin = (marginTop + schedule * dp_27).toInt()
                        width = (w + w * schedule).toInt()
                        height = (h + h * schedule).toInt()
                    }
                }
            }
        }
    }

    private fun youtubeAnima2(): ValueAnimator {
        var marginTop = 0
        return ValueAnimator.ofFloat(0f, 1f).apply {
            addListener(object : DefaultAnimatorListener() {
                override fun onAnimationStart(animation: Animator?) {
                    marginTop =
                        (youtubeImageView.layoutParams as FrameLayout.LayoutParams).topMargin
                }
            })
            interpolator = AccelerateDecelerateInterpolator()
            duration = 200
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener {
                val schedule = it.animatedValue as Float
                youtubeImageView.apply {
                    layoutParams = (layoutParams as? FrameLayout.LayoutParams)?.apply {
                        topMargin = (marginTop - dp_9 * schedule).toInt()
                    }
                }
            }
        }
    }

    private fun youtubeAnima3(): ValueAnimator {
        var w = 0
        var h = 0
        var marginLeft = 0
        var marginTop = 0
        return ValueAnimator.ofFloat(0f, 0.2f).apply {
            duration = 500
            addListener(object : DefaultAnimatorListener() {
                override fun onAnimationStart(animation: Animator?) {
                    w = youtubeImageView.width
                    h = youtubeImageView.height
                    marginLeft =
                        (youtubeImageView.layoutParams as FrameLayout.LayoutParams).leftMargin
                    marginTop =
                        (youtubeImageView.layoutParams as FrameLayout.LayoutParams).topMargin
                }
            })
            addUpdateListener {
                val schedule = it.animatedValue as Float
                youtubeImageView.apply {
                    layoutParams = (layoutParams as? FrameLayout.LayoutParams)?.apply {
                        leftMargin = (marginLeft - schedule * 5 * if (isLeft) {
                            dp_18
                        } else {
                            -dp_18
                        }).toInt()
                        topMargin = (marginTop - schedule * dp_27).toInt()
                        width = (w + w * schedule).toInt()
                        height = (h + h * schedule).toInt()
                    }
                }
            }
        }
    }

    private fun youtubeAnima4(): ValueAnimator {
        var w = 0
        var h = 0
        var marginLeft = 0
        var marginTop = 0
        return ValueAnimator.ofFloat(1f, 0f).apply {
            addListener(object : DefaultAnimatorListener() {
                override fun onAnimationStart(animation: Animator?) {
                    w = youtubeImageView.width
                    h = youtubeImageView.height
                    marginLeft =
                        (youtubeImageView.layoutParams as FrameLayout.LayoutParams).leftMargin
                    marginTop =
                        (youtubeImageView.layoutParams as FrameLayout.LayoutParams).topMargin
                }
            })
            duration = 1000
            addUpdateListener {
                val schedule = it.animatedValue as Float
                youtubeImageView.apply {
                    alpha = schedule
                    layoutParams = (layoutParams as? FrameLayout.LayoutParams)?.apply {
                        leftMargin =
                            (youtubeHorizontalMargin + (marginLeft - youtubeHorizontalMargin) * schedule).toInt()
                        topMargin =
                            (youtubeVerticalMargin + (marginTop - youtubeVerticalMargin) * schedule).toInt()
                        width = (dp_80 + dp_80 * schedule).toInt()
                        height = (dp_18 + dp_18 * schedule).toInt()
                    }
                }
            }
        }
    }


    /**
     * site icon 动画
     */
    private fun startSiteGuidance() {
        addView(siteImageView)
        oneZoom(1.2f)
        postDelayed({
            AnimatorSet().apply {
                play(oneZoom(0.8f)).after(oneZoom(1.3f)).before(oneZoom(1.2f))
            }.start()
        },allTime - 3 * 2 * scaleTime)
    }

    /**
     * 根据当前的缩放比例重新计算 site icon 的 width、height、leftMargin、rightMargin
     */
    private fun scaleSite(scale: Float) {
        siteImageView.apply {
            layoutParams = (layoutParams as? FrameLayout.LayoutParams)?.apply {
                leftMargin = siteLeftMargin - (dp_36 * (scale - 1) / 2).toInt()
                topMargin = siteTopMargin - (dp_36 * (scale - 1) / 2).toInt()
                width = (dp_36 * scale).toInt()
                height = (dp_36 * scale).toInt()
            }
        }
    }

    /**
     * 完成一次缩放动画
     */
    private fun oneZoom(scale: Float): ValueAnimator {
        return ValueAnimator.ofFloat(1f, scale).apply {
            duration = scaleTime
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener {
                scaleSite(it.animatedValue as Float)
            }
        }
    }
}

open class DefaultAnimatorListener : Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }

}
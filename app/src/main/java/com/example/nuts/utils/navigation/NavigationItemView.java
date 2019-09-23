package com.example.nuts.utils.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.nuts.MainActivity;
import com.example.nuts.R;

public class NavigationItemView extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private static final int f4983a = C1768a.CENTER.m6177a();
    /* renamed from: b */
    private C1769a f4984b;
    /* renamed from: c */
    private AppCompatImageView f4985c;
    /* renamed from: d */
    private TextView f4986d;
    /* renamed from: e */
    private float f4987e;
    /* renamed from: f */
    private float f4988f;
    /* renamed from: g */
    private int f4989g;
    /* renamed from: h */
    private float f4990h;
    /* renamed from: i */
    private int f4991i;
    /* renamed from: j */
    private float f4992j;
    /* renamed from: k */
    private float f4993k;
    /* renamed from: l */
    private float f4994l;
    /* renamed from: m */
    private float f4995m;
    /* renamed from: n */
    private float f4996n;
    /* renamed from: o */
    private float f4997o;
    /* renamed from: p */
    private MainActivity f4998p;

    public NavigationItemView(Context context) {
        super(context);
        m6178a(context);
    }

    public NavigationItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6179a(context, attributeSet);
        m6178a(context);
    }

    public NavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6179a(context, attributeSet);
        m6178a(context);
    }

    /* renamed from: a */
    void m6179a(Context context, AttributeSet attributeSet) {
        //context = context.obtainStyledAttributes(attributeSet, R.styleable.NavigationItem);
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.amir);

        this.f4987e = a.getDimension(R.styleable.amir_nvmTitleHeight, 1.0f);
        this.f4988f = a.getDimension(R.styleable.amir_nvmTitleWith, 1.0f);

        this.f4989g = C1768a.m6176a(a.getInt(R.styleable.amir_nvmTitleGravity, f4983a)).m6177a();
        this.f4990h = (float) a.getDimensionPixelSize(R.styleable.amir_nvmTitleSize, 22);
        this.f4991i = a.getColor(R.styleable.amir_nvmTitleColor, -16777216);

        this.f4996n = a.getDimension(R.styleable.amir_nvmIconWith, 1.0f);
        this.f4997o = a.getDimension(R.styleable.amir_nvmIconHeight, 1.0f);
        this.f4992j = a.getDimension(R.styleable.amir_nvmTitleMarginTop, 0.0f);
        this.f4993k = a.getDimension(R.styleable.amir_nvmTitleMarginBottom, 0.0f);
        this.f4994l = a.getDimension(R.styleable.amir_nvmTitleMarginRight, 0.0f);
        this.f4995m = a.getDimension(R.styleable.amir_nvmTitleMarginLeft, 0.0f);
        this.f4984b = C1769a.m6180a(a.getInt(R.styleable.amir_nvmType, 12));
        a.recycle();
    }

    /* renamed from: a */
    private void m6178a(Context context) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        this.f4985c = new AppCompatImageView(context);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1f;
        this.f4985c.setLayoutParams(layoutParams);
        addView(this.f4985c);
        this.f4986d = new TextView(context);
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 5f;
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        this.f4986d.setLayoutParams(layoutParams);
        this.f4986d.setShadowLayer(5, 2, 0, Color.parseColor("#50A8A8A8"));
        //this.f4986d.setPadding((int) this.f4995m, (int) this.f4992j, (int) this.f4994l, (int) this.f4993k);
        this.f4986d.setTextColor(this.f4991i);
        this.f4986d.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        this.f4986d.setTextSize(0, this.f4990h);
        this.f4986d.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, R.style.body1));
        addView(this.f4986d);
        this.f4985c.setImageResource(this.f4984b.m6182b());
        this.f4986d.setText(this.f4984b.m6181a());
        if (!isInEditMode()) {
            try {
                setOnClickListener(this);
                this.f4998p = (MainActivity) context;
            } catch (Exception e) {
            }
           /* if (context instanceof C1770b) {
                this.f4998p = (C1770b) context;
                setOnClickListener(this);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" is not instance of hamgam.kaarix.features.main.navigation.OnNavigationItemSelectListener...!");
            throw new RuntimeException(stringBuilder.toString());*/
        }
    }

    public C1769a getNavItem() {
        return this.f4984b;
    }

    public void setNavItem(C1769a c1769a) {
        this.f4984b = c1769a;
        requestLayout();
    }

    public void onClick(View view) {
        if (this.f4998p != null) {
            this.f4998p.mo2351a(this.f4984b);
        }
    }

    /* renamed from: hamgam.kaarix.features.main.navigation.NavigationItemView$a */
    public enum C1768a {
        LEFT(3),
        CENTER(17),
        RIGHT(5);

        /* renamed from: d */
        private int f4982d;

        private C1768a(int i) {
            this.f4982d = i;
        }

        /* renamed from: a */
        public static C1768a m6176a(int i) {
            if (i == 3) {
                return LEFT;
            }
            if (i == 5) {
                return RIGHT;
            }
            if (i != 17) {
                return LEFT;
            }
            return CENTER;
        }

        /* renamed from: a */
        public int m6177a() {
            return this.f4982d;
        }
    }
}

package com.example.nuts.utils.navigation;


import com.example.nuts.R;

/* compiled from: NavigationItem */
/* renamed from: hamgam.kaarix.features.main.navigation.a */
public enum C1769a {
    //WALLET("WALLET", R.string.navigation_wallet, R.color.white, R.drawable.nav_wallet, 133),
    //STATISTIC("STATISTIC", R.string.navigation_visit_statistic, R.color.white, R.drawable.nav_statistic, 253),
    EXIT("EXIT", R.string.navigation_exit, R.color.white, R.drawable.nav_exit, 283),
    /*WAY_REPLY("WAY_REPLY", R.string.navigation_call_answer, R.color.white, R.drawable.nav_way_reply, 223),
    CONTACTS("CONTACTS", R.string.navigation_Contacts, R.color.white, R.drawable.nav_contacts, 203),*/
    //FAVORITE("FAVORITE", R.string.navigation_favorite, R.color.white, R.drawable.nav_bookmark, 123),
    CONTACT_US("CONTACT_US", R.string.navigation_support_contact_us, R.color.white, R.drawable.nav_support, 153),
    ABOUT_US("ABOUT_US", R.string.navigation_about_us, R.color.white, R.drawable.nav_about_us, 143),
    NOTIFICATION("NOTIFICATION", R.string.navigation_notification, R.color.white, R.drawable.nav_notification, 263);
    //GUIDE("GUIDE", R.string.navigation_guide, R.color.white, R.drawable.nav_guide, 293),
    //TRANSACTION("TRANSACTION", R.string.navigation_transaction, R.color.white, R.drawable.nave_transaction, 300);

    /* renamed from: m */
    private int f5012m;
    /* renamed from: n */
    private int f5013n;
    /* renamed from: o */
    private int f5014o;
    /* renamed from: p */
    private int f5015p;
    /* renamed from: q */
    private String f5016q;

    private C1769a(String str, int i, int i2, int i3, int i4) {
        this.f5012m = i;
        this.f5013n = i2;
        this.f5014o = i3;
        this.f5015p = i4;
        this.f5016q = str;
    }

    /* renamed from: a */
    public static C1769a m6180a(int i) {
        for (C1769a c1769a : C1769a.values()) {
            if (i == c1769a.f5015p) {
                return c1769a;
            }
        }
        return ABOUT_US;
    }

    /* renamed from: a */
    public int m6181a() {
        return this.f5012m;
    }

    /* renamed from: b */
    public int m6182b() {
        return this.f5014o;
    }

    /* renamed from: c */
    public String m6183c() {
        return this.f5016q;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst noconv 
// Source File Name:   SourceFile

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class avg extends avh
{

    private static final bjl b = new bjl("textures/misc/vignette.png");
    private static final bjl c = new bjl("textures/gui/widgets.png");
    private static final bjl d = new bjl("textures/misc/pumpkinblur.png");
    private static final bgt e = new bgt();
    private final Random f = new Random();
    private final ats g;
    private final aur h;
    private int i;
    private String j;
    private int o;
    private boolean p;
    public float ipeer_a_rename; // ...
    private int q;
    private yd r;

    public avg(ats ats1)
    {
        j = "";
        ipeer_a_rename = 1.0F;
        g = ats1;
        h = new aur(ats1);
    }

    public void a(float f1, boolean flag, int k, int l)
    {
        awc awc1 = new awc(g.u, g.d, g.e);
        int i1 = awc1.a();
        int j1 = awc1.b();
        avf avf1 = g.l;
        g.p.c();
        GL11.glEnable(3042);
        if(ats.s())
        {
            a(g.h.d(f1), i1, j1);
        } else
        {
            GL11.glBlendFunc(770, 771);
        }
        yd yd1 = g.h.bn.f(3);
        if(g.u.aa == 0 && yd1 != null && yd1.d == aqw.bf.cF)
        {
            b(i1, j1);
        }
        if(!g.h.a(nh.k))
        {
            float f2 = g.h.bO + (g.h.bN - g.h.bO) * f1;
            if(f2 > 0.0F)
            {
                b(f2, i1, j1);
            }
        }
        if(!g.c.a())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            g.J().a(c);
            uc uc1 = g.h.bn;
            n = -90F;
            b(i1 / 2 - 91, j1 - 22, 0, 0, 182, 22);
            b((i1 / 2 - 91 - 1) + uc1.c * 20, j1 - 22 - 1, 0, 22, 24, 22);
            g.J().a(m);
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            b(i1 / 2 - 7, j1 / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            g.C.a("bossHealth");
            d();
            g.C.b();
            if(g.c.b())
            {
                a(i1, j1);
            }
            GL11.glDisable(3042);
            g.C.a("actionBar");
            GL11.glEnable(32826);
            atq.c();
            for(int i2 = 0; i2 < 9; i2++)
            {
                int k2 = (i1 / 2 - 90) + i2 * 20 + 2;
                int j3 = j1 - 16 - 3;
                a(i2, k2, j3, f1);
            }

            atq.a();
            GL11.glDisable(32826);
            g.C.b();
        }
        if(g.h.bD() > 0)
        {
            g.C.a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int k1 = g.h.bD();
            float f3 = (float)k1 / 100F;
            if(f3 > 1.0F)
            {
                f3 = 1.0F - (float)(k1 - 100) / 10F;
            }
            int l2 = (int)(220F * f3) << 24 | 0x101020;
            a(0, 0, i1, j1, l2);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            g.C.b();
        }
        int l1 = 0xffffff;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int j2 = i1 / 2 - 91;
        if(g.h.bM())
        {
            g.C.a("jumpBar");
            g.J().a(avh.m);
            float f4 = g.h.bN();
            char c1 = '\266';
            int k4 = (int)(f4 * (float)(c1 + 1));
            int i6 = (j1 - 32) + 3;
            b(j2, i6, 0, 84, c1, 5);
            if(k4 > 0)
            {
                b(j2, i6, 0, 89, k4, 5);
            }
            g.C.b();
        } else
        if(g.c.f())
        {
            g.C.a("expBar");
            g.J().a(avh.m);
            int i3 = g.h.bG();
            if(i3 > 0)
            {
                char c2 = '\266';
                int l4 = (int)(g.h.bJ * (float)(c2 + 1));
                int j6 = (j1 - 32) + 3;
                b(j2, j6, 0, 64, c2, 5);
                if(l4 > 0)
                {
                    b(j2, j6, 0, 69, l4, 5);
                }
            }
            g.C.b();
            if(g.h.bH > 0)
            {
                g.C.a("expLevel");
                boolean flag1 = false;
                int i5 = flag1 ? 0xffffff : 0x80ff20;
                String s2 = (new StringBuilder()).append("").append(g.h.bH).toString();
                int i7 = (i1 - avf1.a(s2)) / 2;
                int k7 = j1 - 31 - 4;
                boolean flag2 = false;
                avf1.b(s2, i7 + 1, k7, 0);
                avf1.b(s2, i7 - 1, k7, 0);
                avf1.b(s2, i7, k7 + 1, 0);
                avf1.b(s2, i7, k7 - 1, 0);
                avf1.b(s2, i7, k7, i5);
                g.C.b();
            }
        }
        if(g.u.D)
        {
            g.C.a("toolHighlight");
            if(q > 0 && r != null)
            {
                String s = r.s();
                int k3 = (i1 - avf1.a(s)) / 2;
                int j5 = j1 - 59;
                if(!g.c.b())
                {
                    j5 += 14;
                }
                int k6 = (int)(((float)q * 256F) / 10F);
                if(k6 > 255)
                {
                    k6 = 255;
                }
                if(k6 > 0)
                {
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    avf1.a(s, k3, j5, 0xffffff + (k6 << 24));
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            g.C.b();
        }
        if(g.p())
        {
            g.C.a("demo");
            String s1 = "";
            if(g.f.I() >= 0x1d6b4L)
            {
                s1 = bjy.a("demo.demoExpired");
            } else
            {
                s1 = bjy.a("demo.remainingTime", new Object[] {
                    lz.a((int)(0x1d6b4L - g.f.I()))
                });
            }
            int i4 = avf1.a(s1);
            avf1.a(s1, i1 - i4 - 10, 5, 0xffffff);
            g.C.b();
        }
        if (!WMLL.i.useML)
        	WMLL.i.updategui(g, f1, this);
        if(g.u.ab)
        {
            g.C.a("debug");
            GL11.glPushMatrix();
            avf1.a((new StringBuilder()).append("Minecraft 1.6.2 (").append(g.E).append(")").toString(), 2, 2, 0xffffff);
            avf1.a(g.l(), 2, 12, 0xffffff);
            avf1.a(g.m(), 2, 22, 0xffffff);
            avf1.a(g.o(), 2, 32, 0xffffff);
            avf1.a(g.n(), 2, 42, 0xffffff);
            long l3 = Runtime.getRuntime().maxMemory();
            long l5 = Runtime.getRuntime().totalMemory();
            long l7 = Runtime.getRuntime().freeMemory();
            long l8 = l5 - l7;
            String s3 = (new StringBuilder()).append("Used memory: ").append((l8 * 100L) / l3).append("% (").append(l8 / 1024L / 1024L).append("MB) of ").append(l3 / 1024L / 1024L).append("MB").toString();
            int i9 = 0xe0e0e0;
            b(avf1, s3, i1 - avf1.a(s3) - 2, 2, 0xe0e0e0);
            s3 = (new StringBuilder()).append("Allocated memory: ").append((l5 * 100L) / l3).append("% (").append(l5 / 1024L / 1024L).append("MB)").toString();
            b(avf1, s3, i1 - avf1.a(s3) - 2, 12, 0xe0e0e0);
            int k9 = lr.c(g.h.u);
            int i10 = lr.c(g.h.v);
            int k10 = lr.c(g.h.w);
            b(avf1, String.format("x: %.5f (%d) // c: %d (%d)", new Object[] {
                Double.valueOf(g.h.u), Integer.valueOf(k9), Integer.valueOf(k9 >> 4), Integer.valueOf(k9 & 0xf)
            }), 2, 64, 0xe0e0e0);
            b(avf1, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] {
                Double.valueOf(g.h.E.b), Double.valueOf(g.h.v)
            }), 2, 72, 0xe0e0e0);
            b(avf1, String.format("z: %.5f (%d) // c: %d (%d)", new Object[] {
                Double.valueOf(g.h.w), Integer.valueOf(k10), Integer.valueOf(k10 >> 4), Integer.valueOf(k10 & 0xf)
            }), 2, 80, 0xe0e0e0);
            int l10 = lr.c((double)((g.h.A * 4F) / 360F) + 0.5D) & 3;
            b(avf1, (new StringBuilder()).append("f: ").append(l10).append(" (").append(WMLL.i.getPlayerDirection(l10).toUpperCase()).append(") / ").append(lr.g(g.h.A)).toString(), 2, 88, 0xe0e0e0);
            if(g.f != null && g.f.f(k9, i10, k10))
            {
                adq adq1 = g.f.d(k9, k10);
                b(avf1, (new StringBuilder()).append("lc: ").append(adq1.h() + 15).append(" b: ").append(adq1.a(k9 & 0xf, k10 & 0xf, g.f.u()).y).append(" bl: ").append(adq1.a(acg.b, k9 & 0xf, i10, k10 & 0xf)).append(" sl: ").append(adq1.a(acg.a, k9 & 0xf, i10, k10 & 0xf)).append(" rl: ").append(adq1.c(k9 & 0xf, i10, k10 & 0xf, 0)).toString(), 2, 96, 0xe0e0e0);
            }
            b(avf1, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[] {
                Float.valueOf(g.h.bG.b()), Float.valueOf(g.h.bG.a()), Boolean.valueOf(g.h.F), Integer.valueOf(g.f.f(k9, k10))
            }), 2, 104, 0xe0e0e0);
            GL11.glPopMatrix();
            g.C.b();
        }
        if(o > 0)
        {
            g.C.a("overlayMessage");
            float f5 = (float)o - f1;
            int j4 = (int)((f5 * 255F) / 20F);
            if(j4 > 255)
            {
                j4 = 255;
            }
            if(j4 > 8)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(i1 / 2, j1 - 68, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int k5 = 0xffffff;
                if(p)
                {
                    k5 = Color.HSBtoRGB(f5 / 50F, 0.7F, 0.6F) & 0xffffff;
                }
                avf1.b(j, -avf1.a(j) / 2, -4, k5 + (j4 << 24 & 0xff000000));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            g.C.b();
        }
        atb atb1 = g.f.X().a(1);
        if(atb1 != null)
        {
            a(atb1, j1, i1, avf1);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, j1 - 48, 0.0F);
        g.C.a("chat");
        h.a(i);
        g.C.b();
        GL11.glPopMatrix();
        atb1 = g.f.X().a(0);
        if(g.u.T.e && (!g.A() || g.h.a.c.size() > 1 || atb1 != null))
        {
            g.C.a("playerList");
            bct bct1 = g.h.a;
            java.util.List list = bct1.c;
            int l6 = bct1.d;
            int j7 = l6;
            int i8 = 1;
            for(; j7 > 20; j7 = ((l6 + i8) - 1) / i8)
            {
                i8++;
            }

            int j8 = 300 / i8;
            if(j8 > 150)
            {
                j8 = 150;
            }
            int k8 = (i1 - i8 * j8) / 2;
            byte byte0 = 10;
            a(k8 - 1, byte0 - 1, k8 + j8 * i8, byte0 + 9 * j7, 0x80000000);
            for(int j9 = 0; j9 < l6; j9++)
            {
                int l9 = k8 + (j9 % i8) * j8;
                int j10 = byte0 + (j9 / i8) * 9;
                a(l9, j10, (l9 + j8) - 1, j10 + 8, 0x20ffffff);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);
                if(j9 >= list.size())
                {
                    continue;
                }
                bdg bdg1 = (bdg)list.get(j9);
                atc atc1 = g.f.X().i(bdg1.a);
                String s4 = atc.a(atc1, bdg1.a);
                avf1.a(s4, l9, j10, 0xffffff);
                if(atb1 != null)
                {
                    int i11 = l9 + avf1.a(s4) + 5;
                    int k11 = (l9 + j8) - 12 - 5;
                    if(k11 - i11 > 5)
                    {
                        atd atd1 = atb1.a().a(bdg1.a, atb1);
                        String s5 = (new StringBuilder()).append(a.o).append("").append(atd1.c()).toString();
                        avf1.a(s5, k11 - avf1.a(s5), j10, 0xffffff);
                    }
                }
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                g.J().a(m);
                int j11 = 0;
                byte byte1 = 0;
                if(bdg1.b < 0)
                {
                    byte1 = 5;
                } else
                if(bdg1.b < 150)
                {
                    byte1 = 0;
                } else
                if(bdg1.b < 300)
                {
                    byte1 = 1;
                } else
                if(bdg1.b < 600)
                {
                    byte1 = 2;
                } else
                if(bdg1.b < 1000)
                {
                    byte1 = 3;
                } else
                {
                    byte1 = 4;
                }
                n += 100F;
                b((l9 + j8) - 12, j10, 0 + j11 * 10, 176 + byte1 * 8, 10, 8);
                n -= 100F;
            }

        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void a(atb atb1, int k, int l, avf avf1)
    {
        atg atg1 = atb1.a();
        Collection collection = atg1.i(atb1);
        if(collection.size() > 15)
        {
            return;
        }
        int i1 = avf1.a(atb1.d());
        for(Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            atd atd1 = (atd)iterator.next();
            atc atc1 = atg1.i(atd1.e());
            String s = (new StringBuilder()).append(atc.a(atc1, atd1.e())).append(": ").append(a.m).append(atd1.c()).toString();
            i1 = Math.max(i1, avf1.a(s));
        }

        int j1 = collection.size() * avf1.a;
        int k1 = k / 2 + j1 / 3;
        byte byte0 = 3;
        int l1 = l - i1 - byte0;
        int i2 = 0;
        Iterator iterator1 = collection.iterator();
        do
        {
            if(!iterator1.hasNext())
            {
                break;
            }
            atd atd2 = (atd)iterator1.next();
            i2++;
            atc atc2 = atg1.i(atd2.e());
            String s1 = atc.a(atc2, atd2.e());
            String s2 = (new StringBuilder()).append(a.m).append("").append(atd2.c()).toString();
            int j2 = l1;
            int k2 = k1 - i2 * avf1.a;
            int l2 = (l - byte0) + 2;
            a(j2 - 2, k2, l2, k2 + avf1.a, 0x50000000);
            avf1.b(s1, j2, k2, 0x20ffffff);
            avf1.b(s2, l2 - avf1.a(s2), k2, 0x20ffffff);
            if(i2 == collection.size())
            {
                String s3 = atb1.d();
                a(j2 - 2, k2 - avf1.a - 1, l2, k2 - 1, 0x60000000);
                a(j2 - 2, k2 - 1, l2, k2, 0x50000000);
                avf1.b(s3, (j2 + i1 / 2) - avf1.a(s3) / 2, k2 - avf1.a, 0x20ffffff);
            }
        } while(true);
    }

    private void a(int k, int l)
    {
        boolean flag = (g.h.af / 3) % 2 == 1;
        if(g.h.af < 10)
        {
            flag = false;
        }
        int i1 = lr.f(g.h.aM());
        int j1 = lr.f(g.h.ax);
        f.setSeed(i * 0x4c627);
        boolean flag1 = false;
        uw uw1 = g.h.bH();
        int k1 = uw1.a();
        int l1 = uw1.b();
        or or1 = g.h.a(to.a);
        int i2 = k / 2 - 91;
        int j2 = k / 2 + 91;
        int k2 = l - 39;
        float f1 = (float)or1.e();
        float f2 = g.h.bm();
        int l2 = lr.f((f1 + f2) / 2.0F / 10F);
        int i3 = Math.max(10 - (l2 - 2), 3);
        int j3 = k2 - (l2 - 1) * i3 - 10;
        float f3 = f2;
        int k3 = g.h.aP();
        int l3 = -1;
        if(g.h.a(nh.l))
        {
            l3 = i % lr.f(f1 + 5F);
        }
        g.C.a("armor");
        for(int i4 = 0; i4 < 10; i4++)
        {
            if(k3 <= 0)
            {
                continue;
            }
            int k4 = i2 + i4 * 8;
            if(i4 * 2 + 1 < k3)
            {
                b(k4, j3, 34, 9, 9, 9);
            }
            if(i4 * 2 + 1 == k3)
            {
                b(k4, j3, 25, 9, 9, 9);
            }
            if(i4 * 2 + 1 > k3)
            {
                b(k4, j3, 16, 9, 9, 9);
            }
        }

        g.C.c("health");
        for(int j4 = lr.f((f1 + f2) / 2.0F) - 1; j4 >= 0; j4--)
        {
            int l4 = 16;
            if(g.h.a(nh.u))
            {
                l4 += 36;
            } else
            if(g.h.a(nh.v))
            {
                l4 += 72;
            }
            int k5 = 0;
            if(flag)
            {
                k5 = 1;
            }
            int k6 = lr.f((float)(j4 + 1) / 10F) - 1;
            int j7 = i2 + (j4 % 10) * 8;
            int i8 = k2 - k6 * i3;
            if(i1 <= 4)
            {
                i8 += f.nextInt(2);
            }
            if(j4 == l3)
            {
                i8 -= 2;
            }
            byte byte1 = 0;
            if(g.f.N().t())
            {
                byte1 = 5;
            }
            b(j7, i8, 16 + k5 * 9, 9 * byte1, 9, 9);
            if(flag)
            {
                if(j4 * 2 + 1 < j1)
                {
                    b(j7, i8, l4 + 54, 9 * byte1, 9, 9);
                }
                if(j4 * 2 + 1 == j1)
                {
                    b(j7, i8, l4 + 63, 9 * byte1, 9, 9);
                }
            }
            if(f3 > 0.0F)
            {
                if(f3 == f2 && f2 % 2.0F == 1.0F)
                {
                    b(j7, i8, l4 + 153, 9 * byte1, 9, 9);
                } else
                {
                    b(j7, i8, l4 + 144, 9 * byte1, 9, 9);
                }
                f3 -= 2.0F;
                continue;
            }
            if(j4 * 2 + 1 < i1)
            {
                b(j7, i8, l4 + 36, 9 * byte1, 9, 9);
            }
            if(j4 * 2 + 1 == i1)
            {
                b(j7, i8, l4 + 45, 9 * byte1, 9, 9);
            }
        }

        nm nm1 = g.h.o;
        if(nm1 == null)
        {
            g.C.c("food");
            for(int i5 = 0; i5 < 10; i5++)
            {
                int l5 = k2;
                int l6 = 16;
                byte byte0 = 0;
                if(g.h.a(nh.s))
                {
                    l6 += 36;
                    byte0 = 13;
                }
                if(g.h.bH().e() <= 0.0F && i % (k1 * 3 + 1) == 0)
                {
                    l5 += f.nextInt(3) - 1;
                }
                if(flag1)
                {
                    byte0 = 1;
                }
                int j8 = j2 - i5 * 8 - 9;
                b(j8, l5, 16 + byte0 * 9, 27, 9, 9);
                if(flag1)
                {
                    if(i5 * 2 + 1 < l1)
                    {
                        b(j8, l5, l6 + 54, 27, 9, 9);
                    }
                    if(i5 * 2 + 1 == l1)
                    {
                        b(j8, l5, l6 + 63, 27, 9, 9);
                    }
                }
                if(i5 * 2 + 1 < k1)
                {
                    b(j8, l5, l6 + 36, 27, 9, 9);
                }
                if(i5 * 2 + 1 == k1)
                {
                    b(j8, l5, l6 + 45, 27, 9, 9);
                }
            }

        } else
        if(nm1 instanceof oe)
        {
            g.C.c("mountHealth");
            oe oe1 = (oe)nm1;
            int i6 = (int)Math.ceil(oe1.aM());
            float f4 = oe1.aS();
            int k7 = (int)(f4 + 0.5F) / 2;
            if(k7 > 30)
            {
                k7 = 30;
            }
            int k8 = k2;
            for(int l8 = 0; k7 > 0; l8 += 20)
            {
                int i9 = Math.min(k7, 10);
                k7 -= i9;
                for(int j9 = 0; j9 < i9; j9++)
                {
                    byte byte2 = 52;
                    int k9 = 0;
                    if(flag1)
                    {
                        k9 = 1;
                    }
                    int l9 = j2 - j9 * 8 - 9;
                    b(l9, k8, byte2 + k9 * 9, 9, 9, 9);
                    if(j9 * 2 + 1 + l8 < i6)
                    {
                        b(l9, k8, byte2 + 36, 9, 9, 9);
                    }
                    if(j9 * 2 + 1 + l8 == i6)
                    {
                        b(l9, k8, byte2 + 45, 9, 9, 9);
                    }
                }

                k8 -= 10;
            }

        }
        g.C.c("air");
        if(g.h.a(ajz.h))
        {
            int j5 = g.h.ak();
            int j6 = lr.f(((double)(j5 - 2) * 10D) / 300D);
            int i7 = lr.f(((double)j5 * 10D) / 300D) - j6;
            for(int l7 = 0; l7 < j6 + i7; l7++)
            {
                if(l7 < j6)
                {
                    b(j2 - l7 * 8 - 9, j3, 16, 18, 9, 9);
                } else
                {
                    b(j2 - l7 * 8 - 9, j3, 25, 18, 9, 9);
                }
            }

        }
        g.C.b();
    }

    private void d()
    {
        if(bew.c == null || bew.b <= 0)
        {
            return;
        }
        bew.b--;
        avf avf1 = g.l;
        awc awc1 = new awc(g.u, g.d, g.e);
        int k = awc1.a();
        char c1 = '\266';
        int l = k / 2 - c1 / 2;
        int i1 = (int)(bew.a * (float)(c1 + 1));
        byte byte0 = 12;
        b(l, byte0, 0, 74, c1, 5);
        b(l, byte0, 0, 74, c1, 5);
        if(i1 > 0)
        {
            b(l, byte0, 0, 79, i1, 5);
        }
        String s = bew.c;
        avf1.a(s, k / 2 - avf1.a(s) / 2, byte0 - 10, 0xffffff);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        g.J().a(m);
    }

    private void b(int k, int l)
    {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        g.J().a(d);
        bfn bfn1 = bfn.a;
        bfn1.b();
        bfn1.a(0.0D, l, -90D, 0.0D, 1.0D);
        bfn1.a(k, l, -90D, 1.0D, 1.0D);
        bfn1.a(k, 0.0D, -90D, 1.0D, 0.0D);
        bfn1.a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        bfn1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(float f1, int k, int l)
    {
        f1 = 1.0F - f1;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        ipeer_a_rename += (double)(f1 - ipeer_a_rename) * 0.01D;
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(ipeer_a_rename, ipeer_a_rename, ipeer_a_rename, 1.0F);
        g.J().a(b);
        bfn bfn1 = bfn.a;
        bfn1.b();
        bfn1.a(0.0D, l, -90D, 0.0D, 1.0D);
        bfn1.a(k, l, -90D, 1.0D, 1.0D);
        bfn1.a(k, 0.0D, -90D, 1.0D, 0.0D);
        bfn1.a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        bfn1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void b(float f1, int k, int l)
    {
        if(f1 < 1.0F)
        {
            f1 *= f1;
            f1 *= f1;
            f1 = f1 * 0.8F + 0.2F;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
        mr mr1 = aqw.bj.m(1);
        g.J().a(bih.b);
        float f2 = mr1.c();
        float f3 = mr1.e();
        float f4 = mr1.d();
        float f5 = mr1.f();
        bfn bfn1 = bfn.a;
        bfn1.b();
        bfn1.a(0.0D, l, -90D, f2, f5);
        bfn1.a(k, l, -90D, f4, f5);
        bfn1.a(k, 0.0D, -90D, f4, f3);
        bfn1.a(0.0D, 0.0D, -90D, f2, f3);
        bfn1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(int k, int l, int i1, float f1)
    {
        yd yd1 = g.h.bn.a[k];
        if(yd1 == null)
        {
            return;
        }
        float f2 = (float)yd1.c - f1;
        if(f2 > 0.0F)
        {
            GL11.glPushMatrix();
            float f3 = 1.0F + f2 / 5F;
            GL11.glTranslatef(l + 8, i1 + 12, 0.0F);
            GL11.glScalef(1.0F / f3, (f3 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(l + 8), -(i1 + 12), 0.0F);
        }
        e.b(g.l, g.J(), yd1, l, i1);
        if(f2 > 0.0F)
        {
            GL11.glPopMatrix();
        }
        e.c(g.l, g.J(), yd1, l, i1);
    }

    public void a()
    {
        if(o > 0)
        {
            o--;
        }
        i++;
        if(g.h != null)
        {
            yd yd1 = g.h.bn.h();
            if(yd1 == null)
            {
                q = 0;
            } else
            if(r == null || yd1.d != r.d || !yd.a(yd1, r) || !yd1.g() && yd1.k() != r.k())
            {
                q = 40;
            } else
            if(q > 0)
            {
                q--;
            }
            r = yd1;
        }
    }

    public void a(String s)
    {
        a((new StringBuilder()).append("Now playing: ").append(s).toString(), true);
    }

    public void a(String s, boolean flag)
    {
        j = s;
        o = 60;
        p = flag;
    }

    public aur b()
    {
        return h;
    }

    public int c()
    {
        return i;
    }

}

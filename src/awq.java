// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst noconv 
// Source File Name:   SourceFile

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class awq extends awr
{

    private static final bhc b = new bhc();
    private final Random c = new Random();
    private final Minecraft d;
    private final awb e;
    private int f;
    private String g;
    private int h;
    private boolean i;
    public float ipeer_a_rename;
    private int k;
    private wg l;

    public awq(Minecraft minecraft)
    {
        f = 0;
        g = "";
        h = 0;
        i = false;
        ipeer_a_rename = 1.0F;
        d = minecraft;
        e = new awb(minecraft);
    }

    public void a(float f1, boolean flag, int j, int i1)
    {
        axm axm1 = new axm(d.z, d.c, d.d);
        int j1 = axm1.a();
        int k1 = axm1.b();
        awp awp1 = d.q;
        d.u.c();
        GL11.glEnable(3042);
        if(Minecraft.t())
        {
            a(d.g.c(f1), j1, k1);
        } else
        {
            GL11.glBlendFunc(770, 771);
        }
        wg wg1 = d.g.bK.f(3);
        if(d.z.aa == 0 && wg1 != null && wg1.c == aou.be.cz)
        {
            a(j1, k1);
        }
        if(!d.g.a(mk.k))
        {
            float f2 = d.g.cl + (d.g.j - d.g.cl) * f1;
            if(f2 > 0.0F)
            {
                b(f2, j1, k1);
            }
        }
        if(!d.b.a())
        {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            d.p.b("/gui/gui.png");
            si si1 = d.g.bK;
            this.j = -90F;
            b(j1 / 2 - 91, k1 - 22, 0, 0, 182, 22);
            b((j1 / 2 - 91 - 1) + si1.c * 20, k1 - 22 - 1, 0, 22, 24, 22);
            d.p.b("/gui/icons.png");
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            b(j1 / 2 - 7, k1 / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            boolean flag1 = (d.g.af / 3) % 2 == 1;
            if(d.g.af < 10)
            {
                flag1 = false;
            }
            int i2 = d.g.aX();
            int l3 = d.g.aT;
            c.setSeed(f * 0x4c627);
            boolean flag3 = false;
            tc tc1 = d.g.cl();
            int j6 = tc1.a();
            int l6 = tc1.b();
            d.J.a("bossHealth");
            d();
            d.J.b();
            if(d.b.b())
            {
                int j7 = j1 / 2 - 91;
                int j8 = j1 / 2 + 91;
                d.J.a("expBar");
                int l8 = d.g.ck();
                if(l8 > 0)
                {
                    char c1 = '\266';
                    int j10 = (int)(d.g.ch * (float)(c1 + 1));
                    int j11 = (k1 - 32) + 3;
                    b(j7, j11, 0, 64, c1, 5);
                    if(j10 > 0)
                    {
                        b(j7, j11, 0, 69, j10, 5);
                    }
                }
                int k9 = k1 - 39;
                int k10 = k9 - 10;
                int k11 = d.g.aZ();
                int i12 = -1;
                if(d.g.a(mk.l))
                {
                    i12 = f % 25;
                }
                d.J.c("healthArmor");
                for(int k12 = 0; k12 < 10; k12++)
                {
                    if(k11 > 0)
                    {
                        int j13 = j7 + k12 * 8;
                        if(k12 * 2 + 1 < k11)
                        {
                            b(j13, k10, 34, 9, 9, 9);
                        }
                        if(k12 * 2 + 1 == k11)
                        {
                            b(j13, k10, 25, 9, 9, 9);
                        }
                        if(k12 * 2 + 1 > k11)
                        {
                            b(j13, k10, 16, 9, 9, 9);
                        }
                    }
                    int k13 = 16;
                    if(d.g.a(mk.u))
                    {
                        k13 += 36;
                    } else
                    if(d.g.a(mk.v))
                    {
                        k13 += 72;
                    }
                    int l14 = 0;
                    if(flag1)
                    {
                        l14 = 1;
                    }
                    int l15 = j7 + k12 * 8;
                    int j16 = k9;
                    if(i2 <= 4)
                    {
                        j16 += c.nextInt(2);
                    }
                    if(k12 == i12)
                    {
                        j16 -= 2;
                    }
                    byte byte3 = 0;
                    if(d.e.L().t())
                    {
                        byte3 = 5;
                    }
                    b(l15, j16, 16 + l14 * 9, 9 * byte3, 9, 9);
                    if(flag1)
                    {
                        if(k12 * 2 + 1 < l3)
                        {
                            b(l15, j16, k13 + 54, 9 * byte3, 9, 9);
                        }
                        if(k12 * 2 + 1 == l3)
                        {
                            b(l15, j16, k13 + 63, 9 * byte3, 9, 9);
                        }
                    }
                    if(k12 * 2 + 1 < i2)
                    {
                        b(l15, j16, k13 + 36, 9 * byte3, 9, 9);
                    }
                    if(k12 * 2 + 1 == i2)
                    {
                        b(l15, j16, k13 + 45, 9 * byte3, 9, 9);
                    }
                }

                d.J.c("food");
                for(int l12 = 0; l12 < 10; l12++)
                {
                    int l13 = k9;
                    int i15 = 16;
                    byte byte2 = 0;
                    if(d.g.a(mk.s))
                    {
                        i15 += 36;
                        byte2 = 13;
                    }
                    if(d.g.cl().e() <= 0.0F && f % (j6 * 3 + 1) == 0)
                    {
                        l13 += c.nextInt(3) - 1;
                    }
                    if(flag3)
                    {
                        byte2 = 1;
                    }
                    int k16 = j8 - l12 * 8 - 9;
                    b(k16, l13, 16 + byte2 * 9, 27, 9, 9);
                    if(flag3)
                    {
                        if(l12 * 2 + 1 < l6)
                        {
                            b(k16, l13, i15 + 54, 27, 9, 9);
                        }
                        if(l12 * 2 + 1 == l6)
                        {
                            b(k16, l13, i15 + 63, 27, 9, 9);
                        }
                    }
                    if(l12 * 2 + 1 < j6)
                    {
                        b(k16, l13, i15 + 36, 27, 9, 9);
                    }
                    if(l12 * 2 + 1 == j6)
                    {
                        b(k16, l13, i15 + 45, 27, 9, 9);
                    }
                }

                d.J.c("air");
                if(d.g.a(ahz.h))
                {
                    int i13 = d.g.ak();
                    int i14 = kx.f(((double)(i13 - 2) * 10D) / 300D);
                    int j15 = kx.f(((double)i13 * 10D) / 300D) - i14;
                    for(int i16 = 0; i16 < i14 + j15; i16++)
                    {
                        if(i16 < i14)
                        {
                            b(j8 - i16 * 8 - 9, k10, 16, 18, 9, 9);
                        } else
                        {
                            b(j8 - i16 * 8 - 9, k10, 25, 18, 9, 9);
                        }
                    }

                }
                d.J.b();
            }
            GL11.glDisable(3042);
            d.J.a("actionBar");
            GL11.glEnable(32826);
            auv.c();
            for(int k7 = 0; k7 < 9; k7++)
            {
                int k8 = (j1 / 2 - 90) + k7 * 20 + 2;
                int i9 = k1 - 16 - 3;
                a(k7, k8, i9, f1);
            }

            auv.a();
            GL11.glDisable(32826);
            d.J.b();
        }
        if(d.g.ch() > 0)
        {
            d.J.a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int l1 = d.g.ch();
            float f3 = (float)l1 / 100F;
            if(f3 > 1.0F)
            {
                f3 = 1.0F - (float)(l1 - 100) / 10F;
            }
            int j2 = (int)(220F * f3) << 24 | 0x101020;
            a(0, 0, j1, k1, j2);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            d.J.b();
        }
        if(d.b.f() && d.g.cf > 0)
        {
            d.J.a("expLevel");
            boolean flag2 = false;
            int k2 = flag2 ? 0xffffff : 0x80ff20;
            String s2 = (new StringBuilder()).append("").append(d.g.cf).toString();
            int k4 = (j1 - awp1.a(s2)) / 2;
            int k5 = k1 - 31 - 4;
            awp1.b(s2, k4 + 1, k5, 0);
            awp1.b(s2, k4 - 1, k5, 0);
            awp1.b(s2, k4, k5 + 1, 0);
            awp1.b(s2, k4, k5 - 1, 0);
            awp1.b(s2, k4, k5, k2);
            d.J.b();
        }
        if(d.z.D)
        {
            d.J.a("toolHighlight");
            if(k > 0 && l != null)
            {
                String s = l.s();
                int i3 = (j1 - awp1.a(s)) / 2;
                int i4 = k1 - 59;
                if(!d.b.b())
                {
                    i4 += 14;
                }
                int i5 = (int)(((float)k * 256F) / 10F);
                if(i5 > 255)
                {
                    i5 = 255;
                }
                if(i5 > 0)
                {
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    awp1.a(s, i3, i4, 0xffffff + (i5 << 24));
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            d.J.b();
        }
        if(d.q())
        {
            d.J.a("demo");
            String s1 = "";
            if(d.e.G() >= 0x1d6b4L)
            {
                s1 = bo.a("demo.demoExpired");
            } else
            {
                s1 = String.format(bo.a("demo.remainingTime"), new Object[] {
                    lf.a((int)(0x1d6b4L - d.e.G()))
                });
            }
            int j3 = awp1.a(s1);
            awp1.a(s1, j1 - j3 - 10, 5, 0xffffff);
            d.J.b();
        }
		WMLL.i.updategui(d, this);
        if(d.z.ab)
        {
            d.J.a("debug");
            GL11.glPushMatrix();
            awp1.a((new StringBuilder()).append("Minecraft 1.5 (").append(d.L).append(")").toString(), 2, 2, 0xffffff);
            awp1.a(d.m(), 2, 12, 0xffffff);
            awp1.a(d.n(), 2, 22, 0xffffff);
            awp1.a(d.p(), 2, 32, 0xffffff);
            awp1.a(d.o(), 2, 42, 0xffffff);
            long l2 = Runtime.getRuntime().maxMemory();
            long l4 = Runtime.getRuntime().totalMemory();
            long l5 = Runtime.getRuntime().freeMemory();
            long l7 = l4 - l5;
            String s3 = (new StringBuilder()).append("Used memory: ").append((l7 * 100L) / l2).append("% (").append(l7 / 1024L / 1024L).append("MB) of ").append(l2 / 1024L / 1024L).append("MB").toString();
            b(awp1, s3, j1 - awp1.a(s3) - 2, 2, 0xe0e0e0);
            s3 = (new StringBuilder()).append("Allocated memory: ").append((l4 * 100L) / l2).append("% (").append(l4 / 1024L / 1024L).append("MB)").toString();
            b(awp1, s3, j1 - awp1.a(s3) - 2, 12, 0xe0e0e0);
            int l9 = kx.c(d.g.u);
            int l10 = kx.c(d.g.v);
            int l11 = kx.c(d.g.w);
            b(awp1, String.format("x: %.5f (%d) // c: %d (%d)", new Object[] {
                Double.valueOf(d.g.u), Integer.valueOf(l9), Integer.valueOf(l9 >> 4), Integer.valueOf(l9 & 0xf)
            }), 2, 64, 0xe0e0e0);
            b(awp1, String.format("y: %.3f (feet pos, %.3f eyes pos)", new Object[] {
                Double.valueOf(d.g.E.b), Double.valueOf(d.g.v)
            }), 2, 72, 0xe0e0e0);
            b(awp1, String.format("z: %.5f (%d) // c: %d (%d)", new Object[] {
                Double.valueOf(d.g.w), Integer.valueOf(l11), Integer.valueOf(l11 >> 4), Integer.valueOf(l11 & 0xf)
            }), 2, 80, 0xe0e0e0);
            int j12 = kx.c((double)((d.g.A * 4F) / 360F) + 0.5D) & 3;
            b(awp1, (new StringBuilder()).append("f: ").append(j12).append(" (").append(r.c[j12]).append(") / ").append(kx.g(d.g.A)).toString(), 2, 88, 0xe0e0e0);
            if(d.e != null && d.e.f(l9, l10, l11))
            {
                abq abq1 = d.e.d(l9, l11);
                b(awp1, (new StringBuilder()).append("lc: ").append(abq1.h() + 15).append(" b: ").append(abq1.a(l9 & 0xf, l11 & 0xf, d.e.t()).y).append(" bl: ").append(abq1.a(aag.b, l9 & 0xf, l10, l11 & 0xf)).append(" sl: ").append(abq1.a(aag.a, l9 & 0xf, l10, l11 & 0xf)).append(" rl: ").append(abq1.c(l9 & 0xf, l10, l11 & 0xf, 0)).toString(), 2, 96, 0xe0e0e0);
            }
            b(awp1, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", new Object[] {
                Float.valueOf(d.g.ce.b()), Float.valueOf(d.g.ce.a()), Boolean.valueOf(d.g.F), Integer.valueOf(d.e.f(l9, l11))
            }), 2, 104, 0xe0e0e0);
            GL11.glPopMatrix();
            d.J.b();
        }
        if(h > 0)
        {
            d.J.a("overlayMessage");
            float f4 = (float)h - f1;
            int k3 = (int)((f4 * 256F) / 20F);
            if(k3 > 255)
            {
                k3 = 255;
            }
            if(k3 > 0)
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(j1 / 2, k1 - 48, 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int j4 = 0xffffff;
                if(i)
                {
                    j4 = Color.HSBtoRGB(f4 / 50F, 0.7F, 0.6F) & 0xffffff;
                }
                awp1.b(g, -awp1.a(g) / 2, -4, j4 + (k3 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            d.J.b();
        }
        aqy aqy1 = d.e.V().a(1);
        if(aqy1 != null)
        {
            a(aqy1, k1, j1, awp1);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, k1 - 48, 0.0F);
        d.J.a("chat");
        e.a(f);
        d.J.b();
        GL11.glPopMatrix();
        aqy1 = d.e.V().a(0);
        if(d.z.T.e && (!d.B() || d.g.a.c.size() > 1 || aqy1 != null))
        {
            d.J.a("playerList");
            bde bde1 = d.g.a;
            java.util.List list = bde1.c;
            int j5 = bde1.d;
            int i6 = j5;
            int k6 = 1;
            for(; i6 > 20; i6 = ((j5 + k6) - 1) / k6)
            {
                k6++;
            }

            int i7 = 300 / k6;
            if(i7 > 150)
            {
                i7 = 150;
            }
            int i8 = (j1 - k6 * i7) / 2;
            byte byte0 = 10;
            a(i8 - 1, byte0 - 1, i8 + i7 * k6, byte0 + 9 * i6, 0x80000000);
            for(int j9 = 0; j9 < j5; j9++)
            {
                int i10 = i8 + (j9 % k6) * i7;
                int i11 = byte0 + (j9 / k6) * 9;
                a(i10, i11, (i10 + i7) - 1, i11 + 8, 0x20ffffff);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glEnable(3008);
                if(j9 >= list.size())
                {
                    continue;
                }
                bdq bdq1 = (bdq)list.get(j9);
                aqz aqz1 = d.e.V().i(bdq1.a);
                String s4 = aqz.a(aqz1, bdq1.a);
                awp1.a(s4, i10, i11, 0xffffff);
                if(aqy1 != null)
                {
                    int j14 = i10 + awp1.a(s4) + 5;
                    int k15 = (i10 + i7) - 12 - 5;
                    if(k15 - j14 > 5)
                    {
                        ara ara1 = aqy1.a().a(bdq1.a, aqy1);
                        String s5 = (new StringBuilder()).append(a.o).append("").append(ara1.c()).toString();
                        awp1.a(s5, k15 - awp1.a(s5), i11, 0xffffff);
                    }
                }
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                d.p.b("/gui/icons.png");
                int k14 = 0;
                byte byte1 = 0;
                if(bdq1.b < 0)
                {
                    byte1 = 5;
                } else
                if(bdq1.b < 150)
                {
                    byte1 = 0;
                } else
                if(bdq1.b < 300)
                {
                    byte1 = 1;
                } else
                if(bdq1.b < 600)
                {
                    byte1 = 2;
                } else
                if(bdq1.b < 1000)
                {
                    byte1 = 3;
                } else
                {
                    byte1 = 4;
                }
                this.j += 100F;
                b((i10 + i7) - 12, i11, 0 + k14 * 10, 176 + byte1 * 8, 10, 8);
                this.j -= 100F;
            }

        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    private void a(aqy aqy1, int j, int i1, awp awp1)
    {
        ard ard1 = aqy1.a();
        Collection collection = ard1.i(aqy1);
        if(collection.size() > 15)
        {
            return;
        }
        int j1 = 0;
        for(Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            ara ara1 = (ara)iterator.next();
            aqz aqz1 = ard1.i(ara1.e());
            String s = (new StringBuilder()).append(aqz.a(aqz1, ara1.e())).append(": ").append(a.m).append(ara1.c()).toString();
            j1 = Math.max(j1, awp1.a(s));
        }

        int k1 = collection.size() * awp1.a;
        int l1 = j / 2 + k1 / 3;
        byte byte0 = 3;
        int i2 = i1 - j1 - byte0;
        int j2 = 0;
        Iterator iterator1 = collection.iterator();
        do
        {
            if(!iterator1.hasNext())
            {
                break;
            }
            ara ara2 = (ara)iterator1.next();
            j2++;
            aqz aqz2 = ard1.i(ara2.e());
            String s1 = aqz.a(aqz2, ara2.e());
            String s2 = (new StringBuilder()).append(a.m).append("").append(ara2.c()).toString();
            int k2 = i2;
            int l2 = l1 - j2 * awp1.a;
            int i3 = (i1 - byte0) + 2;
            a(k2 - 2, l2, i3, l2 + awp1.a, 0x50000000);
            awp1.b(s1, k2, l2, 0x20ffffff);
            awp1.b(s2, i3 - awp1.a(s2), l2, 0x20ffffff);
            if(j2 == collection.size())
            {
                String s3 = aqy1.d();
                a(k2 - 2, l2 - awp1.a - 1, i3, l2 - 1, 0x60000000);
                a(k2 - 2, l2 - 1, i3, l2, 0x50000000);
                awp1.b(s3, (k2 + j1 / 2) - awp1.a(s3) / 2, l2 - awp1.a, 0x20ffffff);
            }
        } while(true);
    }

    private void d()
    {
        if(bff.c == null || bff.b <= 0)
        {
            return;
        }
        bff.b--;
        awp awp1 = d.q;
        axm axm1 = new axm(d.z, d.c, d.d);
        int j = axm1.a();
        char c1 = '\266';
        int i1 = j / 2 - c1 / 2;
        int j1 = (int)(bff.a * (float)(c1 + 1));
        byte byte0 = 12;
        b(i1, byte0, 0, 74, c1, 5);
        b(i1, byte0, 0, 74, c1, 5);
        if(j1 > 0)
        {
            b(i1, byte0, 0, 79, j1, 5);
        }
        String s = bff.c;
        awp1.a(s, j / 2 - awp1.a(s) / 2, byte0 - 10, 0xffffff);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        d.p.b("/gui/icons.png");
    }

    private void a(int j, int i1)
    {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        d.p.b("%blur%/misc/pumpkinblur.png");
        bfx bfx1 = bfx.a;
        bfx1.b();
        bfx1.a(0.0D, i1, -90D, 0.0D, 1.0D);
        bfx1.a(j, i1, -90D, 1.0D, 1.0D);
        bfx1.a(j, 0.0D, -90D, 1.0D, 0.0D);
        bfx1.a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        bfx1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(float f1, int j, int i1)
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
        d.p.b("%blur%/misc/vignette.png");
        bfx bfx1 = bfx.a;
        bfx1.b();
        bfx1.a(0.0D, i1, -90D, 0.0D, 1.0D);
        bfx1.a(j, i1, -90D, 1.0D, 1.0D);
        bfx1.a(j, 0.0D, -90D, 1.0D, 0.0D);
        bfx1.a(0.0D, 0.0D, -90D, 0.0D, 0.0D);
        bfx1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void b(float f1, int j, int i1)
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
        d.p.b("/terrain.png");
        lx lx1 = aou.bi.m(1);
        float f2 = lx1.e();
        float f3 = lx1.g();
        float f4 = lx1.f();
        float f5 = lx1.h();
        bfx bfx1 = bfx.a;
        bfx1.b();
        bfx1.a(0.0D, i1, -90D, f2, f5);
        bfx1.a(j, i1, -90D, f4, f5);
        bfx1.a(j, 0.0D, -90D, f4, f3);
        bfx1.a(0.0D, 0.0D, -90D, f2, f3);
        bfx1.a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void a(int j, int i1, int j1, float f1)
    {
        wg wg1 = d.g.bK.a[j];
        if(wg1 == null)
        {
            return;
        }
        float f2 = (float)wg1.b - f1;
        if(f2 > 0.0F)
        {
            GL11.glPushMatrix();
            float f3 = 1.0F + f2 / 5F;
            GL11.glTranslatef(i1 + 8, j1 + 12, 0.0F);
            GL11.glScalef(1.0F / f3, (f3 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(i1 + 8), -(j1 + 12), 0.0F);
        }
        b.b(d.q, d.p, wg1, i1, j1);
        if(f2 > 0.0F)
        {
            GL11.glPopMatrix();
        }
        b.c(d.q, d.p, wg1, i1, j1);
    }

    public void a()
    {
        if(h > 0)
        {
            h--;
        }
        f++;
        if(d.g != null)
        {
            wg wg1 = d.g.bK.h();
            if(wg1 == null)
            {
                k = 0;
            } else
            if(l == null || wg1.c != l.c || !wg.a(wg1, l) || !wg1.g() && wg1.k() != l.k())
            {
                k = 40;
            } else
            if(k > 0)
            {
                k--;
            }
            l = wg1;
        }
    }

    public void a(String s)
    {
        g = (new StringBuilder()).append("Now playing: ").append(s).toString();
        h = 60;
        i = true;
    }

    public awb b()
    {
        return e;
    }

    public int c()
    {
        return f;
    }

}
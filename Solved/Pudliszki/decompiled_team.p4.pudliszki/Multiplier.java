/*
 * Decompiled with CFR 0.140.
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\t"}, d2={"Lteam/p4/pudliszki/Multiplier;", "", "m", "", "(I)V", "getM", "()I", "setM", "get", "pudliszki"})
public final class Multiplier {
    private int m;

    public final int get() {
        this.m *= 32;
        return this.m / 32;
    }

    public final int getM() {
        return this.m;
    }

    public final void setM(int n2) {
        this.m = n2;
    }

    public Multiplier(int m) {
        this.m = m;
    }

    public /* synthetic */ Multiplier(int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 1;
        }
        this(n2);
    }

    public Multiplier() {
        this(0, 1, null);
    }
}


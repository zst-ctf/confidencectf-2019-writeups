/*
 * Decompiled with CFR 0.140.
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2={"Lteam/p4/pudliszki/FlagChar;", "T", "", "c", "(Ljava/lang/Object;)V", "getC", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lteam/p4/pudliszki/FlagChar;", "equals", "", "other", "hashCode", "", "toString", "", "pudliszki"})
public final class FlagChar<T> {
    private final T c;

    public final T getC() {
        return this.c;
    }

    public FlagChar(T c2) {
        this.c = c2;
    }

    public final T component1() {
        return this.c;
    }

    @NotNull
    public final FlagChar<T> copy(T c2) {
        return new FlagChar<T>(c2);
    }

    @NotNull
    public static /* synthetic */ FlagChar copy$default(FlagChar flagChar, Object object, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            object = flagChar.c;
        }
        return flagChar.copy(object);
    }

    @NotNull
    public String toString() {
        return "FlagChar(c=" + this.c + ")";
    }

    public int hashCode() {
        T t2 = this.c;
        return t2 != null ? t2.hashCode() : 0;
    }

    public boolean equals(@Nullable Object object) {
        block3 : {
            block2 : {
                if (this == object) break block2;
                if (!(object instanceof FlagChar)) break block3;
                FlagChar flagChar = (FlagChar)object;
                if (!Intrinsics.areEqual(this.c, flagChar.c)) break block3;
            }
            return true;
        }
        return false;
    }
}


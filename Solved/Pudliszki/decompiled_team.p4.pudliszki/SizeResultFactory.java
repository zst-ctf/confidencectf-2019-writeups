/*
 * Decompiled with CFR 0.140.
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import team.p4.pudliszki.Correct;
import team.p4.pudliszki.Incorrect;
import team.p4.pudliszki.SizeResult;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2={"Lteam/p4/pudliszki/SizeResultFactory;", "", "()V", "Companion", "pudliszki"})
public final class SizeResultFactory {
    public static final Companion Companion = new Companion(null);

    @Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t\u00a8\u0006\n"}, d2={"Lteam/p4/pudliszki/SizeResultFactory$Companion;", "", "()V", "check", "Lteam/p4/pudliszki/SizeResult;", "T", "i", "", "c", "Ljava/lang/Class;", "pudliszki"})
    public static final class Companion {
        @NotNull
        public final <T> SizeResult check(int i2, @NotNull Class<T> c2) {
            Intrinsics.checkParameterIsNotNull(c2, "c");
            return i2 == c2.getSimpleName().length() ? (SizeResult)Correct.INSTANCE : (SizeResult)Incorrect.INSTANCE;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

}


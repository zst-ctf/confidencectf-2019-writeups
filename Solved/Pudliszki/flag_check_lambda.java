pudliszki $ java -jar ~/Desktop/cfr-0.140.jar /pudliszki-1.0-SNAPSHOT-jar-with-dependencies/team/p4/pudliszki/FlagCheckerKt\$validateFlag\$1.class 
/*
 * Decompiled with CFR 0.140.
 * 
 * Could not load the following classes:
 *  team.p4.pudliszki.FlagCheckerKt$validateFlag
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import team.p4.pudliszki.FlagChar;
import team.p4.pudliszki.FlagCheckerKt;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=3, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "Lteam/p4/pudliszki/FlagChar;", "", "c", "invoke"})
static final class FlagCheckerKt.validateFlag.1
extends Lambda
implements Function1<Character, FlagChar<Character>> {
    public static final FlagCheckerKt.validateFlag.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    @NotNull
    @Override
    public final FlagChar<Character> invoke(char c) {
        return new FlagChar<Character>(Character.valueOf(c));
    }

    FlagCheckerKt.validateFlag.1() {
    }
}
pudliszki $ java -jar ~/Desktop/cfr-0.140.jar /pudliszki-1.0-SNAPSHOT-jar-with-dependencies/team/p4/pudliszki/FlagCheckerKt\$validateFlag\$2.class 
/*
 * Decompiled with CFR 0.140.
 * 
 * Could not load the following classes:
 *  team.p4.pudliszki.FlagCheckerKt$validateFlag
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import team.p4.pudliszki.FlagChar;
import team.p4.pudliszki.FlagCheckerKt;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=3, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "c", "Lteam/p4/pudliszki/FlagChar;", "", "invoke"})
static final class FlagCheckerKt.validateFlag.2
extends Lambda
implements Function1<FlagChar<Character>, Boolean> {
    public static final FlagCheckerKt.validateFlag.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    @Override
    public final boolean invoke(@NotNull FlagChar<Character> c) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        boolean $i$f$validateChar = false;
        Character c2 = c.getC();
        return c2 instanceof Character ? true : (c2 instanceof String ? false : false);
    }

    FlagCheckerKt.validateFlag.2() {
    }
}
pudliszki $ java -jar ~/Desktop/cfr-0.140.jar /pudliszki-1.0-SNAPSHOT-jar-with-dependencies/team/p4/pudliszki/FlagCheckerKt\$validateFlag\$3.class 
/*
 * Decompiled with CFR 0.140.
 * 
 * Could not load the following classes:
 *  team.p4.pudliszki.FlagCheckerKt$validateFlag
 */
package team.p4.pudliszki;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import team.p4.pudliszki.FlagChar;
import team.p4.pudliszki.FlagCheckerKt;

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=3, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n\u00a2\u0006\u0002\b\u0007"}, d2={"<anonymous>", "Lkotlin/Pair;", "Lteam/p4/pudliszki/FlagChar;", "", "", "i", "c", "invoke"})
static final class FlagCheckerKt.validateFlag.3
extends Lambda
implements Function2<Integer, FlagChar<Character>, Pair<? extends FlagChar<Character>, ? extends Integer>> {
    public static final FlagCheckerKt.validateFlag.3 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    @NotNull
    @Override
    public final Pair<FlagChar<Character>, Integer> invoke(int i, @NotNull FlagChar<Character> c) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        return new Pair<FlagChar<Character>, Integer>(c, i);
    }

    FlagCheckerKt.validateFlag.3() {
    }
}

/*
 * Decompiled with CFR 0.140.
 * 
 * Could not load the following classes:
 *  team.p4.pudliszki.FlagCheckerKt$compress
 *  team.p4.pudliszki.FlagCheckerKt$validateFlag
 */
package team.p4.pudliszki;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import team.p4.pudliszki.0;
import team.p4.pudliszki.1;
import team.p4.pudliszki.4;
import team.p4.pudliszki.5;
import team.p4.pudliszki.7;
import team.p4.pudliszki.A;
import team.p4.pudliszki.Correct;
import team.p4.pudliszki.FlagChar;
import team.p4.pudliszki.FlagCheckerKt;
import team.p4.pudliszki.Incorrect;
import team.p4.pudliszki.Multiplier;
import team.p4.pudliszki.SizeResult;
import team.p4.pudliszki.SizeResultFactory;
import team.p4.pudliszki._;
import team.p4.pudliszki.c;
import team.p4.pudliszki.e;
import team.p4.pudliszki.h;
import team.p4.pudliszki.i;
import team.p4.pudliszki.k;
import team.p4.pudliszki.l;
import team.p4.pudliszki.n;
import team.p4.pudliszki.p;
import team.p4.pudliszki.s;
import team.p4.pudliszki.t;
import team.p4.pudliszki.u;
import team.p4.pudliszki.{;
import team.p4.pudliszki.};

@Metadata(mv={1, 1, 13}, bv={1, 0, 3}, k=2, d1={"\u0000:\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u001a\u0019\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0086\b\u001a\u000e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\f\u00a8\u0006\u0015"}, d2={"checksum", "", "grouped", "", "", "", "compress", "value", "main", "", "args", "", "", "([Ljava/lang/String;)V", "validateChar", "", "T", "c", "Lteam/p4/pudliszki/FlagChar;", "validateFlag", "flag", "pudliszki"})
public final class FlagCheckerKt {
    /*
     * Enabled aggressive block sorting
     */
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        String[] $receiver = args;
        boolean bl = false;
        SizeResult sizeResult = SizeResultFactory.Companion.check($receiver.length, A.class);
        if (!(sizeResult instanceof Correct)) {
            if (!(sizeResult instanceof Incorrect)) return;
            String string = "Failed";
            System.out.print((Object)string);
            int n2 = -1;
            System.exit(n2);
            throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (FlagCheckerKt.validateFlag($receiver[0]) == 0) {
            String string = "Nice!";
            System.out.print((Object)string);
            return;
        }
        String string = "Not today";
        System.out.print((Object)string);
        int n3 = -1;
        System.exit(n3);
        throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final int validateFlag(@NotNull String flag) {
        Intrinsics.checkParameterIsNotNull(flag, "flag");
        SizeResult sizeResult = SizeResultFactory.Companion.check(flag.length(), IllegalMonitorStateException.class);
        if (sizeResult instanceof Correct) {
            void $receiver$iv$iv;
            Sequence $receiver$iv22 = SequencesKt.mapIndexed(SequencesKt.filter(SequencesKt.map(StringsKt.asSequence(flag), validateFlag.1.INSTANCE), validateFlag.2.INSTANCE), validateFlag.3.INSTANCE);
            Sequence sequence = $receiver$iv22;
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $receiver$iv$iv) {
                Object object;
                Pair c2 = (Pair)element$iv$iv;
                boolean bl = false;
                Map $receiver$iv$iv$iv = destination$iv$iv;
                Character key$iv$iv = Character.valueOf(((Character)((FlagChar)c2.getFirst()).getC()).charValue());
                Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    ArrayList answer$iv$iv$iv = new ArrayList();
                    $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object = answer$iv$iv$iv;
                } else {
                    object = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object;
                c2 = (Pair)element$iv$iv;
                List list = list$iv$iv;
                boolean bl2 = false;
                Integer n2 = ((Number)c2.getSecond()).intValue();
                list.add(n2);
            }
            return FlagCheckerKt.checksum(destination$iv$iv);
        }
        if (sizeResult instanceof Incorrect) {
            String $receiver$iv22 = "Failed";
            System.out.print((Object)$receiver$iv22);
            int $receiver$iv22 = -1;
            System.exit($receiver$iv22);
            throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final <T> boolean validateChar(FlagChar<T> c2) {
        int $i$f$validateChar = 0;
        T t2 = c2.getC();
        if (t2 instanceof Character) {
            return true;
        }
        if (t2 instanceof String) {
            return false;
        }
        return false;
    }

    public static final int checksum(@NotNull Map<Character, ? extends List<Integer>> grouped) {
        Intrinsics.checkParameterIsNotNull(grouped, "grouped");
        try {
            Collection collection;
            void $receiver$iv$iv232;
            Object $receiver$iv$iv;
            Serializable serializable;
            Object $receiver$iv = grouped;
            Map<Character, ? extends List<Integer>> map = $receiver$iv;
            Collection destination$iv$iv = new ArrayList($receiver$iv.size());
            Iterator iterator2 = $receiver$iv$iv;
            Iterator iterator3 = iterator2.entrySet().iterator();
            while (iterator3.hasNext()) {
                void entry;
                Map.Entry item$iv$iv;
                Map.Entry entry2 = item$iv$iv = iterator3.next();
                collection = destination$iv$iv;
                boolean bl2 = false;
                serializable = new Pair(Class.forName("team.p4.pudliszki." + String.valueOf(((Character)entry.getKey()).charValue())).newInstance(), FlagCheckerKt.compress((List)entry.getValue()));
                collection.add(serializable);
            }
            $receiver$iv = (List)destination$iv$iv;
            $receiver$iv$iv = $receiver$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv2 : $receiver$iv$iv232) {
                void entry;
                Pair item$iv$iv = (Pair)item$iv$iv2;
                collection = destination$iv$iv;
                boolean bl = false;
                Object bl2 = entry.getFirst();
                serializable = bl2 instanceof p ? ((Number)entry.getSecond()).intValue() - 27040 : (bl2 instanceof 4 ? ((Number)entry.getSecond()).intValue() - 1 : (bl2 instanceof { ? ((Number)entry.getSecond()).intValue() - 2 : (bl2 instanceof 0 ? ((Number)entry.getSecond()).intValue() - 452 : (bl2 instanceof 1 ? ((Number)entry.getSecond()).intValue() - 327 : (bl2 instanceof 5 ? ((Number)entry.getSecond()).intValue() - 17 : (bl2 instanceof 7 ? ((Number)entry.getSecond()).intValue() - 22 : (bl2 instanceof c ? ((Number)entry.getSecond()).intValue() - 23 : (bl2 instanceof e ? ((Number)entry.getSecond()).intValue() - 21 : (bl2 instanceof h ? ((Number)entry.getSecond()).intValue() - 786 : (bl2 instanceof i ? ((Number)entry.getSecond()).intValue() - 16 : (bl2 instanceof k ? ((Number)entry.getSecond()).intValue() - 643 : (bl2 instanceof l ? ((Number)entry.getSecond()).intValue() - 486 : (bl2 instanceof n ? ((Number)entry.getSecond()).intValue() - 8 : (bl2 instanceof s ? ((Number)entry.getSecond()).intValue() - 11 : (bl2 instanceof t ? ((Number)entry.getSecond()).intValue() - 5 : (bl2 instanceof u ? ((Number)entry.getSecond()).intValue() - 25 : (bl2 instanceof _ ? ((Number)entry.getSecond()).intValue() - 19849 : (bl2 instanceof } ? ((Number)entry.getSecond()).intValue() - 27 : -1337))))))))))))))))));
                collection.add(serializable);
            }
            return CollectionsKt.sumOfInt((List)destination$iv$iv);
        }
        catch (ClassNotFoundException e2) {
            String $receiver$iv$iv232 = "Failed";
            System.out.print((Object)$receiver$iv$iv232);
            int $receiver$iv$iv232 = -1;
            System.exit($receiver$iv$iv232);
            throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public static final int compress(@NotNull List<Integer> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Multiplier m = new Multiplier(0, 1, null);
        return SequencesKt.sumOfInt(SequencesKt.map(CollectionsKt.asSequence((Iterable)value), (Function1)new Function1<Integer, Integer>(m){
            final /* synthetic */ Multiplier $m;

            public final int invoke(int v) {
                return v * this.$m.get();
            }
            {
                this.$m = multiplier;
                super(1);
            }
        }));
    }
}


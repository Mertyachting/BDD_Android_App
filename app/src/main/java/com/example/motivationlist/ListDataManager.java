package com.example.motivationlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"},
        d2 = {"Lcom/kukicsevindik/motivationallist/ListDataManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readLists", "Ljava/util/ArrayList;", "Lcom/kukicsevindik/motivationallist/TaskList;", "Lkotlin/collections/ArrayList;", "saveList", "", "list", "app_debug"}
)
public final class ListDataManager {
    @NotNull
    private final Context context;

    public final void saveList(@NotNull TaskList list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Editor sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        sharedPreferences.putStringSet(list.getName(), (Set)CollectionsKt.toHashSet((Iterable)list.getTasks()));
        sharedPreferences.apply();
    }

    @NotNull
    public final ArrayList readLists() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "sharedPreferences");
        Map sharedPreferenceContents = sharedPreferences.getAll();
        ArrayList taskLists = new ArrayList();
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferenceContents, "sharedPreferenceContents");
        boolean var7 = false;
        Iterator var5 = sharedPreferenceContents.entrySet().iterator();

        while(var5.hasNext()) {
            Entry preferenceItem = (Entry)var5.next();
            Object var10000 = preferenceItem.getValue();
            if (var10000 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashSet<kotlin.String> /* = java.util.HashSet<kotlin.String> */");
            }

            HashSet itemsHashSet = (HashSet)var10000;
            TaskList list = new TaskList((String)preferenceItem.getKey(), new ArrayList((Collection)itemsHashSet));
            taskLists.add(list);
        }

        return taskLists;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public ListDataManager(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super();
        this.context = context;
    }
}

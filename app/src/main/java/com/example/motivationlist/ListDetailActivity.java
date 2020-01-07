package com.example.motivationlist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 1, 15},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"},
        d2 = {"Lcom/kukicsevindik/motivationallist/ListDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addTaskButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getAddTaskButton", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "setAddTaskButton", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "list", "Lcom/kukicsevindik/motivationallist/TaskList;", "getList", "()Lcom/kukicsevindik/motivationallist/TaskList;", "setList", "(Lcom/kukicsevindik/motivationallist/TaskList;)V", "listItemsRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getListItemsRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setListItemsRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showCreateTaskDialog", "app_debug"}
)
public final class ListDetailActivity extends AppCompatActivity {
    @NotNull
    public TaskList list;
    @NotNull
    public RecyclerView listItemsRecyclerView;
    @NotNull
    public FloatingActionButton addTaskButton;
    private HashMap _$_findViewCache;

    @NotNull
    public final TaskList getList() {
        TaskList var10000 = this.list;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list");
        }

        return var10000;
    }

    public final void setList(@NotNull TaskList var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.list = var1;
    }

    @NotNull
    public final RecyclerView getListItemsRecyclerView() {
        RecyclerView var10000 = this.listItemsRecyclerView;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listItemsRecyclerView");
        }

        return var10000;
    }

    public final void setListItemsRecyclerView(@NotNull RecyclerView var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.listItemsRecyclerView = var1;
    }

    @NotNull
    public final FloatingActionButton getAddTaskButton() {
        FloatingActionButton var10000 = this.addTaskButton;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addTaskButton");
        }

        return var10000;
    }

    public final void setAddTaskButton(@NotNull FloatingActionButton var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.addTaskButton = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(-1300024);
        Parcelable var10001 = this.getIntent().getParcelableExtra(MainActivity.Companion.getINTENT_LIST_KEY());
        Intrinsics.checkExpressionValueIsNotNull(var10001, "intent.getParcelableExtr…Activity.INTENT_LIST_KEY)");
        this.list = (TaskList)var10001;
        TaskList var3 = this.list;
        if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list");
        }

        this.setTitle((CharSequence)var3.getName());
        View var4 = this.findViewById(-1000164);
        Intrinsics.checkExpressionValueIsNotNull(var4, "findViewById<RecyclerVie….list_items_recyclerview)");
        this.listItemsRecyclerView = (RecyclerView)var4;
        RecyclerView var10000 = this.listItemsRecyclerView;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listItemsRecyclerView");
        }

        var10000.setLayoutManager((LayoutManager)(new LinearLayoutManager((Context)this)));
        var10000 = this.listItemsRecyclerView;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listItemsRecyclerView");
        }

        ListItemsRecyclerViewAdapter var5 = new ListItemsRecyclerViewAdapter;
        TaskList var10003 = this.list;
        if (var10003 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list");
        }

        var5.<init>(var10003);
        var10000.setAdapter((Adapter)var5);
        var4 = this.findViewById(-1000009);
        Intrinsics.checkExpressionValueIsNotNull(var4, "findViewById<FloatingAct…on>(R.id.add_task_button)");
        this.addTaskButton = (FloatingActionButton)var4;
        FloatingActionButton var2 = this.addTaskButton;
        if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addTaskButton");
        }

        var2.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                ListDetailActivity.this.showCreateTaskDialog();
            }
        }));
    }

    private final void showCreateTaskDialog() {
        final EditText taskEditText = new EditText((Context)this);
        taskEditText.setInputType(1);
        (new Builder((Context)this)).setTitle(-1900026).setView((View)taskEditText).setPositiveButton(-1900028, (android.content.DialogInterface.OnClickListener)(new android.content.DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialog, int $noName_1) {
                String task = taskEditText.getText().toString();
                ListDetailActivity.this.getList().getTasks().add(task);
                Adapter var10000 = ListDetailActivity.this.getListItemsRecyclerView().getAdapter();
                if (var10000 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.kukicsevindik.motivationallist.ListItemsRecyclerViewAdapter");
                } else {
                    ListItemsRecyclerViewAdapter recyclerAdapter = (ListItemsRecyclerViewAdapter)var10000;
                    recyclerAdapter.notifyItemInserted(ListDetailActivity.this.getList().getTasks().size());
                    dialog.dismiss();
                }
            }
        })).create().show();
    }

    public void onBackPressed() {
        Bundle bundle = new Bundle();
        String var10001 = MainActivity.Companion.getINTENT_LIST_KEY();
        TaskList var10002 = this.list;
        if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list");
        }

        bundle.putParcelable(var10001, (Parcelable)var10002);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        this.setResult(-1, intent);
        super.onBackPressed();
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}

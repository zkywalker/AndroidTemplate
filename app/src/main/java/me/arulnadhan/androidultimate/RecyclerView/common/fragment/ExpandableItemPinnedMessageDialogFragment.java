package me.arulnadhan.androidultimate.RecyclerView.common.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;

import me.arulnadhan.androidultimate.R;


public class ExpandableItemPinnedMessageDialogFragment extends DialogFragment {
    private static final String KEY_GROUP_ITEM_POSITION = "group_position";
    private static final String KEY_CHILD_ITEM_POSITION = "child_position";

    public interface EventListener {
        void onNotifyExpandableItemPinnedDialogDismissed(int groupPosition, int childPosition, boolean ok);
    }

    public static ExpandableItemPinnedMessageDialogFragment newInstance(int groupPosition, int childPosition) {
        final ExpandableItemPinnedMessageDialogFragment frag = new ExpandableItemPinnedMessageDialogFragment();
        final Bundle args = new Bundle();

        args.putInt(KEY_GROUP_ITEM_POSITION, groupPosition);
        args.putInt(KEY_CHILD_ITEM_POSITION, childPosition);

        frag.setArguments(args);
        return frag;
    }

    public ExpandableItemPinnedMessageDialogFragment() {
        super();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final int groupPosition = getArguments().getInt(KEY_GROUP_ITEM_POSITION, Integer.MIN_VALUE);
        final int childPosition = getArguments().getInt(KEY_CHILD_ITEM_POSITION, Integer.MIN_VALUE);

        // for expandable list
        if (childPosition == RecyclerView.NO_POSITION) {
            builder.setMessage(getString(R.string.dialog_message_group_item_pinned, groupPosition));
        } else {
            builder.setMessage(getString(R.string.dialog_message_child_item_pinned, groupPosition, childPosition));
        }
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                notifyItemPinnedDialogDismissed(true);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setCancelable(true);
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        notifyItemPinnedDialogDismissed(false);
    }

    private void notifyItemPinnedDialogDismissed(boolean ok) {
        final int groupPosition = getArguments().getInt(KEY_GROUP_ITEM_POSITION);
        final int childPosition = getArguments().getInt(KEY_CHILD_ITEM_POSITION);
        ((EventListener) getActivity()).onNotifyExpandableItemPinnedDialogDismissed(groupPosition, childPosition, ok);
    }

}

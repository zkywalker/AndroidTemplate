package me.arulnadhan.androidultimate.RecyclerView.common.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import me.arulnadhan.androidultimate.R;


public class ItemPinnedMessageDialogFragment extends DialogFragment {
    private static final String KEY_ITEM_POSITION = "position";

    public interface EventListener {
        void onNotifyItemPinnedDialogDismissed(int position, boolean ok);
    }

    public static ItemPinnedMessageDialogFragment newInstance(int position) {
        final ItemPinnedMessageDialogFragment frag = new ItemPinnedMessageDialogFragment();
        final Bundle args = new Bundle();

        args.putInt(KEY_ITEM_POSITION, position);

        frag.setArguments(args);
        return frag;
    }

    public ItemPinnedMessageDialogFragment() {
        super();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final int itemPosition = getArguments().getInt(KEY_ITEM_POSITION, Integer.MIN_VALUE);

        builder.setMessage(getString(R.string.dialog_message_item_pinned, itemPosition));
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
        final int position = getArguments().getInt(KEY_ITEM_POSITION);
        ((EventListener) getActivity()).onNotifyItemPinnedDialogDismissed(position, ok);
    }

}

package org.lenndi.umbono.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.lenndi.umbono.R;
import org.lenndi.umbono.entity.Loan;
import org.lenndi.umbono.entity.record.Record;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class LoanAdapter extends ArrayAdapter<Loan> {

    public LoanAdapter(Context context, List<Loan> loans) {
        super(context, 0, loans);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Format dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.activity_loan_row,parent, false);
        }

        LoanViewHolder viewHolder = (LoanViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new LoanViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.itemTitle);
            viewHolder.date = (TextView) convertView.findViewById(R.id.itemDate);
            viewHolder.author = (TextView) convertView.findViewById(R.id.itemAuthor);
            viewHolder.returnDate = (TextView) convertView.findViewById(R.id.itemReturnDate);

            convertView.setTag(viewHolder);
        }

        Loan loan = getItem(position);
        Record record = loan.getItem().getRecord();
        String authorFullName = record.getCreator().getName()
                + " " + record.getCreator().getSecondName();

        viewHolder.title.setText(record.getTitle().getMainTitle());
        viewHolder.date.setText(record.getDate().getPublicationDate());
        viewHolder.author.setText(authorFullName);
        viewHolder.returnDate.setText(dateFormat.format(loan.getEnd()));

        return convertView;
    }

    private class LoanViewHolder {
        TextView title;
        TextView date;
        TextView author;
        TextView returnDate;
    }
}

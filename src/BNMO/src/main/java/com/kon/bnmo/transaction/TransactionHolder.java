package com.kon.bnmo.transaction;

import com.kon.bnmo.holder.holder;

public class TransactionHolder extends holder<Transaction>{
    public TransactionHolder(){
        super("Transaction");
    }
    @Override
    public void add(Transaction transaction) {
        int index = this.list.indexOf(transaction);
        if (index == -1) {
            this.list.add(transaction);
        }
    }
    @Override
    public void remove(Transaction transaction) {
        this.list.remove(transaction);
    }
}

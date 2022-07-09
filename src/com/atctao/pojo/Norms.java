package com.atctao.pojo;

public class Norms {
    private String sortId;
    private String chengfen;
    private String content;

    public Norms() {
    }

    public Norms(String sort_id, String chengfen, String content) {
        this.sortId = sort_id;
        this.chengfen = chengfen;
        this.content = content;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getChengfen() {
        return chengfen;
    }

    public void setChengfen(String chengfen) {
        this.chengfen = chengfen;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Norms{" +
                "sortId='" + sortId + '\'' +
                ", chengfen='" + chengfen + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

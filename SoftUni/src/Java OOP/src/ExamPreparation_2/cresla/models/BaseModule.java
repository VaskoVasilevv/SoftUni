package ExamPreparation_2.cresla.models;

import ExamPreparation_2.cresla.interfaces.Module;

public abstract class BaseModule implements Module {
    private int id;

    protected BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" Module - ").append(getId()).append(System.lineSeparator());

        return sb.toString();
    }
}

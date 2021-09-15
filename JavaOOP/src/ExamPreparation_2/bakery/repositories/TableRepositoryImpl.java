package ExamPreparation_2.bakery.repositories;
//created by J.M.

import ExamPreparation_2.bakery.entities.tables.interfaces.Table;
import ExamPreparation_2.bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {

    private final Collection<Table> models;

    public TableRepositoryImpl() {

        this.models = new ArrayList<>();
    }

    @Override
    public Table getByNumber(int number) {

        return this.models.stream().filter(e -> e.getTableNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAll() {

        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Table table) {

        this.models.add(table);
    }

}

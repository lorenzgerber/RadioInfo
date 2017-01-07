/*
 * ProgramTableModel
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
package model;

import javax.swing.table.AbstractTableModel;

/**
 * ProgramTableModel Class
 *
 * This is a model for the JTable that extends
 * the AbstractTableModel. It takes a ProgramListModel
 * as data container. The model it's limitation for the
 * specific use-case: it is not intended to update data
 * in place, rather the whole ProgramListModel is renewed.
 * The UI update events had to be adapted accordingly and
 * don't follow the common TableModel principle fully.
 */
public class ProgramTableModel extends AbstractTableModel {

    private ProgramListModel programList;

    /**
     * ProgramTableModel
     * Constructor that takes the data container
     * ProgramTableModel as argument.
     * @param programList ProgramListModel data container
     */
    public ProgramTableModel(ProgramListModel programList){
        this.programList = programList;
    }

    /**
     * renewData
     * method used to renew the complete data container
     * @param programList ProgramListModel data container
     */
    public void renewData(ProgramListModel programList){
        this.programList = programList;
        this.fireTableDataChanged();
    };

    @Override
    public int getRowCount() {
        return programList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0 : return programList.get(rowIndex).getName();
            case 1 : return programList.get(rowIndex).getStartTime();
            case 2 : return programList.get(rowIndex).getEndTime();
        }

        return null;
    }



}

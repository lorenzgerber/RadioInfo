package model;

import javax.swing.table.AbstractTableModel;

/**
 * Created by loge on 2017-01-02.
 */
public class ProgramTableModel extends AbstractTableModel {

    private ProgramListModel programList;

    public ProgramTableModel(ProgramListModel programList){
        this.programList = programList;
    }

    public void setDataVector(Object[][] dataVector){

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

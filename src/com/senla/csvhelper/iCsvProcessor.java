package com.senla.csvhelper;

import java.util.List;

interface iCsvProcessor {

    void writeObject(Object obj) throws Exception;

    List<Object> readList(Class cls) throws Exception;
}

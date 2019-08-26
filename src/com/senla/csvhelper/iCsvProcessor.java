package com.senla.csvhelper;

import java.util.List;

interface ICsvProcessor {

    void writeObject(Object obj) throws Exception;

    List<Object> readList(Class cls) throws Exception;
}
